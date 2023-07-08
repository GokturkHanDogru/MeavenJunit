package day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C02_JSExecuter_Type extends TestBase {


    @Test
    public void name() {

        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        wait(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        wait(2);
        // Arama kutusuna "QA" yazıp aratın
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].value='QA'",aramaKutusu);

        sendKeysJS(aramaKutusu,"QA");

        aramaKutusu.submit();
    }
}
