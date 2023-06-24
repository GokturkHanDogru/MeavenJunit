package day19_ExtendReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.TestBase;

public class C02_ExtentReport extends TestBase {

    @Test
    public void test01() {

        extentReport( "Chrome", "Amazon Test");
        extentTest=extentReports.createTest("Extend Report","Test Report");


        //amazon.com'a gidiiniz
        driver.get("https://amazon.com/");
        extentTest.info("Amazon sayfasi acildi");


        //sayfanın resmini alınız
        tumSayfaResmi();
        extentTest.info("Sayfanin resmi alindi");



        //arama kutusunda iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");




    }
}
