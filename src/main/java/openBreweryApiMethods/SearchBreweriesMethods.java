package openBreweryApiMethods;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import objectModels.BreweryObject;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import java.util.List;

/**
 * Implementation of the methods which we will use while testing. Every method should have default status code assertion
 */

public class SearchBreweriesMethods implements CrudInterface {

    public List<BreweryObject> get(String endpoint, String query) {
        Response response = RestAssured.get(endpoint + query).then().extract().response();
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        return response.jsonPath().getList("", BreweryObject.class);
    }

    @Override
    public List<BreweryObject> get(String endpoint) {
        Response response = RestAssured.get(endpoint).then().extract().response();
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        return response.jsonPath().getList("", BreweryObject.class);
    }

    @Override
    public List<BreweryObject> create(BreweryObject object) {
        return null;
    }

    @Override
    public List<BreweryObject> update(BreweryObject object) {
        return null;
    }

    @Override
    public List<BreweryObject> delete(BreweryObject id) {
        return null;
    }

}
