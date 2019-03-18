package com.fitnessblender.Pages.user;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.Color;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;


@Getter
@Slf4j(topic = "reporting")
public class LoginPage extends BasePage {

    public static final String LOGIN_PAGE_URL = BASE_URL + "/login";
    public static final String VALID_BACKGROUND_COLOR = "#ff505f";
    public static final String DEMO_USER_NAME = "GerwazyMoczymord";
    public static final String DEMO_USER_PASSWORD = "gerwazy9999";

    private SelenideElement usernameField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement signInButton = $("#single_click_submit");
    private SelenideElement loginAlert = $("div.login-alert");

    public LoginPage loginUser(String username, String password) {
        log.info("LoginPage user start.");
        log.debug(String.format("Set username: '%s'", username));
        usernameField.setValue(username);
        log.debug(String.format("Set password: '%s'", password));
        passwordField.setValue(password);
        signInButton.click();
        log.info("LoginPage user finished.");
        return this;
    }

    public UserDashboardPage loginDemoUser(){
        loginUser(DEMO_USER_NAME, DEMO_USER_PASSWORD);
        return new UserDashboardPage();
    }

    public String getMessageAlert() {
        String messageAlert = loginAlert
                .shouldBe(appear)
                .text();
        //solve problem with new line characters causes by get text from multiple child objects
        messageAlert = messageAlert.replaceAll("\\n", "").replaceAll("\\t", "");
        log.debug(String.format("Message alert '%s' is displayed", messageAlert));
        return messageAlert;
    }

    public String getMessageAlertBackgroundColor() {
        Color backgroundColor = Color.fromString(
                loginAlert
                .shouldBe(appear)
                .getCssValue("background-color"));

        log.debug(String.format("Background color of alert message in rgba format is: %s", backgroundColor.toString()));
        //change background color format from rgba to hex
        String color = backgroundColor.asHex();
        log.debug(String.format("Background color of alert message in hex format is: %s", color));
        return color;
    }

}
