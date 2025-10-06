package org.example.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;

public class PersonPage {

    private final SelenideElement nameHeading = $("h1[data-testid='hero__pageTitle']");

    public String getPersonName() {
        return nameHeading.shouldBe(visible).getText();
    }
}


