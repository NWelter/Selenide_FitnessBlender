package com.fitnessblender.Pages.user;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

@Getter
@Log4j2(topic = "reporting")
public class Login extends BasePage {

    private SelenideElement username = $("#username");
    private SelenideElement password = $("#password");
    private SelenideElement signInButton = $("#single_click_submit");

    public Login loginUser(String username, String password) {
        log.info("Login user start.");
        this.username
                .shouldBe(visible)
                .clear();
        this.username
                .sendKeys(username);
        log.info("Set username: " + username);
        this.password
                .shouldBe(visible)
                .clear();
        this.password
                .sendKeys(password);
        log.info("Set password: " + password);
        signInButton
                .shouldBe(visible)
                .click();
        log.info("Login user finished.");
        return this;
    }

}
