package org.jat.web.widgets;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Checkbox {
    private final By locator;

    public Checkbox(By by) {
        locator = by;
    }

    public boolean isSelected() {
        return $(locator).isSelected();
    }

    public void set(boolean flag) {
        if (flag) {
            if (!isSelected()) $(locator).click();
        } else {
            if (isSelected()) $(locator).click();
        }
    }

    public void setTrue() {
        if (!isSelected()) {
            $(locator).click();
        }
    }

    public void checkTrue() {
        $(locator).shouldBe(Condition.selected);
    }

    public void setFalse() {
        if (isSelected()) $(locator).click();
    }

    public void checkFalse() {
        $(locator).shouldBe(Condition.not(Condition.selected));
    }

    public void clickBox() {
        $(locator).click();
    }

    public void checkIsNotClickable() {
        $(locator).shouldBe(Condition.disabled);
    }
}
