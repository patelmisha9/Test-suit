package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utils {

    public void verifyUserIsOnShoppingCartPage() {
        //verify user is on shopping cart page
        Assert.assertTrue("https://demo.nopcommerce.com/cart".equals(driver.getCurrentUrl()), "The url does not match");
    }

    public void verifyCorrectProductIsAddedToShoppingCart() {

        //Verify the correct product has been add on shopping cart
        Assert.assertEquals(gettextFromElement(By.className("product-name")), "Build your own computer", "product not added successfully");
    }
}
