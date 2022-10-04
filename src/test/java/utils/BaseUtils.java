package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


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
    public static void launchEdge(String url) {
        System.setProperty("webdriver.edge.driver", "src/test/java/resources/msedgedriver.exe");
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--window-size=1920,1200");
        driver = new EdgeDriver(edgeOptions);
        driver.get(url);
    }
    public static void closeBrowser() {
        driver.quit();
    }
}

