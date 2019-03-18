package com.fitnessblender.Pages.user;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

@Slf4j(topic = "reporting")
@Data
public class RegisterPage extends BasePage {

    public final static String REGISTER_PAGE_URL = BASE_URL + "/join";

    private SelenideElement firstNameField = $("#first_name");
    private SelenideElement lastNameField = $("#last_name");
    private SelenideElement emailField = $("#email");
    private SelenideElement userNameField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement confirmPasswordField = $("#password_confirmation");

    //TODO finish methods to fill and validation form fields
    public RegisterPage fillRegisterForm(String firstName, String lastName, String email, String userName, String password, String confirmPassword) {
        Map<SelenideElement, String> registerForm = new HashMap<>();
        registerForm.put(firstNameField, firstName);
        registerForm.put(lastNameField, lastName);
        registerForm.put(emailField, email);
        registerForm.put(userNameField, userName);
        registerForm.put(passwordField, password);
        registerForm.put(confirmPasswordField, confirmPassword);

        registerForm.forEach(
                (key, value) ->
                {
                    log.debug(String.format("Set value '%s' in '%s'", value, key.toString()));
                    key.setValue(value);
                });

        return this;
    }

}
