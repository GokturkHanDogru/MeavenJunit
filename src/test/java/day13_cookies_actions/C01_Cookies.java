package day13_cookies_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utils.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void name() {

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie'leri listeleyin

        //1.Yol
        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(t-> System.out.println(t));


        //2.Yol
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac=1;
        for (Cookie w :cookieSet) {
            System.out.println(sayac+". Cookie"+w);
            System.out.println(sayac+". Cookie Name"+w.getName());
            System.out.println(sayac+". Cookie Value"+w.getValue());

            sayac++;
            
        }


        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookies = cookieSet.size();
        Assert.assertTrue(cookies>5);


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue= "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);


        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie'nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();

        for (Cookie w:cookieSet) {
            System.out.println(w);
        }

        System.out.println(cookieSet.size());

        Assert.assertTrue(cookieSet.contains(cookie));



        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        driver.manage().getCookies();//Tekrar atama yapiyoruz silindikten sonra

        Assert.assertTrue(!cookieSet.contains("skin"));


        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        System.out.println(cookieSet.size());
    }
}
