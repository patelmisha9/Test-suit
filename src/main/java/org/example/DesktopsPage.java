package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utils {
    private By _clickonAddToCartButton = By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/button[1]");
    private By _clickonsortby = By.id("products-orderby");
    private By _productlist = By.xpath("//h2[@class=\"product-title\"]");


    public void verifyUserIsOnDesktopsPage() {
        //verify on right url
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue("https://demo.nopcommerce.com/desktops".equals(actualUrl), "The url does not match");

    }

    public void clickOnAddToCartButtonOnBulidYourOwnComputer() {
        //click on add to cart button on Build your own computer
        waitAndClick(_clickonAddToCartButton, Duration.ofMillis(3000));

    }
public void userShouldBeSortProductsByZToAAndProductShouldBeSortedAccording(){
        //product list before filter
    List<WebElement> productList = driver.findElements(_productlist);
    List<String> actualProductList = new ArrayList<String>();
    for (WebElement e: productList){
        actualProductList.add(e.getText());
    }

    Collections.sort(actualProductList,Collections.reverseOrder());
    //select sort by z to a
    selectDropDownByValue(_clickonsortby,"6");
    //product list after using sort Z to A
    List<WebElement> afterSortProductList = driver.findElements(_productlist);
    List<String> productListAfterSort = new ArrayList<String>();
    for (WebElement e: afterSortProductList){
        productListAfterSort.add(e.getText());
    }
    Assert.assertEquals(actualProductList,productListAfterSort);


}

}
