1. Cover "Search Breweries" method of https://www.openbrewerydb.org/documentation
with autotests using Java + REST Assured
(pick up to 5 scenarios covering main method features and implement corresponding
autotest in code, the rest scenarios you think should be included in complete test suite can
be listed in readme file).

Possible cases: 
- Put the (huge string/1 character) as a query;
- Use different data types for search(float, boolean, array, int);
- Create an object with special symbol and try to find it by the methods;
- Try to search for non-existent entities. Investigate the response;
- Use different methods for those endpoints. Check status code - must be 405;
- Max/Min objects per page;
- Interacting with DB: 1 Delete entity - try to find it; 2 Update entity - verify it; 3 Create new entity - verify it;  


2. Examine "List Breweries" method and share your thoughts (in readme file) on how you
   would apply test automation to it (what approach, test design techniques you'd choose
   etc).

Testing Approach:
   1. Collect all Requirements: 
- Max min value for per_page query and for other queries;
- How should we sort website_url, latitude, longitude, fields with numbers and characters;
- Which filters can be combined with each other, which are not;
- Expected response for status codes 400, 403, 404, 405;
- Filter mechanism;

2. Test design: 
- Apply such techniques as: boundary value, pairwise - as a result we will have list of tests where we apply only one 
filter(with max or min characters as a query) and list of tests where we will apply multiple filters in request(there also apply mix or min characters for query, if it wasn't covered recently for those filters);
- Design validation tests for checking such status codes(400, 403, 404, 405) with response body and status code assertions. Also, design test (if needed) for applying different data types as query parameter;

3. Other notes: 
- Create an Object Class for mapping the object from response;

