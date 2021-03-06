package org.vishal.driverhandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.vishal.AppConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverManager extends DriverManager{
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public void startBrowser() {
        if(driver==null) {
            switch(AppConfig.executionEnvironment){
                case "local":
                    driver = new ChromeDriver(getChromeOptions());
                    break;
                case "grid":
                    driver = new RemoteWebDriver(getHostUrl(), getChromeOptions());
                    break;
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        var options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        return options;
    }
}
