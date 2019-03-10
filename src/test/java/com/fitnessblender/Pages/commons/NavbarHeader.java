package com.fitnessblender.Pages.commons;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class NavbarHeader extends BasePage {

    private SelenideElement workoutsAndPrograms = $("li.workouts > a[href='/workouts-programs']");
    private SelenideElement healthyLiving = $("li.healthy-living > a[href='/healthy-living']");
    private SelenideElement community = $("li.community > a[href='/community']");
    private SelenideElement blog = $("li.blog > a[href='/blog'");
    private SelenideElement about = $("li.about > a[href='/page/about-fitness-blender'");
    private SelenideElement clothing = $("li.clothing > a[href='https://workoutcomplete.com/'");


}
