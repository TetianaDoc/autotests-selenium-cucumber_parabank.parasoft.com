package com.gmail.doctatyana1.web_auto_tests.pages;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Landing (home and login) page.
 */
@Getter
public final class LandingPage extends BaseLandingPage {

    public LandingPage(RemoteWebDriver driver, String url) {
        super(driver, url);
        load();
        isLoaded();
    }

    @Override
    public boolean isReady() {
        getWait().until(visibilityOfAllElements(getUsernameInput()));
        return getUsernameInput().isDisplayed();
    }

    @Override
    public void isLoaded() throws Error {
        super.isLoaded();
        getWait().until(ExpectedConditions.elementToBeClickable(getHomeButton()));
    }

    //ATM services elements

    @FindBy(className = "captionone")
    private WebElement atmServicesTitle;

    @FindBy(xpath = "//*[text()='Withdraw Funds']")
    private WebElement withdrawFundsLink;

    @FindBy(xpath = "//*[@class=\"services\"]/li/a[text()=\"Transfer Funds\"]")
    private WebElement transferFundsAtmLink;

    @FindBy(xpath = "//*[text()=\"Check Balances\"]")
    private WebElement checkBalancesLink;

    @FindBy(xpath = "//*[text()=\"Make Deposits\"]")
    private WebElement makeDepositsLink;

//Online Services elements

    @FindBy(className = "captiontwo")
    private WebElement onlineServicesTitle;

    @FindBy(xpath = "//*[text()='Bill Pay']")
    private WebElement billPayLink;

    @FindBy(xpath = "//*[text()='Account History']")
    private WebElement accountHistoryLink;

    @FindBy(xpath = "//*[@class=\"servicestwo\"]/li/a[text()=\"Transfer Funds\"]")
    private WebElement transferFundOnlineLink;

    //Latest news elements

    @FindBy(xpath = "//div/h4[text()='Latest News']")
    private WebElement latestNewsTitle;

    @FindBy(className = "captionthree")
    private WebElement currentDate;

    @FindBy(css = "a[href*='#6']")
    private WebElement news6Link;

    @FindBy(css = "a[href*='#5']")
    private WebElement news5Link;

    @FindBy(css = "a[href*='#4']")
    private WebElement news4Link;

    @FindBy(css = ".more a[href*='services.htm']")
    private WebElement readMoreServicesLink;

    @FindBy(css = "a[href*='news.htm']")
    private WebElement readMoreNewsLink;

    //Elements appeared after successful login

    @FindBy(xpath = "//h1[normalize-space()='Accounts Overview']")
    private WebElement accountsOverviewTitle;

}
