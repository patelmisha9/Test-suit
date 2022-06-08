package org.example;

import org.testng.annotations.Test;


public class TestSuite extends BaseTest {
    HomePage homepage = new HomePage();
    RegistrationPage registrationpage = new RegistrationPage();
    RegistrationSuccessPage registrationsuccesspage = new RegistrationSuccessPage();
    DesktopsPage desktopspage = new DesktopsPage();
    BuildYourOwnComputerPage buildyourowncomputerpage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingcartpage = new ShoppingCartPage();
    ComputersPage computerspage = new ComputersPage();
    EmailAFriendPage emailafriendpage = new EmailAFriendPage();
    NewReleasePage newReleasePage = new NewReleasePage();

    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {
        homepage.clickOnRegisterButton();
        registrationpage.userRegistrationDetails();
        registrationsuccesspage.verifyUserIsRegisterSuccessfully();
    }

    @Test
    public void userIsAbleToDoAddToCartBuildyourOwnComputeronComputerpageinDesktopscategory() {
        homepage.clickOnComputersPage();
        computerspage.clickOnDesktops();
        desktopspage.verifyUserIsOnDesktopsPage();
        desktopspage.clickOnAddToCartButtonOnBulidYourOwnComputer();
        buildyourowncomputerpage.userEnterAllTheFieldsBeforeClickOnAddToCartButton();
        shoppingcartpage.verifyUserIsOnShoppingCartPage();
        shoppingcartpage.verifyCorrectProductIsAddedToShoppingCart();
    }

    @Test
    public void verifyUserIsAbleToSeeDollarSignForPriceAndEuroSignForPriceIfSelectEuro() {
        homepage.clickOnUsDollar();
        homepage.verifyUserIsAbleToSeeProductPriceInDollar();
        homepage.clickOnEuro();
        homepage.verifyUserIsAbleToSeeProductPriceInEuro();
    }

    @Test
    public void verifyUserIsAbleToSentEmailAFriendAboutAProduct() {
        homepage.clickOnRegisterButton();
        registrationpage.userRegistrationDetails();
        homepage.clickOnComputersPage();
        computerspage.clickOnDesktops();
        desktopspage.clickOnAddToCartButtonOnBulidYourOwnComputer();
        buildyourowncomputerpage.clickOnEmailFriend();
        emailafriendpage.typeFriendEmail();
        emailafriendpage.typeYourEmail();
        emailafriendpage.typePersonalMessage();
        emailafriendpage.clickOnSendEmail();
        emailafriendpage.verifyUserIsAbleToSeeMessageHasBeenSentTxt();
    }

    @Test
    public void verifyRegisterUserShouldBeableToVoteOnCommunityPoll() {
        //on home page at the bottom of the page click on good option of community poll
        homepage.clickOnGoodOnCommunityPollOnHomePage();
        //click on vote button
        homepage.clickOnVoteButton();
        //verify non register user should see error message
        homepage.verifyNonRegisterUserShouldSeeErrorMessage();
        //click on register button
        homepage.clickOnRegisterButton();
        //enter all registration details
        registrationpage.userRegistrationDetails();
        //click on continue button after user is register
        registrationpage.clickOnContinueButton();
        //on home page at the bottom of the page click on good option of community poll
        homepage.clickOnGoodOnCommunityPollOnHomePage();
        //click on vote button
        homepage.clickOnVoteButton();
        //on home page verify user is able to see text msg vote(s)...
        homepage.verifyTextVotesOnceRegisteruservotesOnCommunityPoll();

    }

   @Test
    public void VerifyProductsTitlesAreVisibleOnhomePage() {
       homepage.getProductTitle();
   }

    @Test
    public void VerifyUserShouldBeAbleToClickAndNavigateFacebookPageByClikingOnFacebookIconOnHomePage() {
        //user is on home page
        //click on facebook icon on homepage
        homepage.VerifyUserIsAbleToClickonFacebookIconOnHomePage();
        //verifying that user is on correct window with correct url
        homepage.VerifyTheUrlOnceUserClickOnFaceBookIconUserShouldBeNewWindowWithCorrectUrl();
    }

    @Test
    public void verifyUserIsAbleSeePopMessageIfClickOnVoteButtonWithoutSelectingAnyOption() {
        //click on vote button
        homepage.clickOnVoteButton();
        //verifying the popup message
        homepage.VerifyUserIsAbleToSeePopUpMessagePleaseSelectAnAnswerIfTryToVoteDirectlyWithoutSelectingAnyOptionOnCommunityPoll();
        //accepting the popup message
        homepage.clickOnOkButtonAndAcceptPopUpMessage();
    }

    @Test
    public void verifyUserOnNewReleasePageAndAbleToAddNewComment() {
        //click on middle details button under news on homepage
        homepage.userClickonSecondoptionOfNewReleaseOnHomepageUnderNews();
        //verify user on right page
        newReleasePage.verifyUserIsOnRightPage();
        //Enter title
        newReleasePage.enterTitleName();
        //Enter comment
        newReleasePage.entercomment();
        //Click on new comment button
        newReleasePage.clickOnNewCommentButton();
        //verify message has appeared after adding the comment
        newReleasePage.verifyNewCommentHasBeenAdd();


    }

    @Test
    public void userShouldBeAbleToSearchTheNikeProductsUsingSearchButton() {
        //user should be able to search products
        homepage.userShouldBeToSearchprodut("Nike");
    }
    @Test
    public void userShouldBeAbleToDoSortByZtoAAndProductShouldBeSortedAccording(){
        //click on computer page
        homepage.clickOnComputersPage();
        //click on desktop page
        computerspage.clickOnDesktops();
        //verify user on desktop page
        desktopspage.verifyUserIsOnDesktopsPage();
        //verify user can sort the product using sort by functionality
        desktopspage.userShouldBeSortProductsByZToAAndProductShouldBeSortedAccording();

    }

}