package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessPage extends Utils{
    public void verifyUserIsRegisterSuccessfully(){

        //verify that user is register successfully or not
        String expectedMessage = "Your registration completed";
        String actualMessage = gettextFromElement(By.className("result"));
        Assert.assertEquals(actualMessage, expectedMessage, "The register is not successfull");
    }

}
