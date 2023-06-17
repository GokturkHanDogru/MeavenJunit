package day13_cookies_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");



        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.xpath("//div[@id=\"hot-spot\"]"));

        Actions actions = new Actions(driver);
        actions.contextClick(kutu).perform();

        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin

        wait(2);
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();
    }
}
