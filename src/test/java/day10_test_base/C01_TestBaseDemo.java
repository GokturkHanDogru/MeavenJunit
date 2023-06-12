package day10_test_base;

import org.junit.Assert;
import org.junit.Test;
import utils.TestBase;

public class C01_TestBaseDemo extends TestBase {




    @Test
    public void test01() {
        //Techproed sayfasina gidiniz
        driver.get("https://techproeducation.com");


        //Basligin bootcamp icerdigini test ediniz
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
