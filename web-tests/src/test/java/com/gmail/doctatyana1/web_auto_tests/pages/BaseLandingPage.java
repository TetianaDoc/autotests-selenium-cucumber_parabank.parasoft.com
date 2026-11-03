package com.gmail.doctatyana1.web_auto_tests.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Base landing page for pages {@link LandingPage}, {@link SignUpPage}, {@link AboutUsPage}, {@link ServicesPage}.
 */

@Getter
public abstract class BaseLandingPage extends BasePage {

    public BaseLandingPage(RemoteWebDriver remoteWebDriver, String url) {
        super(remoteWebDriver, url);
    }

    public BaseLandingPage(RemoteWebDriver remoteWebDriver) {
        super(remoteWebDriver);
    }

    //Elements of .leftMenu on #headerPanel

    @FindBy(className = "Solutions")
    private WebElement solutionsTitle;

    @FindBy(css = ".leftmenu>li a[href*=\"about.htm\"]")
    private WebElement aboutUsLinkOnLeftMenu;

    @FindBy(css = ".leftmenu>li a[href*=\"services.htm\"]")
    private WebElement servicesLinkOnLeftMenu;

    @FindBy(css = ".leftmenu>li a[href=\"http://www.parasoft.com/jsp/products.jsp\"]")
    private WebElement productsPageLinkOnLeftMenu;

    @FindBy(css = ".leftmenu>li a[href*=\"http://www.parasoft.com/jsp/pr/contacts.jsp\"]")
    private WebElement locationsPageLinkOnLeftMenu;

    @FindBy(css = ".leftmenu>li a[href*=\"admin.htm\"]")
    private WebElement adminPageLinkOnLeftMenu;

    //Elements of .button on #headerPanel

    @FindBy(css = ".home a[href*='index.htm']")
    private WebElement homeButton;

    @FindBy(css = ".button>li a[href*=\"about.htm\"]")
    private WebElement aboutUsButton;

    @FindBy(css = ".button>li a[href*=\"contact.htm\"]")
    private WebElement contactButton;

    //Elements of #loginPanel on #leftPanel of #bodyPanel

    @FindBy(css = "input[name=\"username\"]")
    private WebElement usernameInput;

    @FindBy(css = "input[name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "input[value=\"Log In\"]")
    private WebElement logInButton;

    @FindBy(css = "a[href*='lookup.htm']")
    private WebElement restorePasswordLink;

    @FindBy(xpath = "//div/h2[text()=\"Customer Login\"]")
    private WebElement customerLoginTitle;

    @FindBy(css = "a[href*=\"register.htm\"]")
    private WebElement signUpLink;

    @FindBy(xpath = "//form/p/b[text()=\"Username\"]")
    private WebElement usernameTitle;

    @FindBy(xpath = "//form/p/b[text()=\"Password\"]")
    private WebElement passwordTitle;

//Elements of #topPanel

    @FindBy(css = ".logo[title=\"ParaBank\"]")
    private WebElement logoImgHomeLink;

    @FindBy(xpath = "//div/p[text()=\"Experience the difference\"]")
    private WebElement sloganTitle;

    @FindBy(className = "admin")
    private WebElement adminImgLink;

//Elements on #footermainPanel

    @FindBy(css = "#footerPanel a[href*=\"index.htm\"]")
    private WebElement homeLinkOnFooterPanel;

    @FindBy(css = "#footerPanel a[href*=\"about.htm\"]")
    private WebElement aboutUsLinkOnFooterPanel;

    @FindBy(css = "#footerPanel a[href*=\"services.htm\"]")
    private WebElement servicesLinkOnFooterPanel;

    @FindBy(css = "#footerPanel a[href=\"http://www.parasoft.com/jsp/products.jsp\"]")
    private WebElement productsPageLinkOnFooterPanel;

    @FindBy(css = "#footerPanel  a[href*=\"http://www.parasoft.com/jsp/pr/contacts.jsp\"]")
    private WebElement locationsPageLinkOnFooterPanel;

    @FindBy(css = "#footerPanel a[href=\"http://forums.parasoft.com/\"]")
    private WebElement forumPageLink;

    @FindBy(css = "#footerPanel a[href*=\"sitemap.htm\"]")
    private WebElement siteMapLink;

    @FindBy(css = "#footerPanel a[href*=\"contact.htm\"]")
    private WebElement contactUsLink;

    @FindBy(className = "copyright")
    private WebElement copyrightTitle;

    @FindBy(css = ".visit a[href=\"http://www.parasoft.com/\"]")
    private WebElement visitUsLink;

    //The same web elements for Sign Up page and Landing (LogIn) page after users registration/logging

    @FindBy(xpath = "//a[text()='Request Loan']")
    private WebElement requestLoanLink;

    @FindBy(id = "amount")
    private WebElement loanAmount;

    @FindBy(id = "downPayment")
    private WebElement downPayment;

    @FindBy(css = ".button[value='Apply Now']")
    private WebElement applyNowButton;

    @FindBy(xpath = "//h1[text()='Loan Request Processed']")
    private WebElement loanRequestProceedTitle;

    @FindBy(xpath = "//a[text()='Log Out']")
    private WebElement logOutLink;

    @FindBy(xpath = "//a[text()='Update Contact Info']")
    private WebElement updateContactInfoLink;

    @FindBy(xpath = "//h1[text()='Update profile']")
    private WebElement updateProfileTitle;

    @FindBy(id = "customer.address.street")
    private WebElement addressStreetInput;

    @FindBy(id = "customer.firstName")
    private WebElement firstNameInput;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameInput;

    @FindBy(id = "customer.address.city")
    private WebElement addressCityInput;

    @FindBy(id = "customer.address.state")
    private WebElement addressStateInput;

    @FindBy(id = "customer.address.zipCode")
    private WebElement addressZipCodeInput;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(css = "input.button[value='Update Profile']")
    private WebElement formContact;

    @FindBy(xpath = "//h1[text()='Profile Updated']")
    private WebElement profileUpdatedTitle;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    private WebElement findTransactionsLink;

    @FindBy(xpath = "//a[text()='Bill Pay']")
    private WebElement billPayLink;

    @FindBy(xpath = "//a[text()='Transfer Funds']")
    private WebElement transferFundsLink;

    @FindBy(xpath = "//a[text()='Accounts Overview']")
    private WebElement accountsOverviewLink;

    @FindBy(xpath = "//a[text()='Open New Account']")
    private WebElement openNewAccountLink;
}
