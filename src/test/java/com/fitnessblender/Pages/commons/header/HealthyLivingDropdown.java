package com.fitnessblender.Pages.commons.header;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Log4j2(topic = "reporting")
public class HealthyLivingDropdown extends BasePage {

    private SelenideElement healthyLiving = $("li.healthy-living > a[href='/healthy-living']");
    private SelenideElement fitness = $("a[href*='/fitness']");
    private SelenideElement health = $("a[href*='/health']");
    private SelenideElement healthyRecipes = $("a[href*='/healthy-recipes']");
    private SelenideElement beforeAndAfter = $("a[href*='/before-after']");
    private SelenideElement weightLoss = $("a[href*='/weight-loss']");

    private String url = "";

    public String navigateToFitnessPage(){
        healthyLiving.hover();
        fitness.click();
        return url = getCurrentURL();
    }

    public String navigateToHealthPage(){
        healthyLiving.hover();
        health.click();
        return url = getCurrentURL();
    }

    public String navigateToHealthyRecipePage(){
        healthyLiving.hover();
        healthyRecipes.click();
        return url = getCurrentURL();
    }

    public String navigateToBeforeAndAfterPage(){
        healthyLiving.hover();
        beforeAndAfter.click();
        return  url = getCurrentURL();
    }

    public String navigateToWeightLossPage(){
        healthyLiving.hover();
        weightLoss.click();
        return url = getCurrentURL();
    }

}
