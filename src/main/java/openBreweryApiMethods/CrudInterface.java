package openBreweryApiMethods;

import io.restassured.response.Response;

/**
 * Interface which we have to implement for each Class with API methods
 */
public interface CrudInterface {

    public Response create();
    public Response get(String id);
    public Response update ();
    public Response delete();
}
