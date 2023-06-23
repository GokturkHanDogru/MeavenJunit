package day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {


    @Test
    public void name() {


        /*
        TimeOutException:

        sayfada aradaigimiz elementi wait ile belirttigimiz max. sürede bulmadigi durumda TOE hatasi aliriz.

         */

        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com");
        wait(3);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class=\"eicon-close\"]")).click();


        //searchBox'a java yazip aratalim
        WebDriverWait newWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox = newWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"elementor-search-form-9f26725\"]")));
        Assert.assertTrue(searchBox.isDisplayed());

        /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        */
    }


    @Test
    public void name2() {

        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();


        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait newWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        newWait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertTrue(helloWorld.isDisplayed());

        /*

        gercekte Hello World! yazisi ortalama 6 saniyede gozukuyor
        TimeOutException alabilmek icin Explicit Wait'e max bekleme sureisni 1 saniye verdik.
        Bu sebeple TimeOutException hatasi aldik.

         */



    }
}
