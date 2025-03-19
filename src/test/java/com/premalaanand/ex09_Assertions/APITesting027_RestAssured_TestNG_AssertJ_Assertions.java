package com.premalaanand.ex09_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.*;


public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;


    @Test
    public void test_POST() {

        String payload_POST = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



        // Rest Assured.
        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Dutta"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
        validatableResponse.body("bookingid", Matchers.notNullValue());

        // TestNG Assertions
        bookingId = response.then().extract().path("bookingId");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Pramod");
        Assert.assertEquals(lastname,"Dutta");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstname,"Pramod");
        softAssert.assertAll();


        // AssertJ( 3rd- Lib to Assertions)
        assertThat(bookingId).isNotNegative().isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Pramod").isNotNull().isNotEmpty().isNotBlank();
        assertThat(lastname).isEqualTo("Dutta").isNotBlank().isNotNull().isNotBlank();





    }
}


