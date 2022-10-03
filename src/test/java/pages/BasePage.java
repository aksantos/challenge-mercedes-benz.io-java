package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    }

    public void selectHatchbacksModel() {
        getInsideShadowDOM(modelShadowDOM(), hatchbacksModel()).click();
    }

    public void hoverOverAClassHatchback(){
        hoverOverElementInsideShadowDOM(modelShadowDOM(), aClassHatchback());
    }

    public void selectBuildYourCarAClassHatchBack(){
        getInsideShadowDOM(modelShadowDOM(), buildYourCarAClassHatchback()).click();
//        wait.until(ExpectedConditions.stalenessOf(getInsideShadowDOM(aClassConfigurator.carConfiguratorShadowDOM(),aClassConfigurator.fuelFilter())));
    }
    
    public void hoverOverElementInsideShadowDOM(By shadowDOM, By element) {
        WebElement ele = getInsideShadowDOM(shadowDOM, element);
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
    }

    // Get inside Shadow DOMs
    public WebElement getInsideShadowDOM(By shadowDOM, By element) {
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement shadowHost = driver.findElement(shadowDOM);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        return shadowRoot.findElement(element);
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
    public final By aClassHatchback() {
        return By.cssSelector("section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)");
    }
    public final By buildYourCarAClassHatchback() {
        return By.cssSelector("section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > wb-popover:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)");
    }

}
