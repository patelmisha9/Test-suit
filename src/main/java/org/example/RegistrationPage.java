package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils {
    private By _genderFemale = By.id("gender-female");
    private By _firstNameFiled = By.id("FirstName");
    private By _lastNameField = By.xpath("//input[@id='LastName']");
    private By _dateOfBirthdayField = By.name("DateOfBirthDay");
    private By _birthdayMonthField = By.name("DateOfBirthMonth");
    private By _birthdayYearField = By.name("DateOfBirthYear");
    private By _enterEmailField = By.xpath("//input[@id='Email']");
    private By _enterPasswordField = By.name("Password");
    private By _enterConfirmedPasswordField = By.name("ConfirmPassword");
    private By _clickOnRegisterButton = By.name("register-button");
    private By _continue = By.xpath("//a[text()='Continue']");

    public void userRegistrationDetails() {
        //select on female

        clickonElement(_genderFemale);

        //enter first name
        typeText((_firstNameFiled), "Veronica");

        //enter last name
        typeText(_lastNameField, "Patel");

        //select the day in date of birth drop down menu
        Select Birthday = new Select(driver.findElement(_dateOfBirthdayField));
        Birthday.selectByIndex(12);

        //select the month
        Select birthmonth = new Select(driver.findElement(_birthdayMonthField));
        birthmonth.selectByValue("3");

        //select the year
        Select birthyear = new Select(driver.findElement(_birthdayYearField));
        birthyear.selectByVisibleText("1969");

        //enter email
        typeText(_enterEmailField, "tkpatel1102" + randomDate() + "@gmail.com");

        //enter password
        typeText(_enterPasswordField, "0123456");

        //enter confirm password
        typeText(_enterConfirmedPasswordField, "0123456");


        // click on register button
        clickonElement(_clickOnRegisterButton);


    }

    public void clickOnContinueButton() {
        clickonElement(_continue);
    }
}