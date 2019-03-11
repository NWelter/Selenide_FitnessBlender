package com.fitnessblender.Pages.commons;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

@Log4j2(topic = "reporting")
@Getter
public class NavbarHeader extends BasePage {

    private SelenideElement workoutsAndPrograms = $("li.workouts > a[href='/workouts-programs']");

    //Workouts & Programs dropdown
    private SelenideElement workoutVideos = $("a[href='/videos']");
    private SelenideElement workoutPrograms = $("a[href='/plans']");
    private SelenideElement mealPlans = $("a[href='/meal-plans']");
    private SelenideElement healthyLiving = $("li.healthy-living > a[href='/healthy-living']");

    //Healthy Living dropdown
    private SelenideElement fitness = $("a[href*='/fitness']");
    private SelenideElement health = $("a[href*='/health']");
    private SelenideElement healthyRecipes = $("a[href*='/healthy-recipes']");
    private SelenideElement beforeAndAfter = $("a[href*='/before-after']");
    private SelenideElement weightLoss = $("a[href*='/weight-loss']");

    private SelenideElement community = $("li.community > a[href='/community']");
    private SelenideElement blog = $("li.blog > a[href='/blog'");
    private SelenideElement about = $("li.about > a[href='/page/about-fitness-blender'");
    private SelenideElement clothing = $("li.clothing > a[href='https://workoutcomplete.com/'");
    private SelenideElement cartIcon = $("a.menu-cart");

    //Search box
    private SelenideElement searchIcon = $("span[data-event='click']");
    private SelenideElement searchField = $("#searchInput");
    private SelenideElement searchButton = $("#searchForm button");


    public void search(String keyWords) {
        searchIcon
                .shouldBe(visible)
                .click();
        searchField
                .shouldBe(visible)
                .clear();
        searchField.sendKeys(keyWords);
        log.debug("Searching String: " + keyWords);
        searchButton
                .shouldBe(visible)
                .click();
    }


}
