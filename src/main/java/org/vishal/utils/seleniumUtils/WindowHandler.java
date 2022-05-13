package org.vishal.utils.seleniumUtils;

import org.vishal.driverhandler.DriverManager;
import org.vishal.pages.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

@Component
public class WindowHandler {

    @Autowired
    private DriverManager manager;

    @Autowired
    private Page page;

    public void switchToNewTab(String originalWindow){
        var driver = manager.getDriver();
        page.getWait().until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public String getOriginalWindow(){
        return manager.getDriver().getWindowHandle();
    }
}
