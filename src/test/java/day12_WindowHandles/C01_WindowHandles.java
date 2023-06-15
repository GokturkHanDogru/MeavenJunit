package day12_WindowHandles;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utils.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void windowHandles() {


        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");



        //  ilk sayfasının Handle degerini alın yazdırın
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println(sayfa1Handle);


        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String ilkSayfaText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
        Assert.assertTrue(ilkSayfaText.contains("Opening a new window"));


        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String ilkSayfaTitle = driver.getTitle();
        Assert.assertEquals(ilkSayfaTitle,"The Internet");



        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> windowHandleSeti = driver.getWindowHandles();
        String sayfa2Handle="";

        for (String each : windowHandleSeti) {
            if (!each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }
        }

        driver.switchTo().window(sayfa2Handle);



        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertEquals(ikinciSayfaTitle,"New Window");




        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(sayfa1Handle);
        Assert.assertEquals(driver.getTitle(),"The Internet");



        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2Handle);



        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfa1Handle);
    }
}
