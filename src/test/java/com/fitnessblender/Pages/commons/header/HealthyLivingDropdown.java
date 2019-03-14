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


    public HealthyLivingDropdown navigateTo(String subPageOption){
        healthyLiving.hover();
        log.debug(String.format("Navigate to \"%s\" page", subPageOption));
        healthyLivingDropdown
                .findBy(text(subPageOption))
                .click();
        return this;
    }


}
