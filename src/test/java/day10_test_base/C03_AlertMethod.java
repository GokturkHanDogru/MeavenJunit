package day10_test_base;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.TestBase;

public class C03_AlertMethod extends TestBase {
    /*
https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.


Bir metod olusturun: acceptAlert
1. butona tıklayın,
uyarıdaki OK butonuna tıklayın
ve result mesajının "You successfully clicked an alert" oldugunu test edin.



Bir metod olusturun: dismissAlert
2. butona tıklayın,
uyarıdaki Cancel butonuna tıklayın
ve result mesajının "successfuly" icermedigini test edin.



Bir metod olusturun: sendKeysAlert
3. butona tıklayın,
uyarıdaki mesajı konsolda yazdırın,
uyarıdaki metin kutusuna isminizi yazin,
OK butonuna tıklayın
ve result mesajında isminizin görüntülendiğini doğrulayın.

 */
    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[1]")).click();

        alertAccept();// TestBase'den cagiridm  driver.switchTo().alert().accept();

        String actualMessage = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']")).getText();
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void dissmissAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[2]")).click();
        wait(2);

        alertDismiss();//driver.switchTo().alert().dismiss();

        String actualMessage = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        String expectedMessage = "succesfully";
        Assert.assertTrue(!actualMessage.contains(expectedMessage));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[3]")).click();
        wait(2);

        alertTextPrint();//System.out.println(driver.switchTo().alert().getText());

        alertPrompt("Göktürk");//driver.switchTo().alert().sendKeys("Göktürk");
        driver.switchTo().alert().accept();

        String actualMessage = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        String expectedMessage = "Göktürk";
        Assert.assertTrue(actualMessage.contains(expectedMessage));



    }
}
