package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.MoviePage;
import org.example.pages.PersonPage;
import org.example.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImdbE2ETest extends BaseTest {

    @Test(description = "IMDb flow: search, pick first result, verify title, cast, and person")
    public void imdbSearchAndVerifyFlow() {
        String base = System.getProperty("baseUrl", "http://www.imdb.com");

        HomePage home = new HomePage().openHome(base).typeQuery("QA");
        home.submitSearch();

        SearchResultsPage results = new SearchResultsPage();
        String a = results.getFirstResultTitle().trim().toLowerCase();
        results.clickFirstResult();

        MoviePage movie = new MoviePage();
        String b = movie.getPageTitle().trim().toLowerCase();

        Assert.assertTrue(a.contains(b),
               "Opened title should match first search result. opened='" + b + "' search result='" + a + "'");

        int castCount = movie.getTopCastCount();
        Assert.assertTrue(castCount > 3, "Top cast count should be greater than 3, was: " + castCount);

        String castName = movie.geNthtCastName(3).trim().toLowerCase();
        movie.openNthCastProfile(3);

        PersonPage personPage = new PersonPage();
        String personName = personPage.getPersonName().trim().toLowerCase();
        Assert.assertTrue(castName.equals(personName), "Wrong profile '" + personName + "' opened. Expected '" + castName + "' ");

    }
}


