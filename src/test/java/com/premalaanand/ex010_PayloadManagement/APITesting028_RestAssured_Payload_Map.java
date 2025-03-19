package com.premalaanand.ex010_PayloadManagement;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting028_RestAssured_Payload_Map {

RequestSpecification requestSpecification;
Response response;
ValidatableResponse validatableResponse;
String token;
Integer bookingId;


@Test
    public  void test_Post(){

//    String payload_POST = "{\n" +
//            "    \"firstname\" : \"Pramod\",\n" +
//            "    \"lastname\" : \"Dutta\",\n" +
//            "    \"totalprice\" : 111,\n" +
//            "    \"depositpaid\" : false,\n" +
//            "    \"bookingdates\" : {\n" +
//            "        \"checkin\" : \"2024-01-01\",\n" +
//            "        \"checkout\" : \"2024-01-01\"\n" +
//            "    },\n" +
//            "    \"additionalneeds\" : \"Lunch\"\n" +
//            "}";


    Map<String,Object> jsonBodyUsingMap =new LinkedHashMap() ;

    jsonBodyUsingMap.put("firstname","Pramod");
    jsonBodyUsingMap.put("lastname","Dutta");

    jsonBodyUsingMap.put("totalprice",111);

    jsonBodyUsingMap.put("depositpaid","false");

Map<String,Object> bookingdates = new LinkedHashMap();

bookingdates.put("checkin","2024-01-01");
    bookingdates.put("checkout","2024-01-01");

    jsonBodyUsingMap.put("bookingdates",bookingdates);
    jsonBodyUsingMap.put("additionalneeds", "Breakfast");
    System.out.println(jsonBodyUsingMap);








}

}
