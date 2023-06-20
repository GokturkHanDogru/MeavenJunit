package day16_wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    @Test
    public void test01() {

        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");



        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();



        //==> Hello World! yazısının görünürlügünü test edin
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        expWait.until(ExpectedConditions.visibilityOf(helloWorld));
        //expWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));


    }
}
