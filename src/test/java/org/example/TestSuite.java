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
        desktopspage.clickOnEmailFriend();
        emailafriendpage.typeFriendEmail();
        emailafriendpage.typeYourEmail();
        emailafriendpage.typePersonalMessage();
        emailafriendpage.clickOnSendEmail();
        emailafriendpage.verifyUserIsAbleToSeeMessageHasBeenSentTxt();
    }

}