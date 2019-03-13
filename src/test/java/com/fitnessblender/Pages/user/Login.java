package com.fitnessblender.Pages.user;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;


@Getter
@Slf4j(topic = "reporting")
public class Login extends BasePage {

    private SelenideElement usernameField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement signInButton = $("#single_click_submit");
    private SelenideElement loginAlert = $("div.login-alert");


    public Login loginUser(String username, String password) {
        log.info("Login user start.");
        log.info(String.format("Set username: '%s'", username));
        usernameField.setValue(username);
        log.info(String.format("Set password: '%s'", password));
        passwordField.setValue(password);
        signInButton.click();
        log.info("Login user finished.");
        return this;
    }

}
