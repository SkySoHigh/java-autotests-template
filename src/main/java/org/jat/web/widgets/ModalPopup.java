package org.jat.web.widgets;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class ModalPopup {

    private final By closer = By.cssSelector(".uk-modal-close");
    private final By text = By.cssSelector(".uk-modal-body");

    public void close() {
        $(closer).click();
    }

    public void checkText(String expected) {
        $(text).shouldHave(Condition.text(expected));
    }
}
