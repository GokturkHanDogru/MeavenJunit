package day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C01_JSExecuter_Scroll extends TestBase {

    //  https://techproeducation.com sayfasına gidin
    // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
    // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
    // Sayfayi en üste scroll et (sayfayı kaydır)
    // Sayfayı en alta scroll et (sayfayı kaydır)

    JavascriptExecutor js;

    @Test
    public void jsExecuterScrollTest() {

        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        wait(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement weOffer = driver.findElement(By.xpath("//span[text()='we offer']"));

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        wait(2);



        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        WebElement enrollFree = driver.findElement(By.xpath(" //span[text()='Enroll Free Course']"));
        scroll(enrollFree);
        wait(2);



        // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUS=driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        scroll(whyUS);
        wait(2);



        // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        scroll(enrollFree);
        wait(2);


        // Sayfayi en üste scroll et (sayfayı kaydır)
        scrollHome();


        // Sayfayı en alta scroll et (sayfayı kaydır)
        scrollEnd();



    }



}
