package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C02_KontrolsuzAcilanWindowGecisleri extends TestBase_Each {

    @Test
    public void test01(){
        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaText = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String actualText = sayfaText.getText();
        String expectedText = "Opening a new window";

        Assertions.assertEquals(expectedText, actualText);
//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);
//● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        String eskiWindowWhd = driver.getWindowHandle();

        Set<String> acikTumWindowlarinWhd = driver.getWindowHandles();

        String yeniWindowWhd = "";
        for (String eachWhd : acikTumWindowlarinWhd) {
            if (!eachWhd.equals(eskiWindowWhd)) {
                yeniWindowWhd = eachWhd;
            }
        }
        driver.switchTo().window(yeniWindowWhd);
//● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement sayfa2Text = driver.findElement(By.xpath("//h3[text()='New Window']"));
        String expectedText2 = "New Window";
        String actualTitle2 = sayfa2Text.getText();

        Assertions.assertEquals(expectedText2, actualTitle2);
//● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin
        driver.switchTo().window(eskiWindowWhd);
        String expectedBaslik = "The Internet";
        String actualBaslik = driver.getTitle();

        Assertions.assertEquals(expectedBaslik, actualBaslik);

    }


}
