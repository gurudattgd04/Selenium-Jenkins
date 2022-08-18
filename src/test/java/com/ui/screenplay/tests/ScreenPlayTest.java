package com.ui.screenplay.tests;

import com.ui.screenplay.hooks.BrowserStackSerenityTest;
import com.ui.screenplay.questions.Dashboard;
import com.ui.screenplay.tasks.LoginToBstack;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import io.percy.selenium.Percy;

@RunWith(SerenityRunner.class)
public class ScreenPlayTest extends BrowserStackSerenityTest {

    private Actor demoUser = Actor.named("Demo User");
    private static Percy percy;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void demoUserCanBrowseTheWeb(){
        demoUser.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void browseTheWebAsDemoUser(){
        demoUser.attemptsTo(Open.url("https://bstackdemo.com/signin"));
        givenThat(demoUser).attemptsTo(LoginToBstack.withCredentials("demouser", "testingisfun99"));
        then(demoUser).should(seeThat(Dashboard.displayed(), CoreMatchers.equalTo("demouser")));
    }

}
