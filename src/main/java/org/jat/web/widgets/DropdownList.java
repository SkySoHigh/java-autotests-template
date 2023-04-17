package org.jat.web.widgets;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class DropdownList {

    private final By locator;

    public DropdownList(By locator) {
        this.locator = locator;
    }

    public void choose(String variant) {
        $(locator).selectOption(variant);
    }

    public void checkText(String expected) {
        $(locator).shouldHave(Condition.text(expected));
    }
}
