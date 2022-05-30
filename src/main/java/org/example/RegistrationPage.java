package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils {
    private final By _genderFemale = By.className("female");
    private final By _firstNameFiled = By.id("FirstName");
    private final By _lastNameField = By.xpath("//input[@id='LastName']");
    private final By _dateOfBirthdayField = By.name("DateOfBirthDay");
    private final By _birthdayMonthField = By.name("DateOfBirthMonth");
    private final By _birthdayYearField = By.name("DateOfBirthYear");
    private final By _enterEmailField = By.xpath("//input[@id='Email']");
    private final By _enterPasswordField = By.name("Password");
    private final By _enterConfirmedPasswordField = By.name("ConfirmPassword");
    private final By _clickOnRegisterButton = By.name("register-button");

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
}