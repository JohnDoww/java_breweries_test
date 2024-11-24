package apiTests.searchBreweries;

import apiTests.BaseApiTest;
import objectModels.BreweryObject;
import openBreweryApiMethods.SearchBreweriesMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseApiTest {
    SearchBreweriesMethods searchBreweriesMethods = new SearchBreweriesMethods();
    List<BreweryObject> breweriesFromResponse;
    protected String searchUrl = endpoints.getSEARCH_BREWERIES_URL();

    @Test(description = "Get only American Breweries by putting american city into query")
    public void searchForAmericanBreweriesByPuttingAmericanCityAsQuery() {
        breweriesFromResponse = searchBreweriesMethods.get(searchUrl, testData.getCityName());

        for (BreweryObject brewery : breweriesFromResponse) {
            Assert.assertTrue(brewery.getCountry().toLowerCase().contains(testData.getCountryName()));
        }
    }

    @Test(description = "Breweries per page filer works properly")
    public void filterDisplayedBreweriesPerPage() {
        int amountOfBreweries = 6; // there can be random int
        breweriesFromResponse = searchBreweriesMethods.
                get(searchUrl, testData.getCityName() + testData.getAmountOfBreweriesPerPage(amountOfBreweries));

        Assert.assertEquals(amountOfBreweries, breweriesFromResponse.size());
    }

    @Test(description = "Get empty response when do not use query parameters")
    public void emptyResponseWhenSearchWithoutQuery() {
        breweriesFromResponse = searchBreweriesMethods.get(searchUrl);

        Assert.assertEquals(0, breweriesFromResponse.size());
    }
}
