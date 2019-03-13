package com.fitnessblender.Pages.commons.header;

import com.codeborne.selenide.SelenideElement;
import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

@Slf4j(topic = "reporting")
@Getter
public class NavbarHeader extends BasePage {

    private SelenideElement fitnessLogo = $("h1.brand > a");
    private SelenideElement community = $("li.community > a[href='/community']");
    private SelenideElement blog = $("li.blog > a[href='/blog'");
    private SelenideElement about = $("li.about > a[href='/page/about-fitness-blender'");
    private SelenideElement clothing = $("li.clothing > a[href='https://workoutcomplete.com/'");
    private SelenideElement shoppingCartIcon = $("a.menu-cart");
    private SelenideElement numberOfItemsInCart = $(".cart-number");

    //Search box
    private SelenideElement searchIcon = $("span[data-event='click']");
    private SelenideElement searchField = $("#searchInput");
    private SelenideElement searchButton = $("#searchForm button");


    public NavbarHeader searchingFor(String keyWords) {
        searchIcon.click();
        log.debug(String.format("Searching String: '%s'", keyWords));
        searchField.setValue(keyWords);
        searchButton.click();
        return this;
    }

    public Integer getShownNumberOfItemsInCart(){
        String items = numberOfItemsInCart
                            .shouldBe(visible)
                            .getText();
        Integer numberOfItems = Integer.valueOf(items);
        log.info(String.format("Number of items shown in shopping cart: %d", numberOfItems));
        return numberOfItems;
    }


}
