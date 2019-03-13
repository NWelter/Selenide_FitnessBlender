package com.fitnessblender.Pages.commons.header;


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
public class WorkoutsAndProgramsDropdown extends BasePage {

    private SelenideElement workoutsAndPrograms = $("li.workouts > a[href='/workouts-programs']");
    private ElementsCollection workoutsAndProgramsDropdown = $$("#workout-dropdown a");

    private SelenideElement workoutVideos = $("a[href='/videos']");
    private SelenideElement workoutPrograms = $("a[href='/plans']");
    private SelenideElement mealPlans = $("a[href='/meal-plans']");


    public WorkoutsAndProgramsDropdown navigateTo(String subPageOption){
        workoutsAndPrograms.hover();
        log.debug(String.format("Navigate to \"%s\" page", subPageOption));
        workoutsAndProgramsDropdown
                .findBy(text(subPageOption))
                .click();
        return this;
    }
//    private String url = "";
//
//    public String navigateToWorkoutVideosPage(){
//        workoutsAndPrograms.hover();
//        workoutVideos.click();
//        return url = getCurrentURL();
//    }
//
//    public String navigateToWorkoutProgramsPage(){
//        workoutsAndPrograms.hover();
//        workoutPrograms.click();
//        return url = getCurrentURL();
//    }
//
//    public String navigateToMealPlansPage(){
//        workoutsAndPrograms.hover();
//        mealPlans.click();
//        return url = getCurrentURL();
//    }


}
