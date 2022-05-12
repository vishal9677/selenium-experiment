package org.vishal.driverhandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.vishal.AppConfig;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverManager extends DriverManager{
    @Override
    public void setUpDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    public void startBrowser() {
        if(driver==null) {
            if(AppConfig.executionEnvironment.equalsIgnoreCase("local")){
                driver = new FirefoxDriver(new FirefoxOptions());
            }else{
                driver = new RemoteWebDriver(getHostUrl(), new FirefoxOptions());
            }
        }
    }
}
