package org.jat.web.widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

import static com.codeborne.selenide.Selenide.$;

@Log
public class InputLine {
    private final By locator;

    public InputLine(By locator) {
        this.locator = locator;
    }

    public void clear() {
        $(locator).clear();
        $(locator).sendKeys("a");
        $(locator).sendKeys(Keys.BACK_SPACE);
    }

    public void fill(String text) {
        $(locator).sendKeys(text);
    }

    public void insert(String text) {
        // 'ctrl+c' for local browser
        try {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);
        } catch (HeadlessException e) {
            log.info("Seems not local machine, no X11");
        }
        // 'ctrl+v'
        $(locator).sendKeys(Keys.CONTROL + "v");
    }

    public void clearWithFill(String text) {
        $(locator).clear();
        $(locator).sendKeys(text);
    }

    public void fillWithEnter(String text) {
        $(locator).sendKeys(text);
        $(locator).pressEnter();
    }

    public String getText() {
        return $(locator).getAttribute("value");
    }

    public void checkText(String expected) {
        String current = $(locator).getAttribute("value");
        if (!expected.equals(current)) throw new AssertionError("Line content is incorrect! " +
                "Expected '" + expected + "', get '" + current + "'!");
    }

    public void actionsFill(String text) {
        // useful for js-filling fields
        Action action = new Actions(WebDriverRunner.getWebDriver())
                .moveToElement($(locator).shouldBe(Condition.exist).toWebElement())
                .click()
                .sendKeys(text)
                .build();
        action.perform();
    }

    public void actionsClear() {
        // useful for js-filling fields
        Action action = new Actions(WebDriverRunner.getWebDriver())
                .moveToElement($(locator).shouldBe(Condition.exist).toWebElement())
                .click()
                .sendKeys("a")
                .sendKeys(Keys.BACK_SPACE)
                .build();
        action.perform();
    }

}
