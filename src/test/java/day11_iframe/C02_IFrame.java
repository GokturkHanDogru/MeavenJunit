package day11_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C02_IFrame extends TestBase {

    @Test
    public void iframe() {
        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        WebElement kalinYazi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));


        //==>  textBox içindeki yazıyı siliniz.
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(iFrame);
        //Iframe gecmenin ikinci yolu index ile => driver.switchTo().frame(0);
        //Iframe gecmenin ücüncü yolu id/name ile => driver.switchTo().frame("mce_0_ifr");

        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();



        //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");


        //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSelenium  = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
    }
}
