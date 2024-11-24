package apiTests.searchBreweries;

import apiTests.BaseApiTest;
import objectModels.BreweryObject;
import openBreweryApiMethods.SearchBreweriesMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AutocompleteTest extends BaseApiTest {
    SearchBreweriesMethods searchBreweriesMethods = new SearchBreweriesMethods();
    List<BreweryObject> breweriesFromResponse;
    protected String autocompleteUrl = endpoints.getSEARCH_BREWERIES_AUTOCOMPLETE_URL();

    @Test(description = "Received data objects are not empty")
    public void receivedObjectsAreNotEmpty() {
        breweriesFromResponse = searchBreweriesMethods.get(autocompleteUrl, testData.getCityName());

        for (BreweryObject brewery : breweriesFromResponse) {
            Assert.assertTrue(brewery.getId().length()>3);
            Assert.assertTrue(brewery.getName().length()>3);
        }
    }

    @Test(description = "Get autocomplete request return 15 objects")
    public void autocompleteResponseBodyHasNotMoreThan15() {
        int maxAmountAutocompleteObjects = requirements.getAMOUNT_OF_AUTOCOMPLETE_OBJECTS_IN_RESPONSE();
        breweriesFromResponse = searchBreweriesMethods.get(autocompleteUrl, testData.getCityName());

        Assert.assertTrue(maxAmountAutocompleteObjects<= breweriesFromResponse.size());
    }

    @Test(description = "Get empty response when do not use query parameters")
    public void emptyResponseWhenSearchWithoutQuery() {
        breweriesFromResponse = searchBreweriesMethods.get(autocompleteUrl);

        Assert.assertEquals(0, breweriesFromResponse.size());
    }
}