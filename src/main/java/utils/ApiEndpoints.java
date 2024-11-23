package utils;

import lombok.Getter;

/**
 * Place for storing endpoints to do not change it accidentally
 */
@Getter
public  class ApiEndpoints {
    private final String BASE_URL = "https://api.openbrewerydb.org/v1/breweries/";
    private final String SEARCH_BREWERIES_URL = BASE_URL+"search?query=";
    private final String SEARCH_BREWERIES_AUTOCOMPLETE_URL = BASE_URL+"autocomplete?query=";



}
