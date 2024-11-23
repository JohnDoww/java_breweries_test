package openBreweryApiMethods;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.Assert;

/**
 * Implementation of the methods which we will use while testing. Every method should have default status code assertion
 */

public class SearchBreweriesMethods implements CrudInterface {

    public Response get(String endpoint, String query) {
        Response response = RestAssured.get(endpoint + query).then().extract().response();
        Assert.assertEquals(200, response.statusCode());

        return response;
    }

    public Response get(String endpoint) {
        Response response = RestAssured.get(endpoint).then().extract().response();
        Assert.assertEquals(200, response.statusCode());

        return response;
    }

    @Override
    public Response create() {
        return null;
    }

    @Override
    public Response update() {
        return null;
    }

    @Override
    public Response delete() {
        return null;
    }

}
