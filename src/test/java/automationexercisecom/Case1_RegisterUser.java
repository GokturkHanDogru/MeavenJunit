package automationexercisecom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;



public class Case1_RegisterUser {
    WebDriver driver;
    //1. Launch browser
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }


    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://automationexercise.com");


        //3. Verify that home page is visible successfully

        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());


        //4. Click on 'Signup / Login' button

        WebElement signupLoginbutton = driver.findElement(By.cssSelector("a[href='/login']"));
        signupLoginbutton.click();


        //5. Verify 'New User Signup!' is visible

        WebElement newUserSignup = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUserSignup.isDisplayed());

        //6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("tahsin");
        WebElement mailadress = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        mailadress.sendKeys("tk89@gmail.com");

        //7. Click 'Signup' button
        WebElement signupButton = driver.findElement(By.xpath("//button[text()='Signup']"));
        signupButton.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccInfo = driver.findElement(By.xpath("(//div/h2)[1]"));
        Assert.assertTrue(enterAccInfo.isDisplayed());
        driver.findElement(By.xpath("//div[@class=\"grippy-host\"]")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");


        //9. Fill details: Title, Password, Date of birth
        Thread.sleep(3000);
        WebElement title = driver.findElement(By.id("id_gender1"));
        title.click();
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("1234Tk+");

        WebElement day=driver.findElement(By.xpath("//select[@name=\"days\"]"));
        Select numberOfDay=new Select(day);
        numberOfDay.selectByValue("2");

        WebElement month = driver.findElement(By.xpath("//select[@name=\"months\"]"));
        Select numberofDay = new Select(month);
        numberofDay.selectByValue("2");

        WebElement years = driver.findElement(By.xpath("//select[@name=\"years\"]"));
        Select numberofYears = new Select(years);
        numberofYears.selectByValue("1995");


        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkbox1=driver.findElement(By.id("newsletter"));
        checkbox1.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkbox2= driver.findElement(By.id("optin"));
        checkbox2.click();


        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName=driver.findElement(By.id("first_name"));
        firstName.sendKeys("Tahsin");
        WebElement lastName=driver.findElement(By.id("last_name"));
        lastName.sendKeys("Korkmaz");
        WebElement company =driver.findElement(By.id("company"));
        company.sendKeys("Techproeducation");
        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("Passauer Strasse");
        WebElement address2 =driver.findElement(By.id("address2"));
        address2.sendKeys("No:4");
        WebElement country=driver.findElement(By.id("country"));
        Select selectObject=new Select(country);
        selectObject.selectByValue("Canada");
        WebElement state= driver.findElement(By.id("state"));
        state.sendKeys("Wiesbaden");
        WebElement city= driver.findElement(By.id("city"));
        city.sendKeys("Kostheim");
        WebElement zipcode= driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("55246");
        WebElement mobileNummer= driver.findElement(By.id("mobile_number"));
        mobileNummer.sendKeys("123456789");

        //13. Click 'Create Account button'
        WebElement createAccount= driver.findElement(By.xpath("//*[text()='Create Account']"));
        createAccount.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accCreated= driver.findElement(By.xpath("//b"));
        Assert.assertTrue(accCreated.isDisplayed());

        //15. Click 'Continue' button
        WebElement continueButton=driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        continueButton.click();

        //16. Verify that 'Logged in as username' is visible
        WebElement usernameControl=driver.findElement(By.xpath("(//li)[10]"));
        Assert.assertTrue(usernameControl.isDisplayed());




        //17. Click 'Delete Account' button
        WebElement deleteButton=driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]"));
        deleteButton.click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accDeleted=driver.findElement(By.cssSelector("h2[class='title text-center']"));
        Assert.assertTrue(accDeleted.isDisplayed());
        continueButton.click();


    }


}