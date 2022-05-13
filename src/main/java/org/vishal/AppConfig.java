package org.vishal;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.util.Optional;

@Configuration
@ComponentScan("org.vishal")
@PropertySource("classpath:App.properties")
public class AppConfig {
    public static String executionEnvironment = Optional.ofNullable(System.getenv("TEST_EXEC_ENV")).orElse("local");

    public static String hostUrl;

    static  {
        if(executionEnvironment.equals("grid")){
            var HUB_HOST = Optional.ofNullable(System.getenv("HUB_HOST"))
                    .orElseThrow(()-> new NullPointerException("HUB_HOST should be set as an environment variable"));
            var HUB_PORT  =  Optional.ofNullable(System.getenv("HUB_PORT")).orElse("4444");
            hostUrl= String.format("http://%s:%s/wd/hub", HUB_HOST, HUB_PORT);
        }
    }

}
