package com.premalaanand.ex03_GET_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDDStyle {

    @Test
    public void test_GET_REQ_positive(){
        String pin_code="560048";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when().log().all().get()
                .then().log().all().statusCode(200);

    }


    @Test
    public void test_GET_REQ_negative(){
        String pin_code="+1";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when().log().all().get()
                .then().log().all().statusCode(200);

    }
}
