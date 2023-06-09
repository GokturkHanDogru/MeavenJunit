package day19_ExtendReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C03_WebTables extends TestBase {
/*
    WEBTABLE;
        <table> tagi ile baslar
            <thead> basliklar icin bu tag ile devam eder
                <th> table head
                    <td> basliktaki veriler
                        <tbody> basliklar altindaki verileri temsil eder
                            <tr> table row(satir)
                                <td> table data(tablodaki veri)

     */
    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Table 1");
        System.out.println(table1.getText());


        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement row3= driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("Row 3");
        System.out.println(row3.getText());


        //    Task 3 : Son satırın verilerini yazdırın


        //    Task 4 : 5. Sütun verilerini yazdırın
        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
    }
}
