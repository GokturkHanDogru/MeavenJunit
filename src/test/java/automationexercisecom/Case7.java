package automationexercisecom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case7 {
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
        WebElement homePage = driver.findElement(By.xpath("//a[@href=\"/login\"]"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Test Cases' button

        WebElement testCases = driver.findElement(By.xpath("(//a[@href=\"/test_cases\"])[1]"));
        testCases.click();

        //5. Verify user is navigated to test cases page successfully

        driver.navigate().back();
        driver.navigate().forward();

        System.out.println(driver.findElement(By.xpath("//h2//b")).isDisplayed());
    }
    }

