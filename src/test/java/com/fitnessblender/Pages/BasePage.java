package com.fitnessblender.Pages;

import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2(topic = "reporting")
@Getter
public abstract class BasePage {
    protected final static String BASE_URL = "https://www.fitnessblender.com/";



    public String getCurrentURL() {
        String currentURL = WebDriverRunner.url();
        log.debug("Current page URL:" + currentURL);
        return currentURL;
    }
}
