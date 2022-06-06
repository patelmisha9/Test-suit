package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils {
    LoadProperties loadProperties = new LoadProperties();
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
        typeText((_firstNameFiled), loadProperties.getProperty("First"));

        //enter last name
        typeText(_lastNameField, loadProperties.getProperty("Last"));

        //select the day in date of birth drop down menu
        Select Birthday = new Select(driver.findElement(_dateOfBirthdayField));
        Birthday.selectByIndex(Integer.parseInt(loadProperties.getProperty("Dateofbirth")));


        //select the month
        Select birthmonth = new Select(driver.findElement(_birthdayMonthField));
        birthmonth.selectByValue(loadProperties.getProperty("Birthmonth"));


        //select the year
        Select birthyear = new Select(driver.findElement(_birthdayYearField));
        birthyear.selectByVisibleText(loadProperties.getProperty("Birthyear"));


        //enter email
        typeText(_enterEmailField, loadProperties.getProperty("Emailpartone") + randomDate() + loadProperties.getProperty("Emailparttwo"));

        //enter password
        typeText(_enterPasswordField, (loadProperties.getProperty("Password")));

        //enter confirm password
        typeText(_enterConfirmedPasswordField, loadProperties.getProperty("Confirmedpassword"));


        // click on register button
        clickonElement(_clickOnRegisterButton);


    }

    public void clickOnContinueButton() {
        clickonElement(_continue);
    }
}