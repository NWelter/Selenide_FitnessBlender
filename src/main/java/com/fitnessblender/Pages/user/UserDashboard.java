package com.fitnessblender.Pages.user;

import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j(topic = "reporting")
public class UserDashboard extends BasePage {
    private String url = BASE_URL + "/my/dashboard";
}
