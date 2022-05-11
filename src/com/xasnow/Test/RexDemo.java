package Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xasnow
 * @Date 2020/4/24
 */
public class RexDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "/agree/systems/UCBP/service/asprovider/providers/provider%3A%2F%2FDefaultGenericService%3Fapplication%3DUCBP%26application.authorize%3Dfalse%26async%3Dtrue%26backaddress%3D%26dynamic%3Dtrue%26executor%3Dfalse%26expendproperties%3D%26generic%3Dtrue%26host%3D20.1.2.116%26iothreads%3D1%26isSubscribe%3Dfalse%26logicdevice%3DUCBP%26password%3D%26phydevice%3Dphysic_UCBP_provider_20.1.2.116_61100_UCBP_defaultProvider_DefaultGenericService%26physicalgroup%3DdefaultProvider%26pid%3D9110118%26port%3D61100%26protocol.bind%3Dtrue%26protocol.name%3Dabus%26registry.address%3D20.1.2.96%26registry.check%3Dfalse%26registry.default%3Dtrue%26registry.port%3D62310%26retries%3D0%26sdkversion%3D1.0.0%26service%3DDefaultGenericService%26service.token%3Dprovider_20.1.2.116_61100_UCBP_defaultProvider_DefaultGenericService%26timeout%3D0%26timestamp%3D1579338841618%26transporttype%3Dshort%26username%3D";
        String decoderUrl = URLDecoder.decode(str, "UTF-8");
        System.out.println("url: " + decoderUrl);
//        String regex  = "physicalgroup=([a-zA-Z_0-9]+)";
        String regex = "host=(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}).*&physicalgroup=([a-zA-Z_0-9]+)";
//        String regex  = "host=(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})";
        Pattern pattern = Pattern.compile(regex);    // 编译正则表达式
        Matcher matcher = pattern.matcher(decoderUrl);
        boolean matches = matcher.matches();
        boolean b = matcher.find();
        String group = matcher.group(1);
        String group2 = matcher.group(2);
        System.out.println(group);
        System.out.println(group2);
        System.out.println(b);

        int i = matcher.groupCount();
        System.out.println(i);
        System.out.println(matches);
        // positvieLookaheadGroup();
    }

    public static void positvieLookaheadGroup() {
        Pattern pattern = Pattern.compile("(\\d+)\\s+(?=s)(\\w+)");
        String source = "543543   streets";        //"543543   ttreets" 匹配失败
        Matcher matcher = pattern.matcher(source);
        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("group " + i + ":" + matcher.group(i));
            }
        }
    }
}
