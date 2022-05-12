package org.vishal.driverhandler;

import org.vishal.driverhandler.enums.Browser;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {

    @Bean
    public DriverManager createDriverFactory(){
        DriverManager manager = null;
        var browser = Browser.getBrowser();
        switch (browser){
            case CHROME:
                manager = new ChromeDriverManager();
                break;
            case FIREFOX:
                manager = new FirefoxDriverManager();
                break;
        }
        return manager;
    }


}
