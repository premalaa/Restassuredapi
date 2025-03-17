package com.premalaanand.ex08_testNGExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting015_BeforeTest {

    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings



    @BeforeTest()

    public  void Get_token(){
        System.out.println("1");

    }
@BeforeTest
    public void Get_Booking_id(){
    System.out.println("2");
    }

@Test

    public void Test_Put(){
    System.out.println("3");

}

@AfterTest

    public void CloseAllThings(){
    System.out.println("4");

}
}
