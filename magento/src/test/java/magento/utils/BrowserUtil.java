package magento.utils;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class BrowserUtil {

    public static WebDriver createDriver(String browser) {
        WebDriver driver = null;
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions FireFoxOptions = new FirefoxOptions();
        
        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME:
            	
            	chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case CHROME_HEADLESS:
          
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX_HEADLESS:
            	FireFoxOptions.setHeadless(true);
                driver = new FirefoxDriver(FireFoxOptions);
                break;
        }
        return driver;
    }
}