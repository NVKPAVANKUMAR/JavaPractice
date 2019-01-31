package TestNgExamples;

import org.testng.annotations.*;

public class AnnotationsUsageExp2 {
    @BeforeClass
    public void beforeClassofClass2() {
        System.out.println("This is Before Class of class2");
    }

    //@BeforeTest
    public void beforeTest() {
        System.out.println("This is Before Test of class2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before Method of class2");
    }

    @Test
    public void test1() {
        System.out.println("This is Test1 of class 2");
    }

    @Test
    public void test2() {
        System.out.println("This is Test2 of class 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method of class2");
    }

    // @AfterTest
    public void afterTest() {
        System.out.println("This is After Test of class2");
    }

    @AfterClass
    public void afterClassOfClass2() {
        System.out.println("This is After Class of class2");
    }
}
