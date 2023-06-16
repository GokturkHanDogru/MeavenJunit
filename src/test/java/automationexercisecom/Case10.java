package automationexercisecom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class Case10 extends TestBase {

    @Test
    public void name() throws InterruptedException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");



        //3. Verify that home page is visible successfully
        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());


        //4. Scroll down to footer

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //5. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());

        //6. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id=\"susbscribe_email\"]")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//button[@id=\"subscribe\"]")).click();
        Thread.sleep(5000);



        //7. Verify success message 'You have been successfully subscribed!' is visible
    }
}
