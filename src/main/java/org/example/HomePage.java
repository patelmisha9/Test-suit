package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Utils {
    private By _registerButton = By.className("ico-register");
    private By _computersPage = By.xpath("//div/ul[1]/li[1]/a[@href=\"/computers\"]");
    private By _usDollar = By.xpath("//select[@id=\"customerCurrency\"]/option[1]");
    private By _euro = By.xpath("//select[@id=\"customerCurrency\"]/option[2]");
    private By _goodOnCommunityPollOnHomePage = By.id("pollanswers-2");
    private By _voteButton = By.id("vote-poll-1");
    private By _voteErrorMessage = By.id("block-poll-vote-error-1");
    private By _textVote = By.xpath("//span[contains(text(),\"vote(s)...\")]");

    public void clickOnRegisterButton() {
        //click on register button
        clickonElement(_registerButton);
    }

    public void clickOnComputersPage() {
        //click on computers page on homepage
        clickonElement(_computersPage);
    }

    public void clickOnUsDollar() {
        //Click on us dollar
        clickonElement(_usDollar);
    }

    public void verifyUserIsAbleToSeeProductPriceInDollar() {
        //declaring the variable currency
        String currency = gettextFromElement(By.xpath("//div[@class=\"prices\"]/span"));

        //Verify user is able to see product price in dollar
        Assert.assertTrue(currency.contains("$"));
    }

    public void clickOnEuro() {
        //select euro
        clickonElement(_euro);
    }

    public void verifyUserIsAbleToSeeProductPriceInEuro() {
        //verify if select euro price euro sign should display for price
        String currencyEuro = gettextFromElement(By.xpath("//div[@class=\"prices\"]/span"));
        Assert.assertTrue(currencyEuro.contains("€"));
    }

    public void clickOnGoodOnCommunityPollOnHomePage() {
        clickonElement(_goodOnCommunityPollOnHomePage);
    }

    public void clickOnVoteButton() {
        clickonElement(_voteButton);
    }

    public void verifyNonRegisterUserShouldSeeErrorMessage() {
        waitForElementtoBeVisibile(10, _voteErrorMessage);
        Assert.assertEquals(gettextFromElement(_voteErrorMessage), "Only registered users can vote.", "The message has not display");
    }

    public void verifyTextVotesOnceRegisteruservotesOnCommunityPoll() {

        //waitForElementtoBeVisibile(20,_textVote);
        Assert.assertTrue((gettextFromElement(_textVote).contains("vote(s)...")), "The votes cannot been seen");

    }
    //
    public void getProductTitle(){
        List<WebElement> productTitles = driver.findElements(By.xpath("//div[contains(@class,\"product-grid\")]//div[@class=\"item-grid\"]//h2"));
        for (WebElement e:productTitles)
              {
                  System.out.println(e.getText());
        }
    }
}
