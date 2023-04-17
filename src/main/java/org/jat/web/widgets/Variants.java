package org.jat.web.widgets;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$;


public class Variants {

    private final By variant = By.cssSelector(".uk-card");

    public void checkVariantIsPresent(String title) {
        $$(variant).filterBy(Condition.text(title)).shouldBe(CollectionCondition.size(1));
    }

    public void checkAllVariantsArePresent(ArrayList<String> list) {
        for (String title : list)
            $$(variant).filterBy(Condition.text(title)).shouldBe(CollectionCondition.size(1));
    }

    public void checkVariantIsNotPresent(String title) {
        $$(variant).filterBy(Condition.text(title)).shouldBe(CollectionCondition.empty);
    }

    public void checkVariantsEmpty() {
        $$(variant).shouldBe(CollectionCondition.empty);
    }

    public void checkVariantsCount(int count) {
        $$(variant).shouldBe(CollectionCondition.size(count));
    }

    public void hoverVariant(String title) {
        $$(variant).filterBy(Condition.text(title)).first().hover();
    }

}
