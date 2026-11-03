package com.gmail.doctatyana1.web_auto_tests.actions;

import com.gmail.doctatyana1.web_auto_tests.core.WebDriverProvider;
import com.gmail.doctatyana1.web_auto_tests.pages.ProductsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProductsPageActions extends BaseLandingPageActions implements PageAction {

    private final ProductsPage page;

    public ProductsPageActions(WebDriverProvider webDriverProvider, String url) {
        super(new ProductsPage(webDriverProvider.getRemoteWebDriver(), url));
        page = (ProductsPage) getPage();
    }

    public ProductsPageActions(WebDriverProvider webDriverProvider) {
        super(new ProductsPage(webDriverProvider.getRemoteWebDriver()));
        page = (ProductsPage) getPage();
    }

    @Override
    public boolean elementByNameIsDisplayed(String elementName) {
        return false;
    }

    @Override
    public boolean isPageReady() {
        return getPage().isReady();
    }

    public boolean isProductsPageTitleDisplayed() {
        return page.getProductsPageTitle().isDisplayed();
    }

    public boolean isCookieConsentDisplayed() {
        try {
            return page.getCookieConsent().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isQuickLinksTitleDisplayed() {
        return page.getQuickLinksTitle().isDisplayed();
    }

    public boolean isHeadquartersTitleDisplayed() {
        return page.getHeadquartersTitle().isDisplayed();
    }

    public boolean isSelectLanguageMenuEnabled() {
        return page.getSelectLanguageMenu().isEnabled();
    }

    public void waitForCookieConsentDisplayed() {
        page.getWait().until(ExpectedConditions.elementToBeClickable(page.getCookieConsent()));
    }

    public void acceptCookie() {
        page.getCookieConsent().click();
        page.getWait().until(ExpectedConditions.invisibilityOf(page.getCookieConsent()));
    }

    public void changeLanguage(String languageCode) {
        page.getWait().until(visibilityOf(page.getSelectLanguageMenu()));
        page.getLanguagesList().stream()
                .filter(e -> e.getText().trim().equals(languageCode))
                .findFirst()
                .orElseThrow(IllegalStateException::new)
                .click();
        page.getWait().until(visibilityOf(page.getSelectLanguageMenu()));
    }

    public String getSelectedLanguage() {
        return new Select(page.getSelectLanguageMenu()).getFirstSelectedOption().getText().trim();
    }

}
