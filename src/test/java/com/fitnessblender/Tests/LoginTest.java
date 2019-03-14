package com.fitnessblender.Tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.fitnessblender.Pages.BasePage.getCurrentURL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Slf4j(topic = "reporting")
public class LoginTest extends BaseTest {

    @ParameterizedTest(name = "When user set login \"{0}\" and password \"{1}\" then alert message \"{2}\" is displayed.")
    @CsvFileSource(resources = "/login_validation.csv", numLinesToSkip = 1)
    public void whenUserSetInvalidCredentialsThenShouldNotLogin(String login, String password, String alertMessage) {
        myFitnessDropdown.goToSignIn();

        assertAll("Login negative tests",
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
                        .isEqualTo("rgba(255, 80, 95, 1)")
        );

    }
}
