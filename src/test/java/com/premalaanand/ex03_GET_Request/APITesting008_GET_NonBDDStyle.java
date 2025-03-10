package com.premalaanand.ex03_GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the GET req positive")
    @Test

    public  void test_NonBDD_GET() {
        String pincode = "560048";

        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);


        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);

    }

    @Description("Test negativetest case for invalid pincode input = -1")
    @Test

    public  void test_NonBDD_GET_Negative(){

        String pincode = " -1";

        r= RestAssured .given();
                r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+"-1");


        response = r.when().log().all().get();

        vr= response.then().log().all().statusCode(200);


    }


    }


