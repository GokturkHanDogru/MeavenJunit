package day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C02_BasicAuthentication extends TestBase {
    /*
    -Authentication kimlik dogrulama yöntemidir
    - söz konusu sisteme dahil olup olunamayacagını belirleyen formu ifade eder
    - Authentication üzerinde sag click yapıp locate alınamaz
    - Authentication bir alert degildir
    - Authentication yapabilmek icin uygulamanın kullanıcılara,
    Authentication'ı nasıl yapacagına dair bilgilendirme yapmıs olması gerekir
    - https://username:password@URL gibi

     */
    @Test
    public void name() {

        // Aşağıdaki bilgileri kullanarak authentication yapınız:

        // Url: https://the-internet.herokuapp.com/basic_auth
        // Username: admin
        // Password: admin

        /*
        https://username:password@URL
        Yukaridaki formata uygun kimlik dogrulamasi yapilacaktir
        */

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız

        WebElement paragraf = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraf.getText().contains("Congratulations"));

    }
}
