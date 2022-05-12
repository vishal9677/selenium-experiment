package org.vishal.driverhandler.enums;

import java.util.Optional;

public enum Browser {
    CHROME, FIREFOX;

    public static Browser getBrowser(){
        var browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome").toLowerCase();
        if(browser.equalsIgnoreCase("chrome")){
            return CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            return FIREFOX;
        } else {
            throw new RuntimeException(String.format("%s browser is not available", browser));
        }
    }
}
