package day16_wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C04_ExplicitWait extends TestBase {

    @Test
    public void name() {

        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //==>  Remove tuşuna basın
        WebElement remove = driver.findElement(By.xpath("//button[text()='Remove']"));
        remove.click();



        //==>  "It's gone!" yazısının görünür oldugunu test edin.
        WebElement itsGone = driver.findElement(By.xpath("(//p)[2]"));
        Assert.assertTrue(itsGone.isDisplayed());

    }
}
