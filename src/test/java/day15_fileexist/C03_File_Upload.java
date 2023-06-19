package day15_fileexist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C03_File_Upload extends TestBase {
    @Test
    public void upload() {
        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz

        driver.get("https://the-internet.herokuapp.com/upload");
        wait(2);
        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz

       WebElement dosyaSec = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));

        dosyaSec.sendKeys("C:\\Users\\goktu\\OneDrive\\Desktop\\Text.txt");

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();


        // 'File Uploaded!' yazısının goruntulendigini test edin

       WebElement fileUploaded = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(fileUploaded.isDisplayed());

    }
}
