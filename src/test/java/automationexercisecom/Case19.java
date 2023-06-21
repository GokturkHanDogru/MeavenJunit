package automationexercisecom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class Case19 extends TestBase {
    @Test
    public void name() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");



        //3. Click on 'Products' button
        WebElement products = driver.findElement(By.xpath("//a[@href=\"/products\"]"));
        products.click();

        driver.navigate().back();
        driver.navigate().forward();



        //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));
        Assert.assertTrue(allProducts.isDisplayed());



        //5. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id=\"search_product\"]")).sendKeys("Dress"+ Keys.ENTER);
        driver.findElement(By.xpath("//button[@id=\"submit_search\"]")).click();


        //6. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class=\"title text-center\"]")).isDisplayed());



        //7. Verify all the products related to search are visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"features_items\"]")).isDisplayed());



        //8. Add those products to cart
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]")).click();



        //9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("(//u)[1]")).click();



        //10. Click 'Signup / Login' button and submit login details
        //11. Again, go to Cart page
        //12. Verify that those products are visible in cart after login as well
//
    }
}
