package org.example.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class HomePage {

    private final SelenideElement searchInput = $("#suggestion-search, input[name='q']");
    private final ElementsCollection suggestionItems = $$("#react-autowhatever-navSuggestionSearch");
    private final SelenideElement acceptButton = $("[data-testid='accept-button");

    public HomePage openHome(String baseUrl) {
        open(baseUrl);
        closeCookieNotification();
        return this;
    }

    public HomePage typeQuery(String query) {
        searchInput.shouldBe(visible).shouldBe(enabled).setValue(query);
        return this;
    }

    public void submitSearch() {
        searchInput.shouldBe(visible).pressEnter();
    }

    public String firstSuggestionText() {
        return suggestionItems.first().getText().trim();
    }

    public void clickFirstSuggestion() {
        suggestionItems.first().shouldBe(visible).click();
    }

    //TODO: inject browser cookie so no cookie notification appears
    private void closeCookieNotification() {
        acceptButton.shouldBe(visible).click();
    }
}


