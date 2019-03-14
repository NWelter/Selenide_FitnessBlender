package com.fitnessblender.Pages.user;

import com.codeborne.selenide.Condition;
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
    private SelenideElement loginAlert = $("div.login-alert ul");


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
                .shouldBe(Condition.appear)
                .text();
        log.debug(String.format("Message alert '%s' is displayed", messageAlert));
        return messageAlert;
    }

}
