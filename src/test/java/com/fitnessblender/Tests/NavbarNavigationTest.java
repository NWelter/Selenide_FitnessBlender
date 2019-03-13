package com.fitnessblender.Tests;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.fitnessblender.Pages.BasePage.getCurrentURL;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j(topic = "reporting")
public class NavbarNavigationTest extends BaseTest {

    @Test
    public void navigateToMealPlan(){
        workoutsAndProgramsDropdown.navigateTo("Meal Plans");
        assertThat(
                getCurrentURL())
                .as("Check current URL")
                .isEqualTo("https://www.fitnessblender.com/meal-plans");
    }
}
