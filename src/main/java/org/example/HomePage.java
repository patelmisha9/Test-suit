package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends Utils {
    private By _registerButton = By.className("ico-register");
    private By _computersPage = By.xpath("//div/ul[1]/li[1]/a[@href=\"/computers\"]");
    private By _usDollar = By.xpath("//select[@id=\"customerCurrency\"]/option[1]");
    private By _euro = By.xpath("//select[@id=\"customerCurrency\"]/option[2]");
    private By _goodOnCommunityPollOnHomePage = By.id("pollanswers-2");
    private By _voteButton = By.id("vote-poll-1");
    private By _voteErrorMessage = By.id("block-poll-vote-error-1");
    private By _textVote = By.xpath("//span[contains(text(),\"vote(s)...\")]");
    private By _faceBookIcon = By.className("facebook");
    private  By _middleDetailsButton = By.xpath("//div[@class=\"news-list-homepage\"]/div[2]/div[2]/div[3]");
    private By _searchBar = By.name("q");
    private By _searchClick = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    private By _productList = By.xpath("//h2[@class=\"product-title\"]");

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

    public void getProductTitle() {
        List<WebElement> productTitles = driver.findElements(By.xpath("//div[contains(@class,\"product-grid\")]//div[@class=\"item-grid\"]//h2"));
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
        }
    }

    public void VerifyUserIsAbleToClickonFacebookIconOnHomePage() {
        clickonElement(_faceBookIcon);
      //Sleep(2000);
    }

    public void VerifyTheUrlOnceUserClickOnFaceBookIconUserShouldBeNewWindowWithCorrectUrl() {
        String MainWindow = driver.getWindowHandle();
        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                Sleep(2000);
                String actualUrl = driver.getCurrentUrl();
                Assert.assertTrue("https://www.facebook.com/nopCommerce".equals(actualUrl), "The url don't match");
                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }
    public void VerifyUserIsAbleToSeePopUpMessagePleaseSelectAnAnswerIfTryToVoteDirectlyWithoutSelectingAnyOptionOnCommunityPoll(){
        //storing the popup message
        String actualMessage = driver.switchTo().alert().getText();
        //verifying the popup message
        Assert.assertEquals("Please select an answer",actualMessage,"The message don't match");
    }
    public void clickOnOkButtonAndAcceptPopUpMessage(){
        //accepting the popup message
        driver.switchTo().alert().accept();
    }
    public void userClickonSecondoptionOfNewReleaseOnHomepageUnderNews(){
        clickonElement(_middleDetailsButton);
    }


public void userShouldBeToSearchprodut(String text)
    {

        clickonElement(_searchBar);
        typeText(_searchBar,text);
        clickonElement(_searchClick);
        String firstlettercapital = text.substring(0, 1).toUpperCase() + text.substring(1);
        List<WebElement> productTitles = driver.findElements(_productList);
        for (WebElement e : productTitles)
        {
            Assert.assertTrue( e.getText().contains(firstlettercapital));
        }
    }
    public void clickOnAllPages(String text)
    {
        clickonElement(By.linkText(text));
    }
    public void verifyUrlForAllPages(String text1)
    {
        Assert.assertEquals(driver.getCurrentUrl(),text1);

    }

}
