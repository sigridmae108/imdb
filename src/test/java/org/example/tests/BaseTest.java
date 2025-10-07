package org.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.imdb.com");
        Configuration.timeout = 8000;
        Configuration.pageLoadTimeout = 5000;
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}


