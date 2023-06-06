package day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // Login alanina  "username" yazdirin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");

        // Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        // Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();

        // Online Banking bölümüne tıklamalın
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        // Pay Bills yazan kısıma tıklayın
        driver.findElement(By.xpath("(//span[@class=\"headers\"])[4]")).click();

        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id=\"sp_amount\"]")).sendKeys("1500");

        // Date kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//input[@id=\"sp_date\"]")).sendKeys("2020-09-10");

        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();

        // "The payment was successfully submitted." mesajinin ciktigini test edin
        WebElement sonuc = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (sonuc.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        // Sayfayi kapatın
        driver.close();
    }
}
