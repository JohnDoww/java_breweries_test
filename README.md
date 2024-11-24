1. Cover "Search Breweries" method of https://www.openbrewerydb.org/documentation
with autotests using Java + REST Assured
(pick up to 5 scenarios covering main method features and implement corresponding
autotest in code, the rest scenarios you think should be included in complete test suite can
be listed in readme file).

Possible cases: 
- Put the (huge string/1 character) as a query;
- Use different data types for search(float, boolean, array, int);
- Create object with special symbol and try to find it by the methods;
- Try to search non-existent entity. Investigate the response;
- Use different methods for those endpoints. Check status code - must be 405;
- Max/Min objects per page; 


2. Examine "List Breweries" method and share your thoughts (in readme file) on how you
   would apply test automation to it (what approach, test design techniques you'd choose
   etc).

Testing Approach:
   1. Collect all Requirements: 
- max min value for per_page query and for other queries;
- how should we sort website_url, latitude, longitude, fields with numbers and characters;
- which filters can be combined with each other which are not;
- expected response for status codes 400, 403, 404, 405;

  2. Test design: 
- Apply such techniques as: boundary value, pairwise - as a result we will have list of tests where we apply only one 
filter(with max or min characters as a query) and list of test where we will apply multiple filters in request(there also apply mix or min characters for query, 
if it wasn't covered recently for those filters);
- Design validation tests for checking such status codes(400, 403, 404, 405) with response body and status code assertions
run test with applied max amount of filters;
