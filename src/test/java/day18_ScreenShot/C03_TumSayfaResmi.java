package day18_ScreenShot;

import org.junit.Test;
import utils.TestBase;

public class C03_TumSayfaResmi extends TestBase {


    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


        //Ve ekran görüntüsünü alalım
        tumSayfaResmi();

    }
}
