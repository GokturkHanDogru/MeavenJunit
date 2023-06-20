package automationexercisecom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class Case12 extends TestBase {

    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());



        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();

        driver.navigate().back();
        driver.navigate().forward();


        //5. Hover over first product and click 'Add to cart'
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        driver.findElement(By.xpath("(//a[@data-product-id=\"1\"])[1]")).click();


        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]")).click();


        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//a[@data-product-id=\"2\"])[1]")).click();


        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u")).click();


        //9. Verify both products are added to Cart


        Assert.assertTrue(driver.findElement(By.xpath("(//a[@data-product-id=\"1\"])[1]")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("(//a[@data-product-id=\"2\"])[1]")).isDisplayed());


        //10. Verify their prices, quantity and total price

        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id=\"product-1\"]")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//tr[@id=\"product-2\"]")).isDisplayed());
    }
}
