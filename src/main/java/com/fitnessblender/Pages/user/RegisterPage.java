package com.fitnessblender.Pages.user;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;


@Slf4j(topic = "reporting")
public class RegisterPage extends BasePage {

    public final static String REGISTER_PAGE_URL = BASE_URL + "/join";

    private SelenideElement firstNameField = $("#first_name");
    private SelenideElement lastNameField = $("#last_name");
    private SelenideElement emailField = $("#email");
    private SelenideElement userNameField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement confirmPasswordField = $("#password_confirmation");

    //TODO finish methods to fill and validation register form fields
    public Map<SelenideElement, String> fillRegisterForm(String firstName, String lastName, String email,
                                                         String userName, String password, String confirmPassword) {
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
                    log.info(String.format("Set value '%s' in '%s'", value, key.attr("name")));
                    key.setValue(value);
                });

        return registerForm;
    }

    public String getRegisterFormValidationMessage(String firstName, String lastName, String email,
                                                   String userName, String password, String confirmPassword){
        //TODO finish method, add condition and logs
        List<String> validationMessagesList = new ArrayList<>();
        Map<SelenideElement, String> completedRegisterForm = fillRegisterForm(firstName, lastName, email, userName,
                                                                            password, confirmPassword);
        completedRegisterForm.forEach(
                (key, value) ->
                {
                    if(key.parent().$("span.message").isDisplayed()) {
                        String inputFormFieldMessage = key.parent().$("span.message").text();
                        validationMessagesList.add(inputFormFieldMessage);
                    }
                });

        String validationMessages = validationMessagesList.stream().collect(Collectors.joining(("|")));
        log.debug(String.format("Current validation messages from register form: [%s]", validationMessages));

        return validationMessages;
    }
}