package org.vishal;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.Optional;

@Configuration
@ComponentScan("org.clipboardHealth")
@PropertySource("classpath:App.properties")
public class AppConfig {
    public static String executionEnvironment = Optional.of(System.getenv("TEST_EXEC_ENV")).orElseThrow(()->
            new NullPointerException("TEST_EXEC_ENV should be set as environment variable"));
    public static String hostUrl = "http://"+Optional.of(System.getenv("HUB_HOST"))
            .orElseThrow(()-> new NullPointerException("HOST_URL should be set as an environment variable"))+":4444/wd/hub";
}
