package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C08_DosyaYuklemeTesti extends TestBase_Each {

    @Test
    public void test01(){

//        1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

//        2.chooseFile butonuna basalim
        //day10 package'i altindaki deneme dosyasini secelim.

        WebElement chooseFileButonu= driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu=System.getProperty("user.dir") + "/" + "src/test/java/tests/day10_keyboardActions_faker_fileTestleri/deneme.txt";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);


//
//        4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();
//        5.“File Uploaded!” textinin goruntulendigini test edelim.

        String actualYazi=driver.findElement(By.tagName("h3")).getText();
        String expectedYazi="“File Uploaded!”";
        Assertions.assertEquals(expectedYazi,actualYazi);


    }
}
