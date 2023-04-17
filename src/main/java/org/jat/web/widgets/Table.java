package org.jat.web.widgets;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class Table {
    private final By table = By.tagName("table");
    private final By headers = By.tagName("th");
    private final By rows = By.tagName("tr");

    public int getNumberOfColumn(String columnName) {
        $(table).$$(rows).shouldBe(CollectionCondition.sizeGreaterThan(0));
        return $(table).$$(headers).indexOf($(table).$(By.xpath(".//th[normalize-space(.)='" + columnName + "']"))) + 1;
    }

    public void checkEntityIsPresent(String columnName, String entityName) {
        getCellByColumn(columnName, entityName).should(Condition.exist);
    }

    public void checkEntityIsNotPresent(String columnName, String entityName) {
        if (!$(table).exists()) return;
        if (!$(table).isDisplayed()) return;
        try {
            getCellByColumn(columnName, entityName).should(Condition.not(Condition.exist));
        } catch (org.openqa.selenium.NoSuchElementException ignored) {
        }
    }

    private SelenideElement getCellByColumn(String columnName, String entityName) {
        return $(table).$x((".//td[position()=" + getNumberOfColumn(columnName) + " and normalize-space(.)='" + entityName + "']"));
    }

    public String getInfoFromField(String columnName, String entityName, String requiredColumn) {
        return getCellByColumn(columnName, entityName)
                .$x("./../td[position()=" + getNumberOfColumn(requiredColumn) + "]").getText();
    }

    public void checkInfoFromField(String columnName, String entityName, String requiredColumn, String expected) {
        SelenideElement row = getCellByColumn(columnName, entityName).parent();
        SelenideElement required = row.$x("./td[position()=" + getNumberOfColumn(requiredColumn) + "]");
        if (expected.equals(""))
            required.shouldHave(Condition.exactText(""));
        else
            required.shouldHave(Condition.text(expected));
    }


}
