package day09_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
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
        //driver.close();
    }

    @Test
    public void test01() {

        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");


        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement selectState = driver.findElement(By.xpath("//select[@id=\"state\"]"));

        Select select = new Select(selectState);

        select.selectByValue("AZ");

        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
        WebElement lastSelectedOption = select.getFirstSelectedOption();
        String lastSelectedOptionStr = lastSelectedOption.getText();
        Assert.assertEquals("Arizona", lastSelectedOptionStr);

        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
        /*List<WebElement> states = driver.findElements(By.xpath("//select[@id=\"state\"]"));

        for (int i = 0; i  < states.size(); i++) {
            driver.findElements(By.xpath("//select[@id=\"state\"]"));
            String state = states.get(i).getText();
            System.out.println(state);
        }

         */

       /* List<WebElement> options = select.getOptions();

        for (WebElement w :options) {
            System.out.println(w.getText());
        }

         */

        // options.stream().forEach(t-> System.out.println(t.getText()));

        List<WebElement> options = driver.findElements(By.xpath("//select[@id=\"state\"]//option"));
        options.stream().forEach(t-> System.out.println(t.getText()));
    }
}