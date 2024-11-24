package openBreweryApiMethods;

import objectModels.BreweryObject;
import java.util.List;

/**
 * Interface which we have to implement for each Class with API methods
 */
public interface CrudInterface {

    public List<BreweryObject> create(BreweryObject object);
    public List<BreweryObject> get(String endpoint);
    public List<BreweryObject> update (BreweryObject object);
    public List<BreweryObject> delete(BreweryObject id);
}
