package org.example;

import java.util.Optional;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.fetch.Fetch;

public class SeleniumTest {
    @Test
    public void mockAPISelenium() {
        System.setProperty("webdriver.chrome.driver", "/Users/gurudattsa/IdeaProjects/Selenium4-test/driver/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        DevTools devtools = driver.getDevTools();
        devtools.createSession();
        devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devtools.addListener(Fetch.requestPaused(), req -> {


            if (req.getRequest().getUrl().contains("=Shetty")) {


             /*   String mock = req.getRequest().getUrl().replace("=shetty", "=Unknown");
                devtools.send(Fetch.continueRequest(req.getRequestId(), Optional.of(mock), Optional.empty(),
                        Optional.empty(), Optional.empty(), Optional.empty())); */
                System.out.print("netWork intercepted!");
            } else {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                devtools.send(Fetch.continueRequest(req.getRequestId(), Optional.of(req.getRequest().getUrl()),
                        Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
                System.out.print("netWork intercepted ");

            }
        });
        driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[contains(text(),'Virtual Library')] ")).click();
        driver.close();
        driver.quit();
    }
}