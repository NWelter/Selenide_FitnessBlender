package com.fitnessblender.Pages.user;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.http.auth.UsernamePasswordCredentials;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

@Getter
@Log4j2(topic = "reporting")
public class Login extends BasePage {

    private SelenideElement usernameField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement signInButton = $("#single_click_submit");
    private SelenideElement loginAlert = $("div.login-alert");

//TODO String or Login method/overloading?
    public String loginUser(String username, String password) {
        log.info("Login user start.");
        log.info(String.format("Set username: '%s'", username));
        usernameField.setValue(username);
        log.info(String.format("Set password: '%s'", password));
        passwordField.setValue(password);
        signInButton.click();
        log.info("Login user finished.");
        String url = getCurrentURL();
        return url;
    }

}
