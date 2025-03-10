package com.premalaanand.ex02_RA_TestNG_AllureReport;

//import groovy.transform.ASTTest;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class APITesting005_TC_TestNG_Fix {
    @Test
    @Description("TC#1 Verify that the valid pincode gives 200OK")

    public void test_GET_positive_TC1(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/110048")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);



    }


    @Test
    @Description("TC#2 Verify that the invalid pincode gives 200OK")

    public void test_GET_Negative_TC2(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+"-1")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);



    }


    @Test
    @Description("TC#3 Verify that the invalid pincode gives 200OK")

    public void test_GET_negative_TC3(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+"$")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);



    }



}
