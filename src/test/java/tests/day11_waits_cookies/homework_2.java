package tests.day11_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class homework_2 extends TestBase_Each {

    @Test
    public void test01() {

        // Iframe Homework

//        1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

//        2. “Our Products” butonuna basin
        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElementi);

        driver.findElement(By.xpath("//a[text()='Our Products']"))
                .click();

//        3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//img[@id='camera-img']"))
                .click();
        ReusableMethods.bekle(1);

//        4. Popup mesajini yazdirin
        WebElement popupElementi = driver.findElement(By.xpath("//div[@class='modal-content']"));
        System.out.println(popupElementi.getText());

//        5. “close” butonuna basin
        driver.findElement(By.xpath("(//button[@data-dismiss='modal'])[3]"))
                .click();

//        6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]"))
                .click();

//        7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        WebElement yaziElementi = driver.findElement(By.xpath("//h1[@style='color:#f45950;']"));

        Assertions.assertTrue(yaziElementi.isDisplayed());

    }

}
