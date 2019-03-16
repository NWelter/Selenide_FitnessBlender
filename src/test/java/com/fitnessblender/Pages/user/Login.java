package com.fitnessblender.Pages.user;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.Color;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;


@Getter
@Slf4j(topic = "reporting")
public class Login extends BasePage {

    private String url = BASE_URL + "/login";
    private String validBackgroundColor = "#ff505f";

    private SelenideElement usernameField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement signInButton = $("#single_click_submit");
    private SelenideElement loginAlert = $("div.login-alert");

    public Login loginUser(String username, String password) {
        log.info("Login user start.");
        log.debug(String.format("Set username: '%s'", username));
        usernameField.setValue(username);
        log.debug(String.format("Set password: '%s'", password));
        passwordField.setValue(password);
        signInButton.click();
        log.info("Login user finished.");
        return this;
    }

    public String getMessageAlert(){
        String messageAlert = loginAlert
                .shouldBe(appear)
                .text();
        //solve problem with new line characters causes by multiple child objects
        messageAlert = messageAlert.replaceAll("\\n", "").replaceAll("\\t", "");
        log.debug(String.format("Message alert '%s' is displayed", messageAlert));
        return messageAlert;
    }

    public String getMessageAlertBackgroundColor(){
        Color backgroundColor = Color.fromString(
                loginAlert
                .shouldBe(appear)
                .getCssValue("background-color"));
        String color = backgroundColor.asHex();
        log.debug(String.format("Background color of alert message is: %s", color));
        return color;
    }

}
