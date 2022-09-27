package TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGannotations {
    @BeforeSuite
    public void Method1(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void Method4(){
        System.out.println("Before Test");
    }
    @BeforeClass
    public void Method2(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void Method3(){
        System.out.println("Before Method");
    }
    @Test    //priority test (priority = 1)
    public void Method5(){
        System.out.println("Test Case1");
       //assert failing  Assert.assertTrue(false);
    }
    @Test    //failing test (enabled = false)
    public void Method7(){
        System.out.println("Test case2");
    }
    @Test   //groups (groups = {"smoke"})
    //sort by name of method
    public void Amethod(){
        System.out.println("Test case3");
    }
    @AfterMethod
    public void Method8(){
        System.out.println("After Method");
    }
    @AfterClass
    public void Method9(){
        System.out.println("After Class");
    }
    @AfterTest
    public void Method6() {
        System.out.println("After Test");
    }
    @AfterSuite
    public void Method10(){
        System.out.println("After Suite");
    }
}
