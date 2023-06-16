package automationexercisecom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;

public class Case9 extends TestBase {
    @Test
    public void name() {



        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");



        //3. Verify that home page is visible successfully
        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());



        //4. Click on 'Products' button
        WebElement products = driver.findElement(By.xpath("//a[@href=\"/products\"]"));
        products.click();



        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));
        Assert.assertTrue(allProducts.isDisplayed());

        driver.navigate().back();
        driver.navigate().forward();



        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id=\"search_product\"]")).sendKeys("Dress"+Keys.ENTER);
        driver.findElement(By.xpath("//button[@id=\"submit_search\"]")).click();



        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));
        Assert.assertTrue(searchedProducts.isDisplayed());



        //8. Verify all the products related to search are visible
        List<WebElement> urunListesi = driver.findElements(By.xpath("(//div[@class=\"product-overlay\"])"));

        for (int i = 0; i < urunListesi.size(); i++) {
            urunListesi = driver.findElements(By.xpath("(//div[@class=\"product-overlay\"])"));
            WebElement urun = urunListesi.get(i);
            Assert.assertTrue(urun.isDisplayed());
        }
    }
}
