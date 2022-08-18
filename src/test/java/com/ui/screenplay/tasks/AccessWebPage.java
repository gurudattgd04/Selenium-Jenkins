package com.ui.screenplay.tasks;

import com.ui.screenplay.pageobject.BStackLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AccessWebPage implements Task {
    public static AccessWebPage loginPage() {
        return instrumented(AccessWebPage.class);
    }

    BStackLoginPage loginPage;

    @Step("{0} access Login page")
    public <T extends Actor> void performAs(T t) {
         t.attemptsTo(Open.browserOn().the(loginPage));
    }
}
