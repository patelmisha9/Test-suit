package org.example;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils {
    DriverManager dirvermanager = new DriverManager();

    @BeforeMethod
    public void setUp() {

        dirvermanager.openBrowser();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (!result.isSuccess()) {
            takeSnapshot(result.getName());
        }
            dirvermanager.closeBrowser();
        }
    }
