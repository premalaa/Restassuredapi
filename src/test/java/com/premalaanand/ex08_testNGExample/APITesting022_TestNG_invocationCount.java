package com.premalaanand.ex08_testNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting022_TestNG_invocationCount {

    @Test(invocationCount = 100)
    public void test01(){
        Assert.assertTrue(true);
    }

}