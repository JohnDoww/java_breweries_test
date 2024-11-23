1. Cover "Search Breweries" method of https://www.openbrewerydb.org/documentation
with autotests using Java + REST Assured
(pick up to 5 scenarios covering main method features and implement corresponding
autotest in code, the rest scenarios you think should be included in complete test suite can
be listed in readme file).

Possible cases: 
- Put the (huge string/1 character) as a query
- Use different data types for search(float, boolean, array, int)
- Create object with special symbol and try to find it by the methods
- Try to search non-existent entity. Investigate the response 
- Use different methods for those endpoints. Check status code - must be 405
- Max/Min objects per page 


2. Examine "List Breweries" method and share your thoughts (in readme file) on how you
   would apply test automation to it (what approach, test design techniques you'd choose
   etc).
Testing Approach:
   Collect all Requirements: max min value for per_page query and for other queries, 
- how should we sort website_url, latitude, longitude, fields with numbers and characters
- which filters can be combined with each other which are not
- 

test cases: 
run test with applied max amount of filters

For every filter - run test with applied only one filter with the shortest/largest input - assert body of response 
Run test with combination of filters 