package day15_fileexist;

import org.junit.Assert;
import org.junit.Test;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist  {

    @Test
    public void fileexist() {
        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("user.home"));
    }

    @Test
    public void test01() {
        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
        //C:\Users\goktu\OneDrive\Desktop\Text.txt

        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\goktu\\OneDrive\\Desktop\\Text.txt")));

        String farkliKisim = System.getProperty("user.home");
        String ayniKisim = "\\OneDrive\\Desktop\\Text.txt";

        String dosyaYolu = farkliKisim+ayniKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
