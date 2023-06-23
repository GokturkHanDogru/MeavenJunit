package day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
        /*
        SCREENSHOT

               Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
           driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
           getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
           oranın yolunu belirtiriz.
         */

    @Test
    public void name() throws IOException {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        wait(2);


        //reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //Ve ekran görüntüsünü alalım

         /*
        - İlk olarak SS alacağımız da nereye kaydetmek istiyorsak oranın yolunu belirtelim.
         -İkinci olarak TakesScreenShot arayüzünden obje oluşturuz
         -Üçüncü olarak FileUtils classından copyFile() methodu ile ts opjemizi kullanarak getScreenShotAs methodu ile
         dosya yolunu belirteceğiz.
          */


        String dosyaYolu = "src/test/java/TümSayfaResmi/ScreenShot.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        wait(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("ScreenShot/screenShot.png"));
    }


    @Test
    public void test03() throws IOException {

        /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
        String bir değişkene tarih formatı atayabiliriz.
        */


        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        wait(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        /*
            SimpleDateFormat'i kullanarak yeni bir tarih formati olusturup bir String'e assing ederiz. Ve bunu dosya isminden once
            belirtiriz.
         */

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/TümSayfaResmi/ScreenShot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }


    @Test
    public void test04() throws IOException {

        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        wait(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/TümSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
}
