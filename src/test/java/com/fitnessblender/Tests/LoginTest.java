package com.fitnessblender.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.fitnessblender.Pages.BasePage.getCurrentURL;
import static com.fitnessblender.Pages.user.LoginPage.LOGIN_PAGE_URL;
import static com.fitnessblender.Pages.user.LoginPage.VALID_BACKGROUND_COLOR;
import static com.fitnessblender.Pages.user.UserDashboardPage.USER_DASHBOARD_PAGE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class LoginTest extends BaseTest {

    @ParameterizedTest(name = "When user set login \"{0}\" and password \"{1}\" then red alert message tile \"{2}\" is displayed.")
    @CsvFileSource(resources = "/login_validation.csv", numLinesToSkip = 1)
    public void userWithInvalidCredentialsShouldNotBeLogged(String login, String password, String alertMessage) {
        myFitnessDropdown.goToSignIn();

        assertAll("LoginPage options - negative test scenarios",
                () -> assertThat(
                        getCurrentURL())
                        .as("Current page URL")
                        .isEqualTo(LOGIN_PAGE_URL),

                () -> assertThat(
                        loginPage
                                .loginUser(login, password)
                                .getMessageAlert())
                        .as("An error message displayed for invalid login credentials")
                        .isEqualTo(alertMessage),

                () -> assertThat(
                        loginPage
                                .getMessageAlertBackgroundColor())
                        .as("Alert message has red background color")
                        .isEqualTo(VALID_BACKGROUND_COLOR)

        );

    }

    @Test
    @DisplayName("When user set valid credentials then should be logged.")
    public void userWithValidCredentialsShouldBeLogged() {
        myFitnessDropdown.goToSignIn();
        loginPage.loginDemoUser();

        assertThat(
                getCurrentURL())
                    .as("Current page URL")
                    .isEqualTo(USER_DASHBOARD_PAGE_URL);
    }
}
