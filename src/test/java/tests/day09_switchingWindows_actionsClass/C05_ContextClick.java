package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_ContextClick extends TestBase_Each {

    @Test
    public void test01(){
//        1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
//        2- “DGI Drones” uzerinde sag click yapin
        Actions actions=new Actions(driver);
        ReusableMethods.bekle(1);
        WebElement dgiDronesElementi= driver.findElement(By.id("pic2_thumb"));
        actions.contextClick(dgiDronesElementi).perform();
        ReusableMethods.bekle(2);

//        3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedAlertYazi="Tebrikler!... Sağ click yaptınız.";
        ReusableMethods.bekle(1);
        String actualAlertYazisi=driver.switchTo().alert().getText();
        ReusableMethods.bekle(1);

        Assertions.assertEquals(expectedAlertYazi,actualAlertYazisi);

//        4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(2);


    }
}
