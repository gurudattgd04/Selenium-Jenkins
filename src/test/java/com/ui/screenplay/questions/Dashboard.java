package com.ui.screenplay.questions;

import com.ui.screenplay.pageobject.BstackDashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class Dashboard implements Question<String> {

    public static Question<String> displayed() {
        return new Dashboard();
    }

    public String answeredBy(Actor actor) {
        return Text.of(BstackDashboardPage.SIGNOUT).answeredBy(actor);
    }
}
