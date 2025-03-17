package com.premalaanand.ex08_testNGExample;

//import jdk.jfr.internal.test.DeprecatedMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TestNG_DependsOnMethod {



@Test
    public  void ServerStartedOK(){
        System.out.println("I will  run first");
        Assert.assertTrue(true);
    }
@Test(dependsOnMethods="ServerStartedOK")
    public  void method1(){
        System.out.println("Method1");
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods="ServerStartedOK")
    public  void method2(){
        System.out.println("Method2");
        Assert.assertTrue(true);
    }

}
