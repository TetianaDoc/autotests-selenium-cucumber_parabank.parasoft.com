package com.gmail.doctatyana1.web_auto_tests.actions;

import com.gmail.doctatyana1.web_auto_tests.core.WebDriverProvider;
import com.gmail.doctatyana1.web_auto_tests.pages.SignUpPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Provides actions for {@link SignUpPage}.
 */

@Slf4j
public final class SignUpPageActions extends BaseLandingPageActions implements PageAction {

    private final SignUpPage page;

    public SignUpPageActions(WebDriverProvider webDriverProvider, String url) {
        super(new SignUpPage(webDriverProvider.getRemoteWebDriver(), url));
        page = (SignUpPage) getPage();
    }

    @Override
    public boolean isPageReady() {
        return getPage().isReady();
    }

    public boolean isSignUpPageTitleDisplayed() {
        return page.getSignUpPageTitle().isDisplayed();
    }

    public boolean isFirstNameInputEnabled() {
        return page.getFirstNameInput().isEnabled();
    }

    public boolean isLastNameInputEnabled() {
        return page.getLastNameInput().isEnabled();
    }

    public boolean isAddressStreetInputEnabled() {
        return page.getAddressStreetInput().isEnabled();
    }

    public boolean isAddressCityInputEnabled() {
        return page.getAddressCityInput().isEnabled();
    }

    public boolean isAddressStateInputEnabled() {
        return page.getAddressStateInput().isEnabled();
    }

    public boolean isAddressZipCodeInputEnabled() {
        return page.getAddressZipCodeInput().isEnabled();
    }

    public boolean isPhoneNumberInputEnabled() {
        return page.getPhoneNumberInput().isEnabled();
    }

    public boolean isSsnInputEnabled() {
        return page.getSsnInput().isEnabled();
    }

    public boolean isUserNameInputEnabled() {
        return page.getUserNameInput().isEnabled();
    }

    public boolean isPasswordInputEnabled() {
        return page.getPasswordInput().isEnabled();
    }


    public boolean isConfirmPasswordInputEnabled() {
        return page.getConfirmPasswordInput().isEnabled();
    }

    public boolean isRegisterButtonEnabled() {
        return page.getRegisterButton().isEnabled();
    }

    public boolean isRegistrationConfirmationTextDisplayed() {
        return page.getRegistrationConfirmationText().isDisplayed();
    }

    //For Cucumber
    @Override
    public boolean elementByNameIsDisplayed(String elementName) {
        return false;
    }

    //Actions provided for SignUp
    public void signUp(String firstName, String lastName, String address, String city,
                       String state, String zipCode, String phone, String ssn,
                       String username, String password, String confirm) {
        fillAndSubmitSignUpForm(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirm);
        if (page.getDriver().getPageSource().contains("This username already exists.")) {
            String uniqueUsername = username + (System.currentTimeMillis() % 100000);
            fillAndSubmitSignUpForm(firstName, lastName, address, city, state, zipCode, phone, ssn, uniqueUsername, password, confirm);
        }
    }

    private void fillAndSubmitSignUpForm(String firstName, String lastName, String address, String city,
                                         String state, String zipCode, String phone, String ssn,
                                         String username, String password, String confirm) {
        page.getFirstNameInput().clear();
        page.getFirstNameInput().sendKeys(firstName);
        page.getLastNameInput().clear();
        page.getLastNameInput().sendKeys(lastName);
        page.getAddressStreetInput().clear();
        page.getAddressStreetInput().sendKeys(address);
        page.getAddressCityInput().clear();
        page.getAddressCityInput().sendKeys(city);
        page.getAddressStateInput().clear();
        page.getAddressStateInput().sendKeys(state);
        page.getAddressZipCodeInput().clear();
        page.getAddressZipCodeInput().sendKeys(zipCode);
        page.getPhoneNumberInput().clear();
        page.getPhoneNumberInput().sendKeys(phone);
        page.getSsnInput().clear();
        page.getSsnInput().sendKeys(ssn);
        page.getUserNameInput().clear();
        page.getUserNameInput().sendKeys(username);
        page.getPasswordInput().clear();
        page.getPasswordInput().sendKeys(password);
        page.getConfirmPasswordInput().clear();
        page.getConfirmPasswordInput().sendKeys(confirm);
        page.getRegisterButton().click();
    }

}
