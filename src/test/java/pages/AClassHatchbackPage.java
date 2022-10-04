package pages;

import org.openqa.selenium.By;
import org.junit.Assert;
import java.util.ArrayList;
import static utils.BaseUtils.driver;

public class AClassHatchbackPage extends BasePage{

    public void validatePageTitle() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(driver.getTitle().contains("A-Class"));
    }
    public void selectDiesel(){
        scrollToElement(getInsideShadowDOM(carConfiguratorShadowDOM(),motorizationFilter()));
        // open dropdown
        getInsideShadowDOM(carConfiguratorShadowDOM(),fuelFilter()).click();
        // select diesel fuel
        getInsideShadowDOM(carConfiguratorShadowDOM(),dieselFuelCheckbox()).click();
        // close dropdown
        getInsideShadowDOM(carConfiguratorShadowDOM(),fuelFilter()).click();
    }

    public ArrayList<String> getPrices() {
        return getPrices(getInsideShadowDOM(carConfiguratorShadowDOM(),motorizationComparison()));
    }

    public void saveHighAndLowerPricesToFile() {
        saveHighAndLowPricesToFile(getPrices());
    }

    public void takeCarsScreenshot() {
        takeScreenshot(getInsideShadowDOM(carConfiguratorShadowDOM(),fuelFilter()));
    }

    /**
     * This function will validate if the prices in the array list are between lower and higher
     * @param lower lower price that should be
     * @param higher higher price that should be
     */
    public void validatePrices(int lower, int higher) {
        ArrayList<String> prices = getPrices();
        int length = prices.size();
        int lowerPrice = Integer.parseInt(prices.get(0).replace("£","").replace(",",""));
        int higherPrice = Integer.parseInt(prices.get(length - 1).replace("£","").replace(",",""));
        Assert.assertTrue(lowerPrice > lower);
        Assert.assertTrue(higherPrice < higher);
    }

    // Locators
    public final By carConfiguratorShadowDOM(){
        return By.cssSelector("owcc-car-configurator");
    }
    public final By fuelFilter() {
        return By.cssSelector(".wb-multi-select-control__button");
    }
    public final By dieselFuelCheckbox() {
        return By.cssSelector("wb-checkbox-control:nth-child(1) > label:nth-child(1)");
    }
    public final By motorizationFilter() {
        return By.cssSelector("cc-motorization-filters");
    }
    public final By motorizationComparison() {
        return By.cssSelector(".cc-motorization-comparison-wrapper");
    }
}
