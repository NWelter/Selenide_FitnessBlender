package com.fitnessblender.Tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.fitnessblender.Pages.BasePage.getCurrentURL;
import static org.assertj.core.api.Assertions.assertThat;

//TODO complete test
public class RegisterTest extends BaseTest{

    @ParameterizedTest(name = "When user set first name \"{0}\", " +
                                            "last name  \"{1}\",  " +
                                            "e-mail \"{2}\", " +
                                            "username  \"{3}\", " +
                                            "password  \"{4}\"," +
                                            "confirm password  \"{5}\",then .... is displayed.")
    @CsvFileSource(resources = "/register_validation.csv", numLinesToSkip = 1)
    public void userWithInvalidDataShouldNotBeRegister(String firstName, String lastName, String email,
                                                       String username, String password, String confirmPassword){
        myFitnessDropdown.goToJoin();

        assertThat(getCurrentURL())
            .as("")
            .isEqualTo(registerPage.REGISTER_PAGE_URL);

        registerPage.getRegisterFormValidationMessage(firstName, lastName, email, username, password, confirmPassword);


    }

}
