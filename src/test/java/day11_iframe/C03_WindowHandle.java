package day11_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utils.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
        //  https://www.techproeducation.com adresine gidiniz

        driver.get("https://www.techproeducation.com");
        String techProHandleDegeri = driver.getWindowHandle();
        System.out.println(techProHandleDegeri);


        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";

        Assert.assertEquals(actualTitle,expectedTitle);

        //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeHandelDegeri = driver.getWindowHandle();
        System.out.println(youtubeHandelDegeri);



        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        String linkedinHandleDegeri = driver.getWindowHandle();
        System.out.println(linkedinHandleDegeri);

        wait(2);


        //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techProHandleDegeri);
        wait(2);



        //  youtube sayfasına geçiniz
        driver.switchTo().window(youtubeHandelDegeri);
        wait(2);



        //  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandleDegeri);
    }
}
