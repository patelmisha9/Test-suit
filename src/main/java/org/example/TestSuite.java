package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuite {
    protected static WebDriver driver;

    //before method
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        // open chrome browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // type url
        driver.get("https://demo.nopcommerce.com/");
    }

    // closing the browser
    @AfterMethod
    public void closeBrowser() {
       // driver.quit();
    }

    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {
        //click on register button
        clickonElement(By.className("ico-register"));

        //select on female
        clickonElement(By.className("female"));

        //enter first name
        typeText((By.id("FirstName")), "Veronica");

        //enter last name
        typeText((By.xpath("//input[@id='LastName']")), "Patel");

        //select the day in date of birth drop down menu
        Select Birthday = new Select(driver.findElement(By.name("DateOfBirthDay")));

        Birthday.selectByIndex(12);
        //select the month
        Select birthmonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        birthmonth.selectByValue("3");

        //select the year
        Select birthyear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        birthyear.selectByVisibleText("1969");

        //enter email
        typeText((By.xpath("//input[@id='Email']")), "tkpatel1102" + randomDate() + "@gmail.com");

        //enter password
        typeText(By.name("Password"), "0123456");

        //enter confirm password
        typeText(By.name("ConfirmPassword"), "0123456");

        // click on register button
        clickonElement(By.name("register-button"));

        //verify that user is register successfully or not
        String expectedMessage = "Your registration completed";
        String actualMessage = gettextFromElement(By.className("result"));
        Assert.assertEquals(actualMessage, expectedMessage, "The register is not successfull");
    }
    @Test
    public void userIsAbleToDoAddToCartBuildyourowncomputeronComputerpageinDesktopscategory(){
        //Home page url
        driver.get("https://demo.nopcommerce.com/");

        //click on computers page on homepage
        clickonElement(By.xpath("//div/ul[1]/li[1]/a[@href=\"/computers\"]"));

        //click on Desktops
        clickonElement(By.xpath("//li[@class=\"active last\"]//a[@href=\"/desktops\"]"));


    }
    //All the resuable methods

    //parameterized method for find the element
    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //parameterized method to click on element
    public static void clickonElement(By by) {
        driver.findElement(by).click();
    }

    //parameterized method to generate date to create unique email
    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

    //parameterized method to get text for verification purpose
    public static String gettextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //parameterized method for wait url to be
    public static void driverWaituntilUrl(int time, String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    //parameterized method for wait element to be located
    public static void waitUntilElementLocated(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //parameterized method for wait to check title of page
    public static void waitToCheckTitleOfPage(int time, String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(title));
    }

    //parameterized method for wait url contains specific text
    public static void waitUntilUrlContains(int time, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(text));
    }

    //parameterized method for wait element to be clickable
    public static void waitForElementToBeClickable(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //parameterized method for wait element to be visible
    public static void waitForElementtoBeVisibile(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //parameterized method for wait element to be selected
    public static void elementToBeSelected(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    //parameterized method for wait until url match
    public static void urlToBeMatch(int time, String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlMatches(url));
    }

    //parameterized method for wait invisibility Of Element Located
    public static void invisibilityOfElementLocated(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //parameterized method for wait attribute to be
    public static void Attributetobe(int time, By by, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by, attribute, value));
    }

    // text to be checking webelement with given locator has specific text
    public static void Texttobe(int time, By by, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by, value));
    }

}