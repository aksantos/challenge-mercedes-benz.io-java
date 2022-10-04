package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static utils.BaseUtils.driver;

public class AClassHatchbackPage extends BasePage{

    public void selectDiesel(){
        wait = new WebDriverWait(driver, 10);
        scrollToElement(getInsideShadowDOM(carConfiguratorShadowDOM(),motorizationFilter()));
        // open dropdown
        getInsideShadowDOM(carConfiguratorShadowDOM(),fuelFilter()).click();
        wait.until(ExpectedConditions.visibilityOf(getInsideShadowDOM(carConfiguratorShadowDOM(), fuelDropdownOpened())));
        // select diesel fuel
        getInsideShadowDOM(carConfiguratorShadowDOM(),dieselFuelCheckbox()).click();
        // close dropdown
        getInsideShadowDOM(carConfiguratorShadowDOM(),fuelFilter()).click();
    }

    public ArrayList<String> getAClassHatchbackPrices() {
        return getPrices(getInsideShadowDOM(carConfiguratorShadowDOM(),motorizationComparison()));
    }

    public void saveHighAndLowerAClassHatchbacksPricesToFile() {
        saveHighAndLowPricesToFile(getAClassHatchbackPrices());
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
    public final By fuelDropdownOpened() {
        return By.cssSelector("button[aria-expanded='true']");
    }
    public final By motorizationFilter() {
        return By.cssSelector("cc-motorization-filters");
    }
    public final By motorizationComparison() {
        return By.cssSelector(".cc-motorization-comparison-wrapper");
    }
}
