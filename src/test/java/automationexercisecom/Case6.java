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
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Case6 {
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

    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully

        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());

        //4.Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href=\"/contact_us\"]")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("(//h2[@class=\"title text-center\"])[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());

        driver.findElement(By.xpath("//div[@class=\"grippy-host\"]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//path[@stroke='#FAFAFA']")).click();


        //6. Enter name, email, subject and message
        WebElement name = driver.findElement(By.xpath("//input[@data-qa=\"name\"]"));
        name.sendKeys("Gokturk"+ Keys.TAB+ "gkhn@gmail.com"+Keys.TAB+"Java"+Keys.TAB+"Merhaba");



        //7. Upload file
        WebElement uploadFile = driver.findElement(By.xpath("//input[@name=\"upload_file\"]"));
        uploadFile.sendKeys("C:\\Users\\goktu\\OneDrive\\Bilder\\k11.PNG");

        //8. Click 'Submit' button

        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();


        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement message = driver.findElement(By.xpath("(//div[text()='Success! Your details have been submitted successfully.'])[1]"));
        String messageStr = message.getText();
        Assert.assertEquals("Success! Your details have been submitted successfully.",messageStr);


        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//i[@class=\"fa fa-home\"]")).click();
        Thread.sleep(3000);

    }
}
