package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;
import utilities.TestBase_Each;

public class homeWork_1 extends TestBase_Each {

// 1) https://www.youtube.com adresine gidin
// 2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
//○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest(){
        driver.get("https://www.youtube.com");
        String expectedTitle="YouTube";
        String actualTittle= driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTittle);
    }

//○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest(){
        driver.get("https://www.youtube.com");

        WebElement youtubeImg =driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assertions.assertTrue(youtubeImg.isDisplayed());
    }

//○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
        public void searchBoxTest(){
        driver.get("https://www.youtube.com");
        WebElement searchBoxElementi = driver.findElement(By.xpath("(//input[@name='search_query'])[1]"));
        Assertions.assertTrue(searchBoxElementi.isEnabled());
    }

// ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest(){
        driver.get("https://www.youtube.com");
        String actualSayfaTitle= driver.getTitle();
        String unExpectedSayfaTitle="youtube";

        Assertions.assertNotEquals(unExpectedSayfaTitle,actualSayfaTitle);


    }


}
