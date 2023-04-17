package org.jat.web.widgets;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class Button {

    private final By locator;

    public Button(By buttonLocator) {
        locator = buttonLocator;
    }

    public void click() {
        $(locator).shouldBe(Condition.enabled).click();
    }

    public void hover() {
        $(locator).hover();
    }

    public String getText() {
        return $(locator).text();
    }

    public void checkText(String expected) {
        $(locator).shouldHave(Condition.text(expected));
    }

    public void waitDisappear(int seconds) {
        $(locator).should(Condition.disappear, Duration.ofSeconds(seconds));
    }

    public void shouldExist() {
        $(locator).should(Condition.exist);
    }

    public void shouldNotExist() {
        $(locator).should(Condition.not(Condition.exist));
    }
}
