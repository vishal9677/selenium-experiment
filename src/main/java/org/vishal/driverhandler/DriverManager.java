package org.vishal.driverhandler;

import org.vishal.AppConfig;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class DriverManager {
    protected WebDriver driver;
    public abstract void setUpDriver();
    public abstract void startBrowser();
    public WebDriver getDriver() {
        return driver;
    }

    public void stopBrowser() {
        driver.quit();
        driver = null;
    }

    protected URL getHostUrl(){
        try {
            return new URL(AppConfig.hostUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
