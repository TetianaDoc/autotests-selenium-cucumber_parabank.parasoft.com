package com.gmail.doctatyana1.web_auto_tests.actions;
import com.gmail.doctatyana1.web_auto_tests.pages.LandingPage;
import com.gmail.doctatyana1.web_auto_tests.core.WebDriverProvider;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.String.format;

/**
 * Provides actions for {@link LandingPage} page.
 */
@Slf4j
public final class LandingPageActions extends BaseLandingPageActions implements PageAction {

    public LandingPageActions(WebDriverProvider webDriverProvider, String url) {
        super(new LandingPage(webDriverProvider.getRemoteWebDriver(), url));
        page = (LandingPage) getPage();
    }

    private final LandingPage page;

    @Override
    public boolean isPageReady() {
        return getPage().isReady();
    }

    public void logIn(String username, String password){
        page.getUsernameInput().sendKeys(username);
        page.getPasswordInput().sendKeys(password);
        page.getLogInButton().click();
        if (page.getDriver().getCurrentUrl().contains("login.htm")) {
            page.getSignUpLink().click();
            page.getFirstNameInput().sendKeys("Monika");
            page.getLastNameInput().sendKeys("Brown");
            page.getAddressStreetInput().sendKeys("Str.15");
            page.getAddressCityInput().sendKeys("New York");
            page.getAddressStateInput().sendKeys("Ohio");
            page.getAddressZipCodeInput().sendKeys("12345");
            page.getPhoneNumberInput().sendKeys("987654");
            page.getDriver().findElement(By.id("customer.ssn")).sendKeys("222222");
            page.getDriver().findElement(By.id("customer.username")).sendKeys(username);
            page.getDriver().findElement(By.id("customer.password")).sendKeys(password);
            page.getDriver().findElement(By.id("repeatedPassword")).sendKeys(password);
            page.getDriver().findElement(By.cssSelector("input[value='Register']")).click();
            page.getAccountsOverviewLink().click();
        }
    }

    public void openAboutUsPage() {
        page.getWait().until(ExpectedConditions.elementToBeClickable(page.getAboutUsLinkOnLeftMenu()));
        page.getAboutUsLinkOnLeftMenu().click();
    }

    public void openServicesPage(){
        page.getWait().until(ExpectedConditions.elementToBeClickable(page.getServicesLinkOnLeftMenu()));
        page.getServicesLinkOnLeftMenu().click();
    }

    //Actions provided for ATM services elements

    public boolean isAtmServicesTitleDisplayed() {
        return page.getAtmServicesTitle().isDisplayed();
    }

    public boolean isWithdrawFundsLinkEnabled() {
        return page.getWithdrawFundsLink().isEnabled();
    }

    public boolean isTransferFundsAtmLinkEnabled() {
        return page.getTransferFundsAtmLink().isEnabled();
    }

    public boolean isCheckBalancesLinkEnabled() {
        return page.getCheckBalancesLink().isEnabled();
    }

    public boolean isMakeDepositsLinkEnabled() {
        return page.getMakeDepositsLink().isEnabled();
    }

    //Actions provided for Online Services elements

    public boolean isOnlineServicesTitleDisplayed() {
        return page.getOnlineServicesTitle().isDisplayed();
    }

    public boolean isBillPayLinkEnabled() {
        return page.getBillPayLink().isEnabled();
    }

    public boolean isAccountHistoryLinkEnabled() {
        return page.getAccountHistoryLink().isEnabled();
    }

    public boolean isTransferFundOnlineLinkEnabled() {
        return page.getTransferFundOnlineLink().isEnabled();
    }

    //Actions provided for Latest news elements

    public boolean isLatestNewsTitleDisplayed() {
        return page.getLatestNewsTitle().isDisplayed();
    }

    public boolean isCurrentDateDisplaed() {
        return page.getCurrentDate().isDisplayed();
    }

    public boolean isNews6LinkEnabled() {
        return page.getNews6Link().isEnabled();
    }

    public boolean isNews5LinkEnabled() {
        return page.getNews5Link().isEnabled();
    }

    public boolean isNews4LinkEnabled() {
        return page.getNews4Link().isEnabled();
    }

    public boolean isReadMoreServicesLinkEnabled() {
        return page.getReadMoreServicesLink().isEnabled();
    }

    public boolean isReadMoreNewsLinkEnabled() {
        return page.getReadMoreNewsLink().isEnabled();
    }

    //For Cucumber
    private static final String PAGE_TITLE_PATTERN = "//*[contains(text(),'%s')]";

    @Override
    public boolean elementByNameIsDisplayed(String elementByName) {
        return getPage().getDriver().findElement(By.xpath(format(PAGE_TITLE_PATTERN, elementByName))).isDisplayed();
    }

    private static final String INPUT_TYPE_PATTERN = "input[type='%s']";

    public boolean elementByInputTypeIsEnabled(String elementByInputType){
        return getPage().getDriver().findElement(By.cssSelector(format(INPUT_TYPE_PATTERN, elementByInputType))).isEnabled();
    }
    //Actions provided for elements after successful login

    public boolean isAccountsOverviewTitleDisplayed(){
        return page.getAccountsOverviewTitle().isDisplayed();
    }
}
