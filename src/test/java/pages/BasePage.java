package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static utils.BaseUtils.driver;

public class BasePage {

    public WebDriverWait wait;
    
    public static String url() {
        return "https://www.mercedes-benz.co.uk";
    }
    
    public void agreeAllCookies() {
        getInsideShadowDOM(cookieShadowDOM(),cookieButton()).click();
    }

    public void selectHatchbacksModel() {
        scrollToElement(getInsideShadowDOM(modelShadowDOM(), hatchbacksModel()));
        getInsideShadowDOM(modelShadowDOM(), hatchbacksModel()).click();
    }

    public void hoverOverAClassHatchback(){
        hoverOverElementInsideShadowDOM(modelShadowDOM(), aClassHatchback());
    }

    public void selectBuildYourCarAClassHatchBack(){
        getInsideShadowDOM(modelShadowDOM(), buildYourCarAClassHatchback()).click();
    }
    
    public void hoverOverElementInsideShadowDOM(By shadowDOM, By element) {
        WebElement ele = getInsideShadowDOM(shadowDOM, element);
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
    }

    // Take ScreenShot
    public void takeScreenshot() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("src/test/java/resources/screenshot.jpg");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Scroll to the element to be interacted with
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Get inside Shadow DOMs
    public WebElement getInsideShadowDOM(By shadowDOM, By element) {
        WebElement shadowHost = driver.findElement(shadowDOM);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return shadowRoot.findElement(element);
    }

    // Locators
    public final By cookieShadowDOM() {
        return By.cssSelector("cmm-cookie-banner");
    }
    public final By cookieButton() {
        return By.cssSelector("button[data-test='handle-accept-all-button']");
    }
    public final By modelShadowDOM() {
        return By.cssSelector("dh-io-vmos");
    }
    public final By hatchbacksModel() {
        return By.cssSelector("section:nth-child(2) > button:nth-child(2)");
    }
    public final By aClassHatchback() {
        return By.cssSelector("section:nth-child(2) > div > div > div");
    }
    public final By buildYourCarAClassHatchback() {
        return By.cssSelector("wb-popover:nth-child(2) > ul > li:nth-child(2)");
    }

}
