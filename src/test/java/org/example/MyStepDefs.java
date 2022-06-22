package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();
    @Given("I am on registeration page")
    public void i_am_on_registeration_page() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnRegisterButton();
    }
    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.userRegistrationDetails();
    }

    @Then("I should able to registered successfully")
    public void i_should_able_to_registered_successfully() {
        // Write code here that turns the phrase above into concrete actions
        registrationSuccessPage.verifyUserIsRegisterSuccessfully();
    }
    @Given("I am on homepage")
    public void i_am_on_homepage() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I click on {string} link from top header menu")
    public void i_click_on_link_from_top_header_menu(String text) {

        homePage.clickOnAllPages(text);
    }
    @Then("I should be able to successfully navigated to related {string} category page")
    public void i_should_be_able_to_successfully_navigated_to_related_category_page(String string) {
    homePage.verifyUrlForAllPages(string);
    }

}
