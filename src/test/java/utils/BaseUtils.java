package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseUtils {

    public static WebDriver driver;

    public static void launchChrome(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1200");
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);
    }

    public static void launchFirefox(String url) {
        System.setProperty("webdriver.gecko.driver", "src/test/java/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }
}

