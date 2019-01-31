package TestNgExamples;

import org.testng.annotations.*;

public class AnnotationsUsageExp {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is Before Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is Before Test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before Method");
    }

    @Test
    public void test1() {
        System.out.println("This is Test1");
    }

    @Test
    public void test2() {
        System.out.println("This is Test2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is After Test");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is After Class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is Before Suite");
    }


}
