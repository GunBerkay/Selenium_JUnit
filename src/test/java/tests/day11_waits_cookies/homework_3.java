package tests.day11_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class homework_3 extends TestBase_Each {

    @Test
    public void test01() {

        // Window Handle Homework

//        1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

//        2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();

//        3."Login Portal" a tiklayin
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("(//div[@class='section-title'])[2]"))
                .click();

//        4.Diger window'a gecin
        String hedefUrl = "https://webdriveruniversity.com/Login-Portal/index.html";
        ReusableMethods.urlIleWindowGecisi(driver, hedefUrl);

//        5."username" ve "password" kutularina deger yazdirin
        WebElement usernameBox = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        usernameBox.click();
        actions.sendKeys("Berkay")
                .sendKeys(Keys.TAB)
                .sendKeys("12345678").perform();

//        6."login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']"))
                .click();

//        7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        ReusableMethods.bekle(1);
        String expectedYazi = "validation failed";
        String actualYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

//        8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

//        9.Ilk sayfaya geri donun
        String ilksayfaUrl = "https://webdriveruniversity.com/";
        ReusableMethods.urlIleWindowGecisi(driver, ilksayfaUrl);

//        10.Ilk sayfaya donuldugunu test edin

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://webdriveruniversity.com/";

        Assertions.assertEquals(expectedUrl, actualUrl);

    }

}
