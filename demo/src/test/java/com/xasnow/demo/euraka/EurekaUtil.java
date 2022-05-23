package com.xasnow.demo.euraka;


import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * eureka的工具类
 *
 * @author zhangke
 * @time 2019年12月5日18:11:12
 */
@Slf4j
public class EurekaUtil {

    /**
     * 解析eureka的返回数据
     */
    private static Pattern PATTERN_URL = Pattern.compile("<homePageUrl>(.+?)</homePageUrl>");

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
    public static List<String> getAllServiceAddr() {
        //先查询缓存
        List<String> list = IP_CACHE.get(IP_NAME);
        if (list != null && list.size() > 0) {
            return list;
        }
        String serviceName = "GOODS";
//        String url = eurekaIp + "apps/" + serviceName;
        String url = "http://192.9.180.37:8761/eureka/apps";
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
                Matcher matcher = PATTERN_URL.matcher(responseContent);
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

}
