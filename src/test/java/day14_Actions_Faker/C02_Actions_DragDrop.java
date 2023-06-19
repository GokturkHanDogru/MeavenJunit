package day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class C02_Actions_DragDrop extends TestBase {

    @Test
    public void name() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
        driver.switchTo().frame(iframe);
        wait(2);

        WebElement drag = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
    }

    @Test
    public void name2() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag). //--> Bu method ile webelemente mouse ile basili tuttuk
                moveToElement(drop).//--> Bu method ile basili tuttugumuz webelementi diger webelementin uzerine goturduk
                release().//--> Bu method ile basili tuttugumuz webelementi serbest biraktik.
                perform();//--> Islemi sonlandirdik
    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        wait(2);
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(145,28).//Belirtilen koordinata #webelementi tasir
                release().perform();
    }
}
