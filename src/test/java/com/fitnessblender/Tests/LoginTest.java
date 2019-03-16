package com.fitnessblender.Tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.fitnessblender.Pages.BasePage.getCurrentURL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class LoginTest extends BaseTest {

    @ParameterizedTest(name = "When user set login \"{0}\" and password \"{1}\" then red alert message tile \"{2}\" is displayed.")
    @CsvFileSource(resources = "/login_validation.csv", numLinesToSkip = 1)
    public void userWithInvalidCredentialsShouldNotBeLogged(String login, String password, String alertMessage) {
        myFitnessDropdown.goToSignIn();

        assertAll("Login options - negative test scenarios",
                () -> assertThat(
                        getCurrentURL())
                        .as("Current page URL")
                        .isEqualTo(loginPage.getUrl()),

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
                        .isEqualTo(loginPage.getValidBackgroundColor())

        );

    }
}
