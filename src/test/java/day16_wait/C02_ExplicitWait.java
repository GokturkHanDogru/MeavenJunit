package day16_wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    @Test
    public void explicitWait() {

        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");




        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();




        //==> Hello World! yazısının görünürlügünü test edin


        /*
        WebElement helloWorldYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloWorldYazisi.isDisplayed());

        Hello World! yazısının gorunurlugunu implicitly wait ile cözemedik

         */

        WebElement helloWorldYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));


       visibleWait(helloWorldYazisi,100);


        Assert.assertTrue(helloWorldYazisi.isDisplayed());
    }
}
