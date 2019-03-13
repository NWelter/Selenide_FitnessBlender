package com.fitnessblender.Pages.commons.header;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
@Slf4j(topic = "reporting")
public class HealthyLivingDropdown extends BasePage {

    private SelenideElement healthyLiving = $("li.healthy-living > a[href='/healthy-living']");
    private ElementsCollection healthyLivingDropdown = $$("#healthy-living-dropdown a");

//    private SelenideElement fitness = $("a[href*='/fitness']");
//    private SelenideElement health = $("a[href*='/health']");
//    private SelenideElement healthyRecipes = $("a[href*='/healthy-recipes']");
//    private SelenideElement beforeAndAfter = $("a[href*='/before-after']");
//    private SelenideElement weightLoss = $("a[href*='/weight-loss']");

    public HealthyLivingDropdown navigateTo(String subPageOption){
        healthyLiving.hover();
        SelenideElement subPage = healthyLivingDropdown.findBy(text(subPageOption));
        log.debug(String.format("Navigate to \"%s\" page", subPageOption));
        subPage.click();
        return this;
    }

//    private String url = "";
//
//    public String navigateToFitnessPage(){
//        healthyLiving.hover();
//        fitness.click();
//        return url = getCurrentURL();
//    }
//
//    public String navigateToHealthPage(){
//        healthyLiving.hover();
//        health.click();
//        return url = getCurrentURL();
//    }
//
//    public String navigateToHealthyRecipePage(){
//        healthyLiving.hover();
//        healthyRecipes.click();
//        return url = getCurrentURL();
//    }
//
//    public String navigateToBeforeAndAfterPage(){
//        healthyLiving.hover();
//        beforeAndAfter.click();
//        return  url = getCurrentURL();
//    }
//
//    public String navigateToWeightLossPage(){
//        healthyLiving.hover();
//        weightLoss.click();
//        return url = getCurrentURL();
//    }

}
