package com.fitnessblender.Pages.user;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Log4j2(topic = "reporting")
public class MyFitnessDropdown extends BasePage {

    private SelenideElement myFitnessDropdown = $("div.menu-id");
    private SelenideElement myFitnessDropdownText = $("div.menu-id > span");
    private SelenideElement joinButton = $("a[href'/join']");
    private SelenideElement signInButton = $("a[href='/login']");
    private SelenideElement dashboard = $("a[href='/my/dashboard']");
    private SelenideElement calendar = $("a[href='/my/calendar']");
    private SelenideElement purchasedPrograms = $("a[href='/my/programs']");
    private SelenideElement favorites = $("a[href='/my/favorites']");
    private SelenideElement notifications = $("a[href='/my/notifications']");
    private SelenideElement account = $("a[href='/my/account']");
    private SelenideElement signOut = $("a[href='/logout']");


}
