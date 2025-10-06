package org.example.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class SearchResultsPage {

    private final SelenideElement titleItems = $("[data-testid=find-results-section-title]");
    private final ElementsCollection movieTitles = titleItems.$$(".ipc-metadata-list-summary-item__c");

    public String getFirstResultTitle() {
            return movieTitles.first().getText();
    }
    public void clickFirstResult() {
        movieTitles.first().shouldBe(visible).click();
    }
}


