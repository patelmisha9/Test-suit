package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static io.netty.util.internal.SystemPropertyUtil.contains;

public class NewReleasePage extends Utils {
    SoftAssert softAssert = new SoftAssert();
    LoadProperties loadProperties = new LoadProperties();
    private By _titleColumn = By.id("AddNewComment_CommentTitle");
    private By _enterComment = By.id("AddNewComment_CommentText");
    private By _clickOnNewComment = By.name("add-comment");
    private By _verifyMessage = By.className("result");

    public void verifyUserIsOnRightPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("https://demo.nopcommerce.com/nopcommerce-new-release".equals(currentUrl));
    }
    public void enterTitleName() {
       typeText(_titleColumn, loadProperties.getProperty("Title"));
    }
    public void entercomment() {
        typeText(_enterComment, loadProperties.getProperty("Comment"));
    }
    public void clickOnNewCommentButton() {
        clickonElement(_clickOnNewComment);
    }
    public  void verifyNewCommentHasBeenAdd(){
        softAssert.assertEquals(gettextFromElement(_verifyMessage),"News comment is successfully added.","The message not match");
        List<WebElement> commentlist = driver.findElements(By.xpath("//div[@class=\"comments\"]/div/div[2]/div[3]"));
        String comment = "";
        int lastlocator = commentlist.size() -1;
        String lastcomment = "";

        for(int i=0;i<commentlist.size();i++) {
            comment =  commentlist.get(i).getText();
            lastcomment =  commentlist.get(lastlocator).getText();
        }
        softAssert.assertTrue(comment.contains("The products are good"));
        softAssert.assertEquals(lastcomment,loadProperties.getProperty("Comment"));

        softAssert.assertAll();
    }
}
