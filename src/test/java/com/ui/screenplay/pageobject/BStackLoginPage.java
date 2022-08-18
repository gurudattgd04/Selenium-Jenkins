package com.ui.screenplay.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class BStackLoginPage extends PageObject {

    public static final Target USERNAME = Target.the("Username")
            .locatedBy("#username input");

    public static final Target PASSWORD = Target.the("Password")
            .locatedBy("#password input");

    public static final Target LOGIN_BTN = Target.the("Login Button")
            .locatedBy("#login-btn");
}
