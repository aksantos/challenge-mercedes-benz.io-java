package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * This function will hover over an element inside a shadow DOM
     * @param shadowDOM shadow DOM locator
     * @param element element to be located inside shadow DOM
     */
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

    /**
     * This function will move to the element before take a screenshot
     * @param element target element to scroll before take a screenshot
     */
    public void takeScreenshot(WebElement element) {
        scrollToElement(element);
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("src/test/java/resources/screenshot.jpg");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This function will scroll to the element
     * @param element target element to scroll
     */
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This function will get inside the Shadow DOMs and get the element and return a WebElement
     * @param shadowDOM shadow DOM locator
     * @param element element to be located inside shadow DOM
     * @return return a WebElement
     */
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

    /**
     * This function get all text from the element and put into an arraylist only the prices
     * @param element element to get text
     * @return return a sorted arraylist with prices from the text got from element
     */
    public ArrayList<String> getPrices(WebElement element){
        String allText = element.getText();
        Pattern p = Pattern.compile("£[0-9]+,[0-9]+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(allText);
        ArrayList<String> prices = new ArrayList<>();
        while(m.find()) {
            prices.add(m.group());
        }
        Collections.sort(prices);
        return prices;
    }

    public void saveHighAndLowPricesToFile(ArrayList<String> prices) {
        int length = prices.size();
        String lowerPrice = prices.get(0);
        String higherPrice = prices.get(length - 1);
        try {
            FileWriter myWriter = new FileWriter("src/test/java/resources/prices.txt");
            myWriter.write("Lower Price: " + lowerPrice);
            myWriter.write(System.getProperty( "line.separator" ));
            myWriter.write("Higher Price: "  + higherPrice);
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
