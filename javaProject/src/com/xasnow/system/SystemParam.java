package system;

import com.sun.org.apache.xml.internal.utils.URI;

public class SystemParam {
    public static void main(String[] args) {
        System.out.println("java.home : " + System.getProperty("java.home"));

        System.out.println("java.class.version : " + System.getProperty("java.class.version"));

        System.out.println("java.class.path : " + System.getProperty("java.class.path"));

        System.out.println("java.library.path : " + System.getProperty("java.library.path"));

        System.out.println("java.io.tmpdir : " + System.getProperty("java.io.tmpdir"));

        System.out.println("java.compiler : " + System.getProperty("java.compiler"));

        System.out.println("java.ext.dirs : " + System.getProperty("java.ext.dirs"));

        System.out.println("user.name : " + System.getProperty("user.name"));

        System.out.println("user.home : " + System.getProperty("user.home"));

        System.out.println("user.dir : " + System.getProperty("user.dir"));

        System.out.println("package: " + SystemParam.class.getPackage().getName());
        System.out.println("os.name : " + System.getProperty("os.name"));
        String OS = System.getProperty("os.name", "generic").toLowerCase();
        System.out.println(OS);
        System.out.println("package: " + SystemParam.class.getPackage().toString());

        String packName = SystemParam.class.getPackage().getName();

                /*URL packurl = new URL(packName);
                System.out.println(packurl.getPath());*/


        //System.out.println(packuri.toURL().getPath());

        System.out.println(packName.replaceAll("//.", "/"));

        System.out.println(System.getProperty("user.dir") + "/" + (SystemParam.class.getPackage().getName()).replaceAll("//.", "/") + "/");
    }
}
