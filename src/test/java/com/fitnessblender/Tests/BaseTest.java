package com.fitnessblender.Tests;

import com.codeborne.selenide.Configuration;
import com.fitnessblender.Pages.commons.header.HealthyLivingDropdown;
import com.fitnessblender.Pages.commons.header.NavbarHeader;
import com.fitnessblender.Pages.commons.header.WorkoutsAndProgramsDropdown;
import com.fitnessblender.Pages.user.LoginPage;
import com.fitnessblender.Pages.user.MyFitnessDropdown;
import com.fitnessblender.Pages.user.UserDashboard;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

@Getter
@Slf4j(topic = "reporting")
public class BaseTest {

    protected HealthyLivingDropdown healthyLivingDropdown = new HealthyLivingDropdown();
    protected NavbarHeader navbarHeader = new NavbarHeader();
    protected WorkoutsAndProgramsDropdown workoutsAndProgramsDropdown = new WorkoutsAndProgramsDropdown();
    protected LoginPage loginPage = new LoginPage();
    protected MyFitnessDropdown myFitnessDropdown = new MyFitnessDropdown();
    protected UserDashboard userDashboard = new UserDashboard();

    @BeforeEach
    public void openSession(){
        setup();
        log.info(String.format("------- Open browser session and go to: '%s' -------", baseUrl));
        open(baseUrl);
    }

    @AfterEach
    public void closeSession(){
       log.info("------- Close browser session. -------");
        close();
    }

    private static void setup(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.fitnessblender.com/";
        Configuration.startMaximized = true;
    }

}
