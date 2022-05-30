package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class DesktopsPage extends Utils {
    private final By _clickonAddToCartButton = By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/button[1]");
    private final By _clickEmailFriend = By.className("email-a-friend");

    public void verifyUserIsOnDesktopsPage() {
        //verify on right url
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue("https://demo.nopcommerce.com/desktops".equals(actualUrl), "The url does not match");

    }

    public void clickOnAddToCartButtonOnBulidYourOwnComputer() {

        //click on add to cart button on Build your own computer
        clickonElement(_clickonAddToCartButton);

    }

    public void clickOnEmailFriend() {
        clickonElement(_clickEmailFriend);

    }
}
