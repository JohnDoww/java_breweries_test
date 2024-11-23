package dataGenerator;

/**
 * This is data generator class. Here We store the auto/manually generated data which will be used in testing.
 */
public class TestData {
    final String  COUNTRY_1 = "united states";
    final String  CITY_1 = "los&angeles";

   public String getCityName(){
       return CITY_1;
   }
   public String getCountryName(){
       return COUNTRY_1;
   }

    public String getAmountOfBreweriesPerPage(int pageNumber){
        return "&per_page="+ pageNumber;
    }



}