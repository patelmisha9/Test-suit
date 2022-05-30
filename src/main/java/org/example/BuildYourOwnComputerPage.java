package org.example;

import org.openqa.selenium.By;

public class BuildYourOwnComputerPage extends Utils {
    private final By _clickOnProcessorOption1 = By.id("product_attribute_1");
    private final By _clickOnRamOption1 = By.name("product_attribute_2");
    private final By _clickOnHdd1Option = By.id("product_attribute_3_6");
    private final By _clickOnOs1Option = By.id("product_attribute_4_8");
    private final By _clickOnSoftware2Option = By.id("product_attribute_5_11");
    private final By _clickOnSoftware3Option = By.id("product_attribute_5_12");
    private final By _clickAddToCartButton = By.xpath("//div[@class=\"add-to-cart-panel\"]/button");
    private final By _clickShoppingCart = By.className("cart-label");

    public void userEnterAllTheFieldsBeforeClickOnAddToCartButton() {

        //select the processor option no 1 in drop down menu
        selectByValue(_clickOnProcessorOption1, "1");

        //Select on ram 1 option in drop down menu
        selectByValue(_clickOnRamOption1, "3");

        //Select on HDD first option
        clickonElement(_clickOnHdd1Option);

        //Select on os first option
        clickonElement(_clickOnOs1Option);

        //Select second option on software
        clickonElement(_clickOnSoftware2Option);

        //Select third option software
        clickonElement(_clickOnSoftware3Option);

        Sleep(10000);

        //Click on add to cart button
        clickonElement(_clickAddToCartButton);

        //Click on shopping cart
        clickonElement(_clickShoppingCart);

    }
}
