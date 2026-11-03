package com.gmail.doctatyana1.web_auto_tests.actions;

import com.gmail.doctatyana1.web_auto_tests.pages.BaseLandingPage;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Actions for {@link BaseLandingPage}
 */
@Getter
public abstract class BaseLandingPageActions extends BasePageActions {

    public BaseLandingPageActions(BaseLandingPage page) {
        super(page);
    }

    //Actions provided for Elements of .leftMenu on #headerPanel

    public boolean isSolutionsTitleDisplayed() {
        return ((BaseLandingPage) getPage()).getSolutionsTitle().isDisplayed();
    }

    public boolean isAboutUsLinkOnLeftMenuEnabled() {
        return ((BaseLandingPage) getPage()).getAboutUsLinkOnLeftMenu().isEnabled();
    }

    public boolean isServicesLinkOnLeftMenuEnabled() {
        return ((BaseLandingPage) getPage()).getServicesLinkOnLeftMenu().isEnabled();
    }

    public boolean isProductsPageLinkOnLeftMenuEnabled() {
        return ((BaseLandingPage) getPage()).getProductsPageLinkOnLeftMenu().isEnabled();
    }

    public boolean isLocationsPageLinkOnLeftMenuEnabled() {
        return ((BaseLandingPage) getPage()).getLocationsPageLinkOnLeftMenu().isEnabled();
    }

    public boolean isAdminPageLinkOnLeftMenuEnabled() {
        return ((BaseLandingPage) getPage()).getAdminPageLinkOnLeftMenu().isEnabled();
    }

    //Actions provided for Elements of .button on #headerPanel

    public boolean isHomeButtonEnabled() {
        return ((BaseLandingPage) getPage()).getHomeButton().isEnabled();
    }

    public boolean isAboutUsButtonEnabled() {
        return ((BaseLandingPage) getPage()).getAboutUsButton().isEnabled();
    }

    public boolean isContactButtonEnabled() {
        return ((BaseLandingPage) getPage()).getContactButton().isEnabled();
    }

//Actions provided for Elements of #loginPanel on #leftPanel of #bodyPanel

    public boolean isUsernameInputEnabled() {
        return ((BaseLandingPage) getPage()).getUsernameInput().isEnabled();
    }

    public boolean isPasswordInputEnabled() {
        return ((BaseLandingPage) getPage()).getPasswordInput().isEnabled();
    }

    public boolean isLogInButtonEnabled() {
        return ((BaseLandingPage) getPage()).getLogInButton().isEnabled();
    }

    public boolean isRestorePasswordLinkEnabled() {
        return ((BaseLandingPage) getPage()).getRestorePasswordLink().isEnabled();
    }

    public boolean isCustomerLoginTitleEnabled() {
        return ((BaseLandingPage) getPage()).getCustomerLoginTitle().isEnabled();
    }

    public boolean isSignUpLinkEnabled() {
        return ((BaseLandingPage) getPage()).getSignUpLink().isEnabled();
    }

    public boolean isUsernameTitleDisplayed() {
        return ((BaseLandingPage) getPage()).getUsernameTitle().isDisplayed();
    }

    public boolean isPasswordTitleDisplayed() {
        return ((BaseLandingPage) getPage()).getPasswordTitle().isDisplayed();
    }

    //Actions provided for Elements of #topPanel

    public boolean isLogoImgHomeLinkEnabled() {
        return ((BaseLandingPage) getPage()).getLogoImgHomeLink().isEnabled();
    }

    public boolean isSloganTitleDisplayed() {
        return ((BaseLandingPage) getPage()).getSloganTitle().isDisplayed();
    }

    public boolean isAdminImgLinkEnabled() {
        return ((BaseLandingPage) getPage()).getAdminImgLink().isEnabled();
    }

    //Actions provided for Elements on #footermainPanel

    public boolean isHomeLinkOnFooterPanelEnabled() {
        return ((BaseLandingPage) getPage()).getHomeLinkOnFooterPanel().isEnabled();
    }

    public boolean isAboutUsLinkOnFooterPanelEnabled() {
        return ((BaseLandingPage) getPage()).getAboutUsLinkOnLeftMenu().isEnabled();
    }

    public boolean isServicesLinkOnFooterPanelEnabled() {
        return ((BaseLandingPage) getPage()).getServicesLinkOnFooterPanel().isEnabled();
    }

    public boolean isProductsPageLinkOnFooterPanelEnabled() {
        return ((BaseLandingPage) getPage()).getProductsPageLinkOnFooterPanel().isEnabled();
    }

