package com.fitnessblender.Pages.user;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.Color;

import java.util.*;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
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
    private SelenideElement joinButton = $("#submitButton");


    public Map<SelenideElement, String> fillRegisterForm(String firstName, String lastName, String email,
                                                         String userName, String password, String confirmPassword) {

        Map<SelenideElement, String> registerForm = new LinkedHashMap<>();
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

        joinButton.click();

        return registerForm;
    }

    public String getRegisterFormValidationMessage(String firstName, String lastName, String email,
                                                   String userName, String password, String confirmPassword){

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

        String validationMessages = validationMessagesList.stream().collect(Collectors.joining((" | ")));
        log.debug(String.format("Current validation messages from register form: [%s]", validationMessages));

        return validationMessages;
    }


    public String getFieldBorderColor(SelenideElement invalidFormField){

        Color color = Color.fromString(
                                invalidFormField
                                .should(appear)
                                .getCssValue("border-color"));

        String borderColor = color.asHex();
        log.debug(String.format("Border color of \"%s\" field is: %s", invalidFormField.attr("name"), borderColor));

        return borderColor;
    }


    public String getNameOfInvalidFormField(String redBorderColor){
        List<SelenideElement> listOfFormFields = Arrays.asList(firstNameField, lastNameField, emailField,
                userNameField, passwordField, confirmPasswordField);
        List<String> listOfFormFieldsWithRedFrame = listOfFormFields
                                                        .stream()
                                                        .filter(field -> getFieldBorderColor(field).equals(redBorderColor)
                                                        && hasErrorIcon(field))
                                                        .map(SelenideElement::name)
                                                        .collect(Collectors.toList());
        log.debug(String.format("List of Register form fields with red border and an error icon: %s", listOfFormFieldsWithRedFrame.toString()));
        return listOfFormFieldsWithRedFrame.toString();
    }

    public boolean hasErrorIcon(SelenideElement field){
       boolean isErrorIconDisplayed = field.parent().find("span.iconfont-error").isDisplayed();
       log.debug(String.format("Input form field [%s] has an error icon: %s", field.attr("name"), isErrorIconDisplayed));

       return isErrorIconDisplayed;
    }
}

