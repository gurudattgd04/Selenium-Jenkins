package com.ui.screenplay.tasks;

import com.ui.screenplay.pageobject.BStackLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class LoginToBstack implements Task {

    @Step("{0} enter username and password '#username' '#password")
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo(Enter.theValue(username).into(BStackLoginPage.USERNAME).thenHit(Keys.TAB));
        actor.attemptsTo(Enter.theValue(password).into(BStackLoginPage.PASSWORD).thenHit(Keys.TAB));
        actor.attemptsTo(Click.on(BStackLoginPage.LOGIN_BTN));
    }

    private String username;
    private String password;

    public LoginToBstack(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Task withCredentials(String username, String password) {
        return Instrumented
                .instanceOf(LoginToBstack.class)
                .withProperties(username, password);
    }
}
