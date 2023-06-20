package automationexercisecom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class Case17 extends TestBase {

    @Test
    public void test001() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully
        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());


        //4. Add products to cart
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        wait(2);
        driver.findElement(By.xpath("(//a[@data-product-id=\"1\"])[1]")).click();



        //5. Click 'Cart' button

        driver.findElement(By.xpath("(//u)")).click();


        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='Shopping Cart']")).isDisplayed());

        wait(2);

        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//a[@class=\"cart_quantity_delete\"]")).click();


        //8. Verify that product is removed from the cart
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Cart is empty!']")).isDisplayed());

    }
}
