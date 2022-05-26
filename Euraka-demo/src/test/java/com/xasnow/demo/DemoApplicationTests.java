package com.xasnow.demo;

import com.xasnow.demo.euraka.EurekaUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class DemoApplicationTests {

    private String url =  "http://192.9.180.37:8761/eureka/apps";
    @Test
    void contextLoads() {
        EurekaUtil.getAllServiceAddr(url);
    }



    @Test
    void getAppAndAddress() {
        EurekaUtil.getAppAndAddress(url);
    }

}
