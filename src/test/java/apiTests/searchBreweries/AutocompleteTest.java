package apiTests.searchBreweries;

import apiTests.BaseApiTest;
import dataGenerator.TestData;
import io.restassured.response.Response;
import objectModels.BreweryObject;
import openBreweryApiMethods.SearchBreweriesMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiEndpoints;
import utils.SoftwareRequirements;

import java.util.List;

public class AutocompleteTest extends BaseApiTest {
    SoftwareRequirements softwareRequirements = new SoftwareRequirements();
    SearchBreweriesMethods searchBreweriesMethods = new SearchBreweriesMethods();
    ApiEndpoints apiEndpoints = new ApiEndpoints();
    Response response;
    TestData testData = new TestData();
    protected String autocompleteUrl = apiEndpoints.getSEARCH_BREWERIES_AUTOCOMPLETE_URL();

    @Test(description = "Received data objects are not empty")
    public void receivedObjectsAreNotEmpty() {
        response = searchBreweriesMethods.get(autocompleteUrl, testData.getCityName());
        List<BreweryObject> breweries = response.jsonPath().getList("", BreweryObject.class);

        for (BreweryObject brewery : breweries) {
            Assert.assertTrue(brewery.getId().length()>3);
            Assert.assertTrue(brewery.getName().length()>3);
        }
    }

    @Test(description = "Get autocomplete request return 15 objects")
    public void autocompleteResponseBodyHasNotMoreThan15() {
        int maxAmountAutocompleteObjects = softwareRequirements.getAMOUNT_OF_AUTOCOMPLETE_OBJECTS_IN_RESPONSE();
        response = searchBreweriesMethods.get(autocompleteUrl, testData.getCityName());
        List<BreweryObject> breweries = response.jsonPath().getList("", BreweryObject.class);
        Assert.assertTrue(maxAmountAutocompleteObjects>= breweries.size());
    }

    @Test(description = "Get empty response when do not use query parameters")
    public void emptyResponseWhenSearchWithoutQuery() {
        response = searchBreweriesMethods.get(autocompleteUrl);
        List<BreweryObject> breweries = response.jsonPath().getList("", BreweryObject.class);
        Assert.assertEquals(0, breweries.size());
    }
}