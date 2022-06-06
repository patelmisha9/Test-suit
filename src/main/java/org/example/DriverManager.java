package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;;
import java.time.Duration;

public class DriverManager extends Utils{


    //before method
    String browserName = "chrome";

    public void openBrowser() {
        if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            // open chrome browser
            driver = new ChromeDriver();

        } else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/java/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        }else if (browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver","src/test/java/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    //closing the browser
    public void closeBrowser() {
        driver.quit();
    }
}
