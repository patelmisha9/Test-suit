package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager extends Utils {
    LoadProperties loadProperties = new LoadProperties();
    public final String USERNAME = loadProperties.getProperty("Username");
    public final String AUTOMATE_KEY = loadProperties.getProperty("Accesskey");
    public final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();
    boolean cloud = true;
    //boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));
    //before method
   // String browserName = System.getProperty("chrome");
    String browserName = "chrome";

    public void openBrowser() {
        if (cloud) {
            //Run in cloud
            if (browserName.equalsIgnoreCase("chrome")) {
                System.out.println("Running in cloud");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");
                try
                {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        } else {
            //Run locally
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                //open chrome browser
                driver = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
                driver = new EdgeDriver();

            }
        }

        // if(browserName.equalsIgnoreCase("Chrome")) {
        // System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        //open chrome browser
        // driver = new ChromeDriver();

        //  } else if(browserName.equalsIgnoreCase("firefox")){
        //  System.setProperty("webdriver.gecko.driver","src/test/java/drivers/geckodriver.exe");
        // driver = new FirefoxDriver();

        //  }else if (browserName.equalsIgnoreCase("Edge")){
        // System.setProperty("webdriver.edge.driver","src/test/java/drivers/msedgedriver.exe");
        // driver = new EdgeDriver();
        // }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(loadProperties.getProperty("url"));

    }

    //closing the browser
    public void closeBrowser() {
       driver.quit();
    }
}
