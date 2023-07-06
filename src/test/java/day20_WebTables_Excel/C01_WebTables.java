package day20_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {


    @Test
    public void name() {

//    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Table 1");
        System.out.println(table1.getText());

        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");
    }


    @Test
    public void test02() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

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

    @Test
    public void test03() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");


        //    Task 3 : Son satırın verilerini yazdırın
        List<WebElement> list= driver.findElements(By.xpath("(//table)[1]//tbody//tr[4]//td"));
        list.stream().forEach(t-> System.out.print(t.getText() + " - "));
    }

    @Test
    public void test04() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 4 : 5. Sütun basligini yazdırın
        WebElement baslik = driver.findElement(By.xpath("//table[1]//thead//tr//th[5]"));
        System.out.println(baslik.getText());



        //    Task 4 : 5. Sütun verilerini yazdırın
        List <WebElement> besinciSütunVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        besinciSütunVerileri.stream().forEach(t -> System.out.println(t.getText()+" - "));
    }

    @Test
    public void test05() {

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        
        
        printData(2,3);
        printData(2,5);
        
    }

    private void printData(int satir, int sütun) {


        WebElement satirSütun = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sütun+"]"));

        System.out.println(satirSütun.getText());

    }
}
