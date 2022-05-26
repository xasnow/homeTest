package com.xasnow.demo.euraka;


import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * eureka的工具类
 *
 * @author xasnow
 */
@Slf4j
public class EurekaUtil {

    /**
     * 解析eureka的返回数据
     */
    private static final Pattern BASE_PATTERN_URL = Pattern.compile("(<application><name>.+?</instance></application>)");
    private static final Pattern HOST_PATTERN_URL = Pattern.compile("<homePageUrl>(.+?)</homePageUrl>");
    private static final Pattern NAME_PATTERN_URL = Pattern.compile("<application><name>(.+?)</name>(.+?)</name>");

    /**
     * IP的缓存
     */
    private static ConcurrentHashMap<String, List<String>> IP_CACHE = new ConcurrentHashMap<>();

    /**
     * 缓存的名字
     */
    private final static String IP_NAME = "goodsIp";


    /**
     * 获取服务的所有地址（注册在 eureka server 上的服务）
     *
     * @return
     */
    public static List<String> getAllServiceAddr(String url ) {
        //先查询缓存
        List<String> list = IP_CACHE.get(IP_NAME);
        if (list != null && list.size() > 0) {
            return list;
        }
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.SECONDS).build();
        Request request = new Request.Builder()
                //请求接口 如果需要传参拼接到接口后面
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/xml")
                .get()
                .build();
        Response response = null;
        List<String> result = new ArrayList<>();
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseContent = response.body().string();
                Matcher matcher = BASE_PATTERN_URL.matcher(responseContent);
                while (matcher.find()) {
                    String homepage = matcher.group(1).trim();
                    result.add(homepage);
                }
            }
        } catch (IOException e) {
            log.error("从eureka中查询GOODS的服务实例出错了.原因是 {}", e.getMessage());
            return result;
        }
        log.info("服务地址有：{}, 共 {} 个", result.toString(), result.size());
        IP_CACHE.put(IP_NAME, result);
        return result;
    }

    /**
     * 获取服务和服务地址
     * @param url
     * @return
     */
    public static HashMap<String, String> getAppAndAddress(String url) {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.SECONDS).build();
        Request request = new Request.Builder()
                //请求接口 如果需要传参拼接到接口后面
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/xml")
                .get()
                .build();
        Response response = null;
        List<HashMap<String, String>> result = new ArrayList<>();

        // 存放 服务名称和服务地址
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseContent = response.body().string();
                responseContent = responseContent.replaceAll("\\n|\\r\\n|\\ ", "");
                Matcher baseMatcher = BASE_PATTERN_URL.matcher(responseContent);
                while (baseMatcher.find()) {
                    String application = baseMatcher.group(1).trim();
                    Matcher hostMatcher = HOST_PATTERN_URL.matcher(application);
                    Matcher appMatcher = NAME_PATTERN_URL.matcher(application);
                    if (hostMatcher.find() && appMatcher.find()) {
                        String host = hostMatcher.group(1).trim();
                        String app = appMatcher.group(1).trim();
                        map.put(app,host);
                        log.info("服务名称为{}， 服务地址为：{}", app, host);
                    }
                }
            }
        } catch (IOException e) {
            log.error("从eureka中查询GOODS的服务实例出错了.原因是 {}", e.getMessage());
            return map;
        }
        log.info("服务地址有：{}, 共 {} 个", map.toString(), map.size());
        return map;
    }
}
