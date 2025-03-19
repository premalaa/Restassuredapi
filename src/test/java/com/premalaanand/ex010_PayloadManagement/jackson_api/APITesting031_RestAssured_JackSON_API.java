package com.premalaanand.ex010_PayloadManagement.jackson_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class APITesting031_RestAssured_JackSON_API {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    String token;
    Integer BookingId;

    @Test
    public void test_Post(){

        Booking booking =  new Booking();
        booking.setFirstname("json");
        booking.setLastname("brown");
        booking.setTotalprice(125);
        booking.setDepositpaid(true);
       // booking.setBookingdates(Bookingdates);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckout("2024-02-01");
        bookingdates.setCheckin("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("lunch");



        // Java Object -> JSON
//        Gson gson = new Gson();
//        String jsonStringBooking = gson.toJson(booking);
//        System.out.println(jsonStringBooking);



        String jsonStringBooking;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonStringBooking = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonStringBooking);


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

        // Case 2 - jsonPath.getString("")  JSON Path Extraction

        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        System.out.println(bookingId);
        System.out.println(firstname);


        //        BookingResponse bookingResponse = gson.fromJson(jsonResponseString, BookingResponse.class);

        BookingResponse bookingResponse = null;
        try {
            bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("json").isNotNull().isNotEmpty();







    }




}
