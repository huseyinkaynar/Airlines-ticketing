package flightbooking.com.example.flightbooking.SearchQuery;

public interface SearchQueries {
    interface Queries {

        final String airportSearch = "select * from airports where lower(airport_name) like lower(concat('%',:airport_name,'%'))";

        final String companySearch = "select * from companies where lower(company_name) like lower(concat('%',:company_name,'%'))";

    }
}
