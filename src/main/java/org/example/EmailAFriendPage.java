package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPage extends Utils {
    private By _emailFriendField = By.id("FriendEmail");
    private By _yourEmailAddressField = By.xpath("//input[@placeholder=\"Enter your email address.\"]");
    private By _personalMessageField = By.id("PersonalMessage");
    private By _sendEmail = By.name("send-email");

    public void typeFriendEmail() {
        //type email in friend's email column
        typeText(_emailFriendField, "Veronika1234@gmail.com");
    }

    public void typeYourEmail() {
        //type your email address
        typeText(_yourEmailAddressField, "");
    }

    public void typePersonalMessage() {
        //type personal message
        typeText(_personalMessageField, "The product is good");
    }

    public void clickOnSendEmail() {
        //click on send email
        clickonElement(_sendEmail);
    }

    public void verifyUserIsAbleToSeeMessageHasBeenSentTxt() {
        //verify the message has been sent
        Assert.assertEquals("Your message has been sent.", gettextFromElement(By.className("result")), "The message has been not sent");
    }
}