    public boolean isLocationsPageLinkOnFooterPanelEnabled() {
        return ((BaseLandingPage) getPage()).getLocationsPageLinkOnFooterPanel().isEnabled();
    }

    public boolean isForumPageLinkEnabled() {
        return ((BaseLandingPage) getPage()).getForumPageLink().isEnabled();
    }

    public boolean isSiteMapLinkEnabled() {
        return ((BaseLandingPage) getPage()).getSiteMapLink().isEnabled();
    }

    public boolean isContactUsLinkEnabled() {
        return ((BaseLandingPage) getPage()).getContactUsLink().isEnabled();
    }

    public boolean isCopyrightTitleDisplayed() {
        return ((BaseLandingPage) getPage()).getCopyrightTitle().isDisplayed();
    }

    public boolean isVisitUsLinkEnabled() {
        return ((BaseLandingPage) getPage()).getVisitUsLink().isEnabled();
    }

    //Actions for LogOut
    public void logOut() {
        ((BaseLandingPage) getPage()).getLogOutLink().click();
    }

    //Actions provide for Request loan
    public void requestLoan(String loanAmount, String downPayment) {
        ((BaseLandingPage) getPage()).getRequestLoanLink().click();
        ((BaseLandingPage) getPage()).getLoanAmount().sendKeys(loanAmount);
        ((BaseLandingPage) getPage()).getDownPayment().sendKeys(downPayment);
        ((BaseLandingPage) getPage()).getApplyNowButton().click();
    }

    public boolean isLoanRequestProcessedTitleDisplayed() {
        getPage().getWait().until(ExpectedConditions.visibilityOf(((BaseLandingPage) getPage()).getLoanRequestProceedTitle()));
        return ((BaseLandingPage) getPage()).getLoanRequestProceedTitle().isDisplayed();
    }

    //Actions provided for Update Contact Info
    public void updateProfile(String firstNameUpdated, String lastNameUpdated, String streetUpdated, String cityUpdated, String stateUpdated, String zippCodeUpdated) {
        BaseLandingPage baseLandingPage = ((BaseLandingPage) getPage());
        baseLandingPage.getUpdateContactInfoLink().click();
        getPage().getWait().until(d -> !baseLandingPage.getFirstNameInput().getAttribute("value").isEmpty());
        baseLandingPage.getFirstNameInput().clear();
        baseLandingPage.getFirstNameInput().sendKeys(firstNameUpdated);
        baseLandingPage.getLastNameInput().clear();
        baseLandingPage.getLastNameInput().sendKeys(lastNameUpdated);
        baseLandingPage.getAddressStreetInput().clear();
        baseLandingPage.getAddressStreetInput().sendKeys(streetUpdated);
        baseLandingPage.getAddressCityInput().clear();
        baseLandingPage.getAddressCityInput().sendKeys(cityUpdated);
        baseLandingPage.getAddressStateInput().clear();
        baseLandingPage.getAddressStateInput().sendKeys(stateUpdated);
        baseLandingPage.getAddressZipCodeInput().clear();
        baseLandingPage.getAddressZipCodeInput().sendKeys(zippCodeUpdated);
        baseLandingPage.getFormContact().click();
    }

    public boolean isProfileUpdatedTitleDisplayed() {
        getPage().getWait().until(ExpectedConditions.visibilityOf(((BaseLandingPage) getPage()).getProfileUpdatedTitle()));
        return ((BaseLandingPage) getPage()).getProfileUpdatedTitle().isDisplayed();
    }

    //Actions provided for Find Transactions
    public void findTransactions() {
        ((BaseLandingPage) getPage()).getFindTransactionsLink().click();
    }

    //Actions provided for Bill Pay
    public void billPay() {
        ((BaseLandingPage) getPage()).getBillPayLink().click();
    }

    //Actions provided for Transfer Funds
    public void transferFunds() {
        ((BaseLandingPage) getPage()).getTransferFundsLink().click();
    }

    //Actions provided for Accounts Overview
    public void accountsOverview() {
        ((BaseLandingPage) getPage()).getAccountsOverviewLink().click();
    }

    //Actions provided for Open New Account
    public void openNewAccount() {
        ((BaseLandingPage) getPage()).getOpenNewAccountLink().click();
    }

    //Actions to display elements by name for Cucumber
    public abstract boolean elementByNameIsDisplayed(String elementName);

}
