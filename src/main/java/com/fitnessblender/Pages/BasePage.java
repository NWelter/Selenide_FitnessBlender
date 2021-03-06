package com.fitnessblender.Pages;

import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "reporting")
@Getter
public abstract class BasePage {

    protected final static String BASE_URL = "https://www.fitnessblender.com";

    public static String getCurrentURL() {
        String currentURL = WebDriverRunner.url();
        log.debug(String.format("Current page URL: %s" , currentURL));
        return currentURL;
    }
}
