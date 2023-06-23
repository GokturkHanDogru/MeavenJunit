package day17_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class C03_NullPointerException  {

    /*
    NullPointerException
    Degisken ya da obje olusturup bu degiskene atama yapmadigimizda ya da esitlemedigimizda
    NullPointerException hatasi aliriz.

     */
    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    String isim;

    @Test
    public void NullPointerException1() {
        //driver = new ChromeDriver(); atamasini yapmadigimiz icin NullPointerException hatasini aldik
        //TestBase'den de alabilirdi ancak extends yapmadik
        driver.get("https://amazon.com");

    }

    @Test
    public void NullPointerException2() {
        System.out.println(faker.name().firstName());
        //faker= new Faker(); atamasini yapmadigimiz icin NullPointerException hatasini aldik

    }

    @Test
    public void NullPointerException3() {
        // sayi=6; sayi degiskenine atama yapmadigim icin NPE hatasi aldik
        System.out.println(sayi + 5);
    }

    @Test
    public void NullPointerEception4() {
        // isim ="Burak"; isim degiskenine atama yapmadigim icin NPE hatasi aldik
        System.out.println(isim.charAt(0));

    }
}
