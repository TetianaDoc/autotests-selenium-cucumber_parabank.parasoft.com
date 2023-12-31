package com.gmail.doctatyana1.web_auto_tests.tests;
import static org.assertj.core.api.Assertions.assertThat;
import com.gmail.doctatyana1.web_auto_tests.pages.SignUpPage;
import com.gmail.doctatyana1.web_auto_tests.actions.SignUpPageActions;
import com.gmail.doctatyana1.web_auto_tests.model.SignUpTestData;
import com.gmail.doctatyana1.web_auto_tests.model.SignUpTestData.SignUpTestDataByEnv;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Tests for {@link SignUpPage}.
 */

@TestMethodOrder(OrderAnnotation.class)

class SignUpPageTest extends BaseTest {

    private static final String TEST_DATA = "src/test/resources/test-data/signUp-test-data.yaml";
    private static SignUpTestData signUpTestData;
    private static SignUpPageActions signUpActions;

    @BeforeAll
    static void beforeAll() throws IOException {
        setUp();
        SignUpTestDataByEnv signUpTestDataByEnv =
                readTestData(new File(TEST_DATA), SignUpTestDataByEnv.class);
        signUpTestData = signUpTestDataByEnv.getEnvs().get(getEnvironment());
        signUpActions = new SignUpPageActions(provider, signUpTestData.getBasicUrl());
    }

    @AfterAll
    static void afterAll() {
        tierDown();
    }

    @Test
    @Order(1)
    void shouldProperDisplayAllElementsOnSignUpPage() {
        //Assert
        assertThat(signUpActions.isPageReady()).isTrue();
        assertThat(signUpActions.isSignUpPageTitleDisplayed()).isTrue();
        assertThat(signUpActions.isFirstNameInputEnabled()).isTrue();
        assertThat(signUpActions.isLastNameInputEnabled()).isTrue();
        assertThat(signUpActions.isAddressStreetInputEnabled()).isTrue();
        assertThat(signUpActions.isAddressCityInputEnabled()).isTrue();
        assertThat(signUpActions.isAddressStateInputEnabled()).isTrue();
        assertThat(signUpActions.isAddressZipCodeInputEnabled()).isTrue();
        assertThat(signUpActions.isPhoneNumberInputEnabled()).isTrue();
        assertThat(signUpActions.isSsnInputEnabled()).isTrue();
        assertThat(signUpActions.isUserNameInputEnabled()).isTrue();
        assertThat(signUpActions.isPasswordInputEnabled()).isTrue();
        assertThat(signUpActions.isConfirmPasswordInputEnabled()).isTrue();
        assertThat(signUpActions.isRegisterButtonEnabled()).isTrue();
    }

    @Test
    @Order(2)
    void shouldRegisterUserAndOpenDashboardHomePage() throws Exception {
        // Act
        signUpActions.signUp(signUpTestData.getFirstName(),
                signUpTestData.getLastName(),
                signUpTestData.getAddress(),
                signUpTestData.getCity(),
                signUpTestData.getState(),
                signUpTestData.getZipCode(),
                signUpTestData.getPhone(),
                signUpTestData.getSsn(),
                signUpTestData.getUsername(),
                signUpTestData.getPassword(),
                signUpTestData.getConfirm());

        // Assert
        assertThat(signUpActions.isRegistrationConfirmationTextDisplayed()).isTrue();
    }
    @Test
    @Order(3)
    void shouldRequestLoan() throws Exception{
        //Act
        signUpActions.requestLoan(signUpTestData.getLoanAmount(),
                signUpTestData.getDownPayment());
        //Assert
        assertThat(signUpActions.isLoanRequestProcessedTitleDisplayed()).isTrue();
    }


    @Test
    @Order(4)
    void shouldUpdateProfile() {
        //Act
        signUpActions.updateProfile(
                signUpTestData.getFirstNameUpdated(),
                signUpTestData.getLastNameUpdated(),
                signUpTestData.getStreetUpdated(),
                signUpTestData.getCityUpdated(),
                signUpTestData.getStateUpdated(),
                signUpTestData.getZippCodeUpdated());
        //Assert
        assertThat(signUpActions.isProfileUpdatedTitleDisplayed()).isTrue();
    }

    @Test
    @Order(5)
    void shouldLogout() throws Exception{
        //Act
        signUpActions.logOut();
        //Assert
        assertThat(signUpActions.isUsernameInputEnabled()).isTrue();
    }
}


