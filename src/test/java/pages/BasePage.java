package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.BaseUtils.driver;

public class BasePage {

    public WebDriverWait wait;
    public static String url() {
        return "https://www.mercedes-benz.co.uk";
    }
    public void agreeAllCookies() {
        getInsideShadowDOM(cookieShadowDOM(),cookieButton()).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectHatchbacksModel() {
        getInsideShadowDOM(modelShadowDOM(), hatchbacksModel()).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Get inside Shadow DOMs
    public WebElement getInsideShadowDOM(By shadowDOM, By locator) {
        WebElement shadowHost = driver.findElement(shadowDOM);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return shadowRoot.findElement(locator);
    }

    // Locators
    public final By cookieShadowDOM() {
        return By.cssSelector("cmm-cookie-banner");
    }
    public final By cookieButton() {
        return By.cssSelector("cmm-buttons-wrapper:nth-child(3) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)");
    }
    public final By modelShadowDOM() {
        return By.cssSelector("dh-io-vmos");
    }
    public final By hatchbacksModel() {
        return By.cssSelector("section:nth-child(2) > button:nth-child(2) > span:nth-child(1)");
    }

}
