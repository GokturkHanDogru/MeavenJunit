package automationexercisecom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Case8 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        // driver.close();
    }

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());

        //4. Click on 'Products' button
        WebElement products = driver.findElement(By.xpath("//a[@href=\"/products\"]"));
        products.click();

        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));
        Assert.assertTrue(allProducts.isDisplayed());

        //6. The products list is visible
        List<WebElement> urunListesi = driver.findElements(By.xpath("//div[@class=\"product-overlay\"]"));

        for (int i = 0; i <urunListesi.size() ; i++) {

            urunListesi = driver.findElements(By.xpath("//div[@class=\"product-overlay\"]"));
            WebElement urun =urunListesi.get(i);
            Assert.assertTrue(urun.isDisplayed());

        }

        //7. Click on 'View Product' of first product

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//a[@href=\"/product_details/1\"]")).click();


        //8. User is landed to product detail page
        WebElement ilkUrun = driver.findElement(By.xpath("//h2[text()='Blue Top']"));
        Assert.assertTrue(ilkUrun.isDisplayed());

        //9. Verify that  detail is visible: product name, category, price, availability, condition, brand
        WebElement urunBilgi = driver.findElement(By.xpath("//div[@class=\"product-information\"]"));
        Assert.assertTrue(urunBilgi.isDisplayed());
    }
}
