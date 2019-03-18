package com.fitnessblender.Pages.user;

import com.fitnessblender.Pages.BasePage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j(topic = "reporting")
public class UserDashboardPage extends BasePage {

    public final static String USER_DASHBOARD_PAGE_URL = BASE_URL + "/my/dashboard";
}
