package com.gmail.doctatyana1.web_auto_tests.steps;

import com.gmail.doctatyana1.web_auto_tests.actions.AboutUsPageActions;
import com.gmail.doctatyana1.web_auto_tests.actions.LandingPageActions;
import com.gmail.doctatyana1.web_auto_tests.actions.ServicesPageActions;
import com.gmail.doctatyana1.web_auto_tests.model.SignInTestData;
import com.gmail.doctatyana1.web_auto_tests.tests.BaseTest;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPageStepDefs extends BaseTest {

    private static final String TEST_DATA = "src/test/resources/test-data/signIn-test-data.yaml";

    private static SignInTestData signInTestData;
    private static LandingPageActions landingPageActions;
    private static AboutUsPageActions aboutUsPageActions;
    private static ServicesPageActions servicesPageActions;

    @BeforeAll
    public static void beforeAll() throws IOException {
        setUp();
        SignInTestData.SignInTestDataByEnv signInTestDataByEnv =
                readTestData(new File(TEST_DATA), SignInTestData.SignInTestDataByEnv.class);
        signInTestData = signInTestDataByEnv.getEnvs().get(getEnvironment());
        landingPageActions = new LandingPageActions(provider, signInTestData.getBasicUrl());
        aboutUsPageActions = new AboutUsPageActions(provider);
        servicesPageActions = new ServicesPageActions(provider);
    }


    @AfterAll
    public static void afterAll() {
        landingPageActions.tearDown();
    }

    @When("the landing page is open")
    public void theLandingPageIsOpen() {
        assertThat(landingPageActions.isPageReady()).isTrue();
    }

    @Then("{string} is visible")
    public void isVisible(String elementByName) {
        assertThat(landingPageActions.elementByNameIsDisplayed(elementByName)).isTrue();
    }

    @Then("{string} is enabled")
    public void isEnabled(String elementByInputType) {
        assertThat(landingPageActions.elementByInputTypeIsEnabled(elementByInputType)).isTrue();
    }

    @When("click on About us link")
    public void clickOnAboutUsLink() {
        landingPageActions.openAboutUsPage();
    }

    @Then("info title on About Us page is displayed")
    public void infoTitleOnAboutUsPageIsDisplayed() {
        assertThat(aboutUsPageActions.isInfoTitleDisplayed()).isTrue();
    }

    @When("click on Services link")
    public void clickOnServicesLink() {
        landingPageActions.openServicesPage();
    }

    @Then("services title on Services page is displayed")
    public void servicesTitleOnServicesPageIsDisplayed() {
        assertThat(servicesPageActions.isServicesTitleDisplayed()).isTrue();
    }

    @When("input username, password and click button log in")
    public void inputUsernamePasswordAndClickButtonLogIn() {
        landingPageActions.logIn(signInTestData.getUsername(), signInTestData.getPassword());
    }

    @Then("Accounts Overview Title is displayed")
    public void accountsOverviewTitleIsDisplayed() {
        assertThat(landingPageActions.isAccountsOverviewTitleDisplayed()).isTrue();
    }

    @When("click on logout")
    public void clickOnLogout() {
        landingPageActions.logOut();
    }

    @Then("username input enabled")
    public void usernameInputEnabled() {
        assertThat(landingPageActions.isUsernameInputEnabled()).isTrue();
    }

    @When("click on Request loan and input data and click apply button")
    public void requestLoan() {
        landingPageActions.requestLoan(signInTestData.getLoanAmount(), signInTestData.getDownPayment());
    }

    @Then("request processed title displayed")
    public void requestProcessedTitleDisplayed() {
        assertThat(landingPageActions.isLoanRequestProcessedTitleDisplayed()).isTrue();
    }
}
