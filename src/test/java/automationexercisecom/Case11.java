package automationexercisecom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

public class Case11 extends TestBase {
    @Test
    public void name() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");



        //3. Verify that home page is visible successfully
        WebElement homeButton = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(homeButton.isDisplayed());


        //4. Add products to cart
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("(//a[@data-product-id=\"2\"])[1]")).click(); //ilk ürün
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();// continue shopping

        driver.findElement(By.xpath("(//a[@data-product-id=\"3\"])[1]")).click();//ikinci ürün
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();// continue shopping



        //5. Click 'Cart' button
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("(//a[@href=\"/view_cart\"])[1]")).click();



        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[text()='Shopping Cart']"));
        Assert.assertTrue(cartPage.isDisplayed());



        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();



        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();



        //9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("gokturk"+Keys.TAB+"gokturk@gmail.com"+Keys.TAB+Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//div[@class=\"grippy-host\"]")).click(); //Reklami gecmek icin yazdim.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement title = driver.findElement(By.id("id_gender1")); // Mr. or Mrs.
        title.click();

        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("1234Gd"+Keys.ENTER);// password


        WebElement day=driver.findElement(By.xpath("//select[@name=\"days\"]")); // Gün
        Select numberOfDay=new Select(day);
        numberOfDay.selectByValue("2");

        WebElement month = driver.findElement(By.xpath("//select[@name=\"months\"]")); // Ay
        Select numberofDay = new Select(month);
        numberofDay.selectByValue("2");

        WebElement years = driver.findElement(By.xpath("//select[@name=\"years\"]")); //Yil
        Select numberofYears = new Select(years);
        numberofYears.selectByValue("1995");


        WebElement checkbox1=driver.findElement(By.id("newsletter")); // Newsletter
        checkbox1.click();

        WebElement checkbox2= driver.findElement(By.id("optin"));// Special offers
        checkbox2.click();


        actions.sendKeys(Keys.PAGE_DOWN).perform();

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

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement city= driver.findElement(By.id("city"));
        city.sendKeys("Kostheim");
        WebElement zipcode= driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("55246");
        WebElement mobileNummer= driver.findElement(By.id("mobile_number"));
        mobileNummer.sendKeys("123456789");

        WebElement createAccount= driver.findElement(By.xpath("//*[text()='Create Account']"));
        createAccount.click();


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accCreated= driver.findElement(By.xpath("//b"));
        Assert.assertTrue(accCreated.isDisplayed());

        WebElement continueButton=driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        continueButton.click();


        //11. Verify ' Logged in as username' at top
        WebElement loggedUsername = driver.findElement(By.xpath("(//a)[11]"));
        Assert.assertTrue(loggedUsername.isDisplayed());

        //12.Click 'Cart' button
        driver.findElement(By.xpath("(//a)[4]")).click();

        //13. Click 'Proceed To Checkout' button
        //14. Verify Address Details and Review Your Order
        //15. Enter description in comment text area and click 'Place Order'
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
