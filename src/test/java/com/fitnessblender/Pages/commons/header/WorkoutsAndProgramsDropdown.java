package com.fitnessblender.Pages.commons.header;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Log4j2(topic = "reporting")
public class WorkoutsAndProgramsDropdown extends BasePage {

    private SelenideElement workoutsAndPrograms = $("li.workouts > a[href='/workouts-programs']");
    private SelenideElement workoutVideos = $("a[href='/videos']");
    private SelenideElement workoutPrograms = $("a[href='/plans']");
    private SelenideElement mealPlans = $("a[href='/meal-plans']");

    private String url = "";



}
