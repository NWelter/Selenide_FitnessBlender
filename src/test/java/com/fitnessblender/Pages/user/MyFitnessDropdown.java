package com.fitnessblender.Pages.user;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
@Slf4j(topic = "reporting")
public class MyFitnessDropdown extends BasePage {

    private SelenideElement myFitnessDropdown = $("div.menu-id");
    private ElementsCollection loginUserDropdownOptions = $$("div.user-dropdown a");
    private SelenideElement myFitnessDropdownWelcomingHeadline = $("div.menu-id > span");

    private SelenideElement joinButton = $("a[href'/join']");
    private SelenideElement signInButton = $("a[href='/login']");
//    private SelenideElement dashboard = $("a[href='/my/dashboard']");
//    private SelenideElement calendar = $("a[href='/my/calendar']");
//    private SelenideElement purchasedPrograms = $("a[href='/my/programs']");
//    private SelenideElement favorites = $("a[href='/my/favorites']");
//    private SelenideElement notifications = $("a[href='/my/notifications']");
//    private SelenideElement account = $("a[href='/my/account']");
//    private SelenideElement signOut = $("a[href='/logout']");

    public MyFitnessDropdown navigateTo(String loginUserTabOption){
        myFitnessDropdown.hover();
        SelenideElement tabOption = loginUserDropdownOptions.findBy(text(loginUserTabOption));
        log.debug(String.format("Navigate to \"%s\" tab", loginUserTabOption));
        tabOption.click();
        return this;
    }

    public MyFitnessDropdown goToJoin(){
        myFitnessDropdown.hover();
        log.debug("Click on 'Join' button.");
        joinButton.click();
        return this;
    }

    public MyFitnessDropdown goToSignIn(){
        myFitnessDropdown.hover();
        log.debug("Click on 'Sign In' button.");
        signInButton.click();
        return this;
    }

    public String getWelcomingHeadline(){
        myFitnessDropdownWelcomingHeadline.shouldBe(visible);
        String headlineText =  myFitnessDropdownWelcomingHeadline.getText();
        log.debug("'My Fitness' dropdown has '%s' welcoming header", headlineText);
        return headlineText;
    }
}
