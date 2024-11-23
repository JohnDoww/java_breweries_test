package apiTests.searchBreweries;

import apiTests.BaseApiTest;
import dataGenerator.TestData;
import io.restassured.response.Response;
import objectModels.BreweryObject;
import openBreweryApiMethods.SearchBreweriesMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiEndpoints;

import java.util.List;

public class SearchTest extends BaseApiTest {
    SearchBreweriesMethods searchBreweriesMethods = new SearchBreweriesMethods();
    ApiEndpoints apiEndpoints = new ApiEndpoints();
    Response response;
    TestData testData = new TestData();
    protected String searchUrl = apiEndpoints.getSEARCH_BREWERIES_URL();

    @Test(description = "Get only American Breweries by putting american city into query")
    public void searchForAmericanBreweriesByPuttingAmericanCityAsQuery() {
        response = searchBreweriesMethods.get(searchUrl, testData.getCityName());
        List<BreweryObject> breweries = response.jsonPath().getList("", BreweryObject.class);

        for (BreweryObject brewery : breweries) {
            Assert.assertTrue(brewery.getCountry().toLowerCase().contains(testData.getCountryName()));
        }
    }

    @Test(description = "Breweries per page filer works properly")
    public void filterDisplayedBreweriesPerPage() {
        int amountOfBreweries = 6; // there can be random int
        response = searchBreweriesMethods.
                get(searchUrl, testData.getCityName() + testData.getAmountOfBreweriesPerPage(amountOfBreweries));
        List<BreweryObject> breweries = response.jsonPath().getList("", BreweryObject.class);
        Assert.assertEquals(amountOfBreweries, breweries.size());
    }

    @Test(description = "Get empty response when do not use query parameters")
    public void emptyResponseWhenSearchWithoutQuery() {
        response = searchBreweriesMethods.get(searchUrl);
        List<BreweryObject> breweries = response.jsonPath().getList("", BreweryObject.class);
        Assert.assertEquals(0, breweries.size());
    }
}
