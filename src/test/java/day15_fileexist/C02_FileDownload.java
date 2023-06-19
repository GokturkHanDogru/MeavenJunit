package day15_fileexist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class C02_FileDownload extends TestBase {

    @Test
    public void test01() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        wait(2);

        File silinecekDosya = new File("C:\\Users\\goktu\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();


        /*

        File silinecekDosya = new File("C:\\Users\\BURAK\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

        Eger localinizden otomasyon ile bir dosya silmek icin File class'ından obje olusturup dosya yolunuzu
        içine yerlestiririz. Ve olusturdugumuz obje ile delete() methodunu kullanarak o dosyayı silebiliriz.

        Bunu yapma sebebimiz test class'ımızı çalıstırdıgımızda, her calıstırmada yeni bir dosya indirecegi icin
        ordaki dosya kalabalıgını önlemiş oluruz. aynı zamanda dogrulama yaparken işimizi garantiye almış oluruz.

        Aynı isimde birden fazla dosya indirmis olsak da her indirilenin yanına index verecegi icin ve bizim ilk indirdigimiz
        o klasörün icinde bulamayacagı icin her zaman ilk dosyanın varlıgı test etmis oluruz.



         */

        //"b10 all test cases" dosyasını indirin
        WebElement dosya = driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
        dosya.click();
        wait(5);
        String dosyaAdi = dosya.getAccessibleName();

        // Dosyanın başarıyla indirilip indirilmediğini test edin.
        Assert.assertTrue(Files.exists(Path.of("C:\\Users\\goktu\\Downloads\\b10 all test cases, code.docx")));

        // daha dinamik bir kod icin

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\b10 all test cases, code.docx";

        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Path.of(dosyaYolu)));

    }
}
