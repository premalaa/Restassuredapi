package com.premalaanand.ex04_POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    @Description("Verify the POST req positive: create Token")

    public void POST_REQ_Positive_TC() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println(" ----    Part 1 ---- ");

        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");

        r.contentType(ContentType.JSON);
        r.body(payload).log().all();



        System.out.println("----- Part2-------");
        // Making HTTP Request -> Part 2
        response = r.when().log().all().post();




        System.out.println("------Part3------");
        // Verification Part -> Part 3
        vr = response.then().log().all().statusCode(200);

    }
}