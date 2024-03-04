package core;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        WebDriverSingleton webDriverSingleton = new WebDriverSingleton();
        driver = webDriverSingleton.driver();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Driver quit successful.");
        }
    }

    public void setTimeOut(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {

        }
    }

    public void navigateToUrl(String url){
        driver.navigate().to(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}