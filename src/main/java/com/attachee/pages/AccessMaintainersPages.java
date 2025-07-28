package com.attachee.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AccessMaintainersPages {

    private final Locator adminSideButton;
    private final Locator leaveSideButton;
    private final Locator recruitmentSideButton;
    private final Locator performanceSideButton;

    public AccessMaintainersPages(Page page) {
        this.adminSideButton   = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin"));
        this.leaveSideButton =    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave"));
        this.recruitmentSideButton =  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Recruitment"));
        this.performanceSideButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Performance"));
    }



    public void goToLeavePage() {
        leaveSideButton.click();
    }

    public void goToRecruitmentPage() {
        recruitmentSideButton.click();
    }

    public void goToPerformancePage() {
        performanceSideButton.click();
    }
}


