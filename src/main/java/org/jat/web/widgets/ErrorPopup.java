package org.jat.web.widgets;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ErrorPopup {

    private final By closer = By.cssSelector(".uk-alert-close");
    private final By text = By.cssSelector(".uk-alert p");

    public void close() {
        $(closer).click();
    }

    public String getText() {
        return $(text).getText();
    }

    public String getTextIfExist() {
        try {
            return $(text).getText();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return "no err";
        }
    }

    public void checkText(String expected) {
        $(text).shouldHave(Condition.text(expected));
    }
}
