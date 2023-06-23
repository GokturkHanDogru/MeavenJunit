package day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.TestBase;

public class C01_NoSuchElementException extends TestBase {


    @Test
    public void name() {
        //NoSuchElementException sayfada bulunmayan bir elemente erisim saglanmaya calisildiginda NSEE hatasi aliriz

        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com");
        wait(3);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class=\"eicon-close\"]")).click();


        //searchBox'a java yazip aratalim
        driver.findElement(By.xpath("//input[@id=\"elementor-search-form-9f26725\"]")).sendKeys("Java"+ Keys.ENTER);
    }
}
