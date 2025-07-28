package com.attachee.tests;

import com.attachee.base.Base;
import com.attachee.pages.AccessMaintainersPages;
import org.testng.annotations.Test;

public class AccessMaintainersTest extends Base {


    @Test
    public void navigateSideButtons(){
        AccessMaintainersPages accessMaintainersPages = new  AccessMaintainersPages(page);
        accessMaintainersPages.goToLeavePage();
        accessMaintainersPages.goToRecruitmentPage();
        accessMaintainersPages.goToPerformancePage();

        System.out.println("We are done yaaaaaaaaaaay");

    }
}
