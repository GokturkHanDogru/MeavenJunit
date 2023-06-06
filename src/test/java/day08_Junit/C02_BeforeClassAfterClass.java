package day08_Junit;

import org.junit.*;

public class C02_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass metodlari sadece static metodlar ile calisir

    @BeforeClass class'da en once calısan methoddur.
    @AfterClass class'da en son calısan methoddur.


     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Before Class is working");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("After Class is working ");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Run befor every Test Method");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Run after every Test Method");
    }

    @Test
    public void Test01() {
        System.out.println("First Test");
    }

    @Test
    public void Test02() {
        System.out.println("Second Test");
    }
}
