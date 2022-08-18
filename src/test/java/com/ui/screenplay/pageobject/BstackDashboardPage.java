package com.ui.screenplay.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class BstackDashboardPage extends PageObject {

    public static final Target SIGNOUT = Target.the("sign out")
            .locatedBy(".username");
}
