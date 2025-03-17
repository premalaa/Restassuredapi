package com.premalaanand.ex08_testNGExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TestNG_Parameter {

@Parameters("browser")
@Test
    public void demo1(String value){
        System.out.println("DEMO 1 Tc#1");
        if(value.equalsIgnoreCase("chrome")){
            System.out.println("start the chrome browser");
        }
    if(value.equalsIgnoreCase("firefox")){
        System.out.println("start the firefox browser");
    }

    }
}
