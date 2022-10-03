package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.BaseUtils.driver;

public class AClassHatchbackPage extends BasePage{

    public void selectDiesel(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(getInsideShadowDOM(carConfiguratorShadowDOM(),fuelFilter()))).click();
        wait.until(ExpectedConditions.elementToBeClickable(getInsideShadowDOM(carConfiguratorShadowDOM(),dieselFuelCheckbox()))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
}
