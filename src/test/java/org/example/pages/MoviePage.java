package org.example.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class MoviePage {

    private final SelenideElement titleHeading = $("[data-testid=hero__primary-text]");
    private final ElementsCollection topCastItems = $$("[data-testid='title-cast-item']");

    public String getPageTitle() {
        return titleHeading.shouldBe(visible).getText().trim();
    }

    public int getTopCastCount() {
        return topCastItems.filter(visible).size();
    }

    public String geNthtCastName(int index) {
        return topCastItems.get(index - 1).shouldBe(visible).getText();
    }

    public void openNthCastProfile(int index) {
        SelenideElement card = topCastItems.get(index - 1).shouldBe(visible);
        card.$("a[href*='/name/']").shouldBe(visible).click();
    }
}


