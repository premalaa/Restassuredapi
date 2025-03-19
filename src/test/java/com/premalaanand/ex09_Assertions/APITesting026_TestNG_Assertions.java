package com.premalaanand.ex09_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

    // 55%
    //Hard Assertion

    @Test
    public  void test_HardAssert_Example() {
        System.out.println("Start of the program");
        Boolean is_neeru_female = false;

        Assert.assertEquals("pramod", "Pramod");

        System.out.println("End of the program");
    }
        // Software Assertion

        @Test
                public void test_SoftAssertion(){
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(false);

            System.out.println("End of the program");

            softAssert.assertAll();
        }


    }

