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

public class C03_DropDown {
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


        // Programlama Dili Dropdown'undan "Java" seciniz
        WebElement selectLang = driver.findElement(By.xpath("//select[@name=\"Languages\"]"));

        Select select = new Select(selectLang);

        select.selectByValue("java");


        // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
        WebElement lastSelectedLang = select.getFirstSelectedOption();

        String lastSelectedLangStr = lastSelectedLang.getText();

        Assert.assertEquals("Java",lastSelectedLangStr);


        // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız

        List<WebElement> options = select.getOptions();

        options.stream().forEach(t-> System.out.println(t.getText()));


        // Sayfadaki tum Dropdown'lardaki tum optionları konsolda yazdırınız

       List<WebElement> allDdmOptions = driver.findElements(By.tagName("option"));

       allDdmOptions.stream().forEach(t-> System.out.println(t.getText()));
    }



}
