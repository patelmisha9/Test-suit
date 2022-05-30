package org.example;

import org.openqa.selenium.By;

public class ComputersPage extends Utils{
    private By _clickOnDesktops = By.xpath("//li[@class=\"active last\"]//a[@href=\"/desktops\"]");
    public void clickOnDesktops(){
        //click on Desktops
        clickonElement(_clickOnDesktops);

    }
}
