package org.example;

import org.openqa.selenium.By;

import java.time.Duration;

public class BuildYourOwnComputerPage extends Utils {
    private By _clickOnProcessorOption1 = By.id("product_attribute_1");
    private By _clickOnRamOption1 = By.name("product_attribute_2");
    private By _clickOnHdd1Option = By.id("product_attribute_3_6");
    private By _clickOnOs1Option = By.id("product_attribute_4_8");
    private By _clickOnSoftware2Option = By.id("product_attribute_5_11");
    private By _clickOnSoftware3Option = By.id("product_attribute_5_12");
    private By _clickAddToCartButton = By.xpath("//div[@class=\"add-to-cart-panel\"]/button");
    private By _clickShoppingCart = By.className("cart-label");
    private By _clickEmailFriend = By.xpath("//div[@class=\"overview\"]/div[10]/div[3]");


    public void userEnterAllTheFieldsBeforeClickOnAddToCartButton() {

        //select the processor option no 1 in drop down menu
        selectByValue(_clickOnProcessorOption1, "1");

        //Select on ram 1 option in drop down menu
        selectByValue(_clickOnRamOption1, "3");

        //Select on HDD first option
        waitAndClick(_clickOnHdd1Option, Duration.ofMillis(2000));

        //Select on os first option
        clickonElement(_clickOnOs1Option);

        //Select second option on software
        clickonElement(_clickOnSoftware2Option);

        //Select third option software
        clickonElement(_clickOnSoftware3Option);

       // Sleep(10000);

        //Click on add to cart button
        waitAndClick(_clickAddToCartButton,Duration.ofSeconds(3));
        //Click on shopping cart
        Sleep(5000);
        waitAndClick(_clickShoppingCart,Duration.ofSeconds(6));
    }

    public void clickOnEmailFriend() {
        waitForElementtoBeVisibile(5000, _clickEmailFriend);
        clickonElement(_clickEmailFriend);
    }
}
