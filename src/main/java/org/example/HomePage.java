package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {

    public void clickOnRegisterButton() {
        //click on register button
        clickonElement(By.className("ico-register"));
    }
    public void clickOnComputersPage() {
        //click on computers page on homepage
        clickonElement(By.xpath("//div/ul[1]/li[1]/a[@href=\"/computers\"]"));
        System.out.println("1");
    }
    public void clickOnUsDollar() {
        //Click on us dollar
        clickonElement(By.xpath("//select[@id=\"customerCurrency\"]/option[1]"));
    }
    public void verifyUserIsAbleToSeeProductPriceInDollar() {
        //declaring the variable currency
        String currency = gettextFromElement(By.xpath("//div[@class=\"prices\"]/span"));

        //Verify user is able to see product price in dollar
        Assert.assertTrue(currency.contains("$"));
    }
    public void clickOnEuro() {
        //select euro
        clickonElement(By.xpath("//select[@id=\"customerCurrency\"]/option[2]"));
    }
    public void verifyUserIsAbleToSeeProductPriceInEuro() {
        //verify if select euro price euro sign should display for price
        String currencyEuro = gettextFromElement(By.xpath("//div[@class=\"prices\"]/span"));
        Assert.assertTrue(currencyEuro.contains("€"));
    }
}
