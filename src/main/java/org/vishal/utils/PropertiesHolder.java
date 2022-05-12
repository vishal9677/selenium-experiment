package org.vishal.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:App.properties")
public class PropertiesHolder {

    @Value("${app.url}")
    private String appUrl;

    public String getAppUrl(){
        return appUrl;
    }
}
