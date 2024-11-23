package objectModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The object description which we get from the response
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreweryObject {
    private String id;
    private String name;
    private String brewery_type;
    private String address_1;
    private String address_2;
    private String address_3;
    private String city;
    private String state_province;
    private String postal_code;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;
    private String website_url;
    private String state;
    private String street;
}
