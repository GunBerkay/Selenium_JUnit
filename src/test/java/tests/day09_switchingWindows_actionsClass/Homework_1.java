package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class Homework_1 extends TestBase_Each {
    @Test
    public void test01(){
//        2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
//        3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

//        4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

//        5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

//        6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']"))
                .click();

//        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String seleniumUrl="https://elementalselenium.com/";

        ReusableMethods.urlIleWindowGecisi(driver,seleniumUrl);

        WebElement titleElementi= driver.findElement(By.xpath("//h1[text()='Elemental Selenium']"));

        String expectedText="Elemental Selenium";
        String actualText=titleElementi.getText();

        Assertions.assertEquals(expectedText,actualText);

    }
}
