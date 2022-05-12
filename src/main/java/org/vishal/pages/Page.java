package org.vishal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vishal.driverhandler.DriverManager;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
public abstract class Page {

    @Autowired
    protected DriverManager manager;

    private WebDriverWait wait;

    public static int universalWaitTimeInSeconds = 10;
    public abstract void initialize();
    protected void clickElement(WebElement element){
        element.click();
    }
    protected WebElement getWebElement(By by){
        return manager.getDriver().findElement(by);
    }

    public void goTo(String URL){
        manager.getDriver().manage().window().maximize();
        manager.getDriver().get(URL);
    }

    public void setWait(){
        if(wait==null){
            wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(universalWaitTimeInSeconds));
        }
    }

    public WebDriverWait getWait(){
        if(wait==null){
            setWait();
            return wait;
        }
        return wait;
    }
    protected void clickAfterElementIsClickable(String path){
        setWait();
        var by = By.xpath(path);
        wait.until(elementToBeClickable(by));
        getWebElement(by).click();
    }

    protected void clickAfterElementIsClickable(WebElement element){
        setWait();
        wait.until(elementToBeClickable(element));
        element.click();
    }

    protected void waitTillVisibilityOf(WebElement element){
        setWait();
        wait.until(visibilityOf(element));
    }

    protected void waitTillVisibilityOf(String path){
        setWait();
        wait.until(visibilityOfElementLocated(By.xpath(path)));
    }

}
