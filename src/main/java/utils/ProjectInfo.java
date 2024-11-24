package utils;

import lombok.Getter;

public class ProjectInfo {
    @Getter
    public class Endpoints {
        private final String BASE_URL = "https://api.openbrewerydb.org/v1/breweries/";
        private final String SEARCH_BREWERIES_URL = BASE_URL+"search?query=";
        private final String SEARCH_BREWERIES_AUTOCOMPLETE_URL = BASE_URL+"autocomplete?query=";
    }
    @Getter
    public class Requirements {
        private final int AMOUNT_OF_AUTOCOMPLETE_OBJECTS_IN_RESPONSE = 15;
    }
}
