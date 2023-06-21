package automationexercisecom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class Case18 extends TestBase {

    @Test
    public void name() {


       //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


       //3. Verify that categories are visible on left side bar
        WebElement categories = driver.findElement(By.xpath("//div[@class=\"panel-group category-products\"]"));
        Assert.assertTrue(categories.isDisplayed());


        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //4. Click on 'Women' category
        driver.findElement(By.xpath("(//i[@class=\"fa fa-plus\"])[1]")).click();
        wait(2);



        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[@href=\"/category_products/1\"]")).click();
        driver.navigate().back();
        driver.navigate().forward();



        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class=\"title text-center\"]")).isDisplayed());
        wait(2);


       //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("(//i[@class=\"fa fa-plus\"])[2]")).click(); // Men clicked
        driver.findElement(By.xpath("//a[@href=\"/category_products/3\"]")).click(); // T-shirt clicked




        //8. Verify that user is navigated to that category page
        WebElement message = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));
        Assert.assertTrue(message.isDisplayed());

    }
}
