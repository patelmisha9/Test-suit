package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage {
    //All the resuable method
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
    //All the resuable methods

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

    public static void selectByValue(By by, String text) {
        new Select(driver.findElement(by)).selectByValue(text);
    }

    public static void Sleep(int milliesecond) {
        try {
            Thread.sleep(milliesecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void takeSnapshot(String a)
    {
        TakesScreenshot scrshot = ((TakesScreenshot) driver);
        File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots\\" + a + randomDate() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void waitAndClick(By by, Duration time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
    }

}