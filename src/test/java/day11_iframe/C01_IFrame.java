package day11_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C01_IFrame extends TestBase {
    @Test
    public void iframe() {
        //==>   https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        String anIFrame = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        String expectedWords = "black border";
        Assert.assertTrue(anIFrame.contains(expectedWords));


        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim

        WebElement iFrame = driver.findElement(By.xpath("//iframe[@style=\"border:1px solid black;\"]"));
        driver.switchTo().frame(iFrame);
        WebElement applicationYazisi = driver.findElement(By.xpath("//h1[text()='Applications lists']"));
        Assert.assertTrue(applicationYazisi.isDisplayed());

        //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
        driver.switchTo().defaultContent();
        WebElement powerByYazisi = driver.findElement(By.xpath("(//p[text()='Povered By'])[1]"));
        Assert.assertTrue(powerByYazisi.getText().contains("Povered"));

    }
}
