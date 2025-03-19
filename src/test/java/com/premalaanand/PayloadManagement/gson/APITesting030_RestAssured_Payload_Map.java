package com.premalaanand.PayloadManagement.gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class APITesting030_RestAssured_Payload_Map {

    // GSON - is Google Lib - which will convert your class to JSON
    // JSON to class -
    // JSON - is a plain text in key and value pair to transfer from client to server.

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;


    @Test
    public void test_Create_Booking_Positive() {

        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO

        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response

Booking booking = new Booking();
booking.setFirstname("json");
booking.setLastname("brown");
booking.setTotalprice(111);
booking.setDepositpaid(true);

BookingDates bookingdates =new BookingDates();
bookingdates.setCheckout("2024-02-01");
bookingdates.setCheckin("2024-02-01");
booking.setBookingdates(bookingdates);
booking.setAdditionalneeds("lunch");

        System.out.println(booking);

        // Java Object -> JSON

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);
        // {"firstname":"json","lastname":"brown","totalprice":111,"depositpaid":true,"bookingdates":{"checkin":"2024-02-01","checkout":"2024-02-01"},"additionalneeds":"lunch"}

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString  = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        // Case1 - extract() - Direct Extraction
        String firstname1 = response.then().extract().path("booking.firstname");
        System.out.println(firstname1);


        Assert.assertEquals(firstname1,"json");
        //Assert.assertEquals(firstname1,"brown");

        assertThat(firstname1).isNotNull().isNotEmpty().isNotBlank().isEqualTo("Pramod");


        // Case 2 - jsonPath.getString("")  JSON Path Extraction
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId  = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkin = jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkin);


        String jsonResponseString1  = response.asString();

        // Server - JSONString> Java Object( BookingResponse) - getter to verify

        // Case 3 - DeSerialization - Extraction
        //  Response - De Ser another Response Class
        Booking bookingResponse = gson.fromJson(jsonResponseString1,Booking.class);

        System.out.println(bookingResponse.getBookingdates());
        System.out.println(bookingResponse.getFirstname());
        System.out.println(bookingResponse.getLastname());

        assertThat(bookingResponse.getBookingdates()).isNotNull();
        assertThat(bookingResponse.getFirstname()).isEqualTo("json").isNotNull().isNotEmpty();







    }
}
