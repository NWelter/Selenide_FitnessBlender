package com.fitnessblender.Tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;

import static com.fitnessblender.Pages.BasePage.getCurrentURL;
import static com.fitnessblender.Pages.user.LoginPage.VALID_BACKGROUND_COLOR;
import static com.fitnessblender.Pages.user.RegisterPage.REGISTER_PAGE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class RegisterTest extends BaseTest {

    @ParameterizedTest(name = "When user set first name: \"{0}\", " +
                                                "last name: \"{1}\", " +
                                                "e-mail: \"{2}\", " +
                                                "username: \"{3}\", " +
                                                "password: \"{4}\", " +
                                                "confirm password: \"{5}\", then warning message is displayed.")
    @CsvFileSource(resources = "/register_validation.csv", numLinesToSkip = 1)
    public void userWithInvalidDataShouldNotBeRegister(String firstName, String lastName, String email,
                                                       String username, String password, String confirmPassword,
                                                       String validatorMessage) {
        myFitnessDropdown.goToJoin();
        //TODO add color assertion and prepare valid parameters values in register_validation.csv
        assertAll("RegisterPage options - negative test scenarios",
                ()-> assertThat(
                    getCurrentURL())
                        .as("Current page URL")
                        .isEqualTo(REGISTER_PAGE_URL),

                ()-> assertThat(
                        registerPage.getRegisterFormValidationMessage
                                (firstName, lastName, email, username, password, confirmPassword))
                            .as("Proper warning message under input fields filled with invalid data is displayed")
                            .isEqualTo(validatorMessage)


                );

       // registerPage.getNameOfInvalidFormFieldRedFramed(VALID_BACKGROUND_COLOR);
    }

}
