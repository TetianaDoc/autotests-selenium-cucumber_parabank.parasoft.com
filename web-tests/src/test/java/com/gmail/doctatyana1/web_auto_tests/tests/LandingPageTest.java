package com.gmail.doctatyana1.web_auto_tests.tests;

import com.gmail.doctatyana1.web_auto_tests.actions.AboutUsPageActions;
import com.gmail.doctatyana1.web_auto_tests.actions.LandingPageActions;
import com.gmail.doctatyana1.web_auto_tests.actions.ServicesPageActions;
import com.gmail.doctatyana1.web_auto_tests.pages.LandingPage;
import com.gmail.doctatyana1.web_auto_tests.model.SignInTestData;
import com.gmail.doctatyana1.web_auto_tests.model.SignInTestData.SignInTestDataByEnv;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link LandingPage} including sign in.
 */
@TestMethodOrder(OrderAnnotation.class)

class LandingPageTest extends BaseTest {

    private static final String TEST_DATA = "src/test/resources/test-data/signIn-test-data.yaml";
    private static SignInTestData signInTestData;
    private static LandingPageActions landingPageActions;
    private static AboutUsPageActions aboutUsPageActions;
    private static ServicesPageActions servicesPageActions;

    @BeforeAll
    static void beforeAll() throws IOException {
        setUp();
        SignInTestDataByEnv signInTestDataByEnv =
                readTestData(new File(TEST_DATA), SignInTestDataByEnv.class);
        signInTestData = signInTestDataByEnv.getEnvs().get(getEnvironment());
        landingPageActions = new LandingPageActions(provider, signInTestData.getBasicUrl());
        aboutUsPageActions = new AboutUsPageActions(provider);
        servicesPageActions = new ServicesPageActions(provider);
    }

    @AfterAll
    static void afterAll() {
        tierDown();
    }

    @Test
    @Order(1)
    @SuppressWarnings("java:S5961")
    void shouldProperDisplayAllElementsOnLandingPage() {
        // Act

        // Assert
        assertThat(landingPageActions.isPageReady()).isTrue();
        assertThat(landingPageActions.isHomeButtonEnabled()).isTrue();
        assertThat(landingPageActions.isContactButtonEnabled()).isTrue();
        assertThat(landingPageActions.isAboutUsButtonEnabled()).isTrue();
        assertThat(landingPageActions.isSolutionsTitleDisplayed()).isTrue();
        assertThat(landingPageActions.isAboutUsLinkOnLeftMenuEnabled()).isTrue();
        assertThat(landingPageActions.isServicesLinkOnLeftMenuEnabled()).isTrue();
        assertThat(landingPageActions.isProductsPageLinkOnLeftMenuEnabled()).isTrue();
        assertThat(landingPageActions.isLocationsPageLinkOnLeftMenuEnabled()).isTrue();
        assertThat(landingPageActions.isAdminPageLinkOnLeftMenuEnabled()).isTrue();
        assertThat(landingPageActions.isUsernameInputEnabled()).isTrue();
        assertThat(landingPageActions.isPasswordInputEnabled()).isTrue();
        assertThat(landingPageActions.isLogInButtonEnabled()).isTrue();
        assertThat(landingPageActions.isRestorePasswordLinkEnabled()).isTrue();
        assertThat(landingPageActions.isCustomerLoginTitleEnabled()).isTrue();
        assertThat(landingPageActions.isSignUpLinkEnabled()).isTrue();
        assertThat(landingPageActions.isUsernameTitleDisplayed()).isTrue();
        assertThat(landingPageActions.isPasswordTitleDisplayed()).isTrue();
        assertThat(landingPageActions.isLogoImgHomeLinkEnabled()).isTrue();
        assertThat(landingPageActions.isSloganTitleDisplayed()).isTrue();
        assertThat(landingPageActions.isAdminImgLinkEnabled()).isTrue();
        assertThat(landingPageActions.isHomeLinkOnFooterPanelEnabled()).isTrue();
        assertThat(landingPageActions.isAboutUsLinkOnFooterPanelEnabled()).isTrue();
        assertThat(landingPageActions.isServicesLinkOnFooterPanelEnabled()).isTrue();
        assertThat(landingPageActions.isProductsPageLinkOnFooterPanelEnabled()).isTrue();
        assertThat(landingPageActions.isLocationsPageLinkOnFooterPanelEnabled()).isTrue();
        assertThat(landingPageActions.isSiteMapLinkEnabled()).isTrue();
        assertThat(landingPageActions.isContactUsLinkEnabled()).isTrue();
        assertThat(landingPageActions.isCopyrightTitleDisplayed()).isTrue();
        assertThat(landingPageActions.isVisitUsLinkEnabled()).isTrue();
        assertThat(landingPageActions.isAtmServicesTitleDisplayed()).isTrue();
        assertThat(landingPageActions.isWithdrawFundsLinkEnabled()).isTrue();
        assertThat(landingPageActions.isTransferFundsAtmLinkEnabled()).isTrue();
        assertThat(landingPageActions.isCheckBalancesLinkEnabled()).isTrue();
        assertThat(landingPageActions.isMakeDepositsLinkEnabled()).isTrue();
        assertThat(landingPageActions.isOnlineServicesTitleDisplayed()).isTrue();
        assertThat(landingPageActions.isBillPayLinkEnabled()).isTrue();
        assertThat(landingPageActions.isAccountHistoryLinkEnabled()).isTrue();
        assertThat(landingPageActions.isTransferFundOnlineLinkEnabled()).isTrue();
        assertThat(landingPageActions.isLatestNewsTitleDisplayed()).isTrue();
        assertThat(landingPageActions.isCurrentDateDisplaed()).isTrue();
        assertThat(landingPageActions.isNews6LinkEnabled()).isTrue();
        assertThat(landingPageActions.isNews5LinkEnabled()).isTrue();
        assertThat(landingPageActions.isNews4LinkEnabled()).isTrue();
        assertThat(landingPageActions.isReadMoreServicesLinkEnabled()).isTrue();
        assertThat(landingPageActions.isReadMoreNewsLinkEnabled()).isTrue();
    }

    @Test
    @Order(2)
    void shouldOpenAboutUsPage() {
// Act
        landingPageActions.openAboutUsPage();

        // Assert
        assertThat(aboutUsPageActions.isInfoTitleDisplayed()).isTrue();
    }

    @Test
    @Order(3)
    void shouldOpenServicesPage() {
        //Act
        landingPageActions.openServicesPage();
        //Assert
        assertThat(servicesPageActions.isServicesTitleDisplayed()).isTrue();
    }

    @Test
    @Order(4)
    void shouldLoginUser() throws Exception {
        // Act
        landingPageActions.logIn(signInTestData.getUsername(), signInTestData.getPassword());

        // Assert
        assertThat(landingPageActions.isAccountsOverviewTitleDisplayed()).isTrue();
    }

    @Test
    @Order(5)
    void shouldRequestLoan() throws Exception {
        //Act
        landingPageActions.requestLoan(signInTestData.getLoanAmount(), signInTestData.getDownPayment());
        //Assert
        assertThat(landingPageActions.isLoanRequestProcessedTitleDisplayed()).isTrue();
    }

    @Test
    @Order(6)
    void shouldLogout() {
        //Act
        landingPageActions.logOut();
        //Assert
        assertThat(landingPageActions.isUsernameInputEnabled()).isTrue();
    }
}


