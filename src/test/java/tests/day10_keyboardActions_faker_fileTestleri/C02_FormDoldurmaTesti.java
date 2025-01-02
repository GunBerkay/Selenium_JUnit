package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_FormDoldurmaTesti extends TestBase_Each {

    @Test
    public void formDoldurmaTesti(){
//        1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
//        2- Account linkine tiklayin
        driver.findElement(By.xpath("(//a[@class='e-cart'])[1]"))
                .click();
//        3- Sign Up linkine basalim
        driver.findElement(By.xpath("//a[@class='sign-up ']"))
                .click();
//        4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        Actions actions=new Actions(driver);
        ReusableMethods.bekle(1);
        WebElement firstnameText= driver.findElement(By.xpath("//input[@id='firstName']"));
        actions.click(firstnameText)
                .sendKeys("Berkay")
                .sendKeys(Keys.TAB)
                .sendKeys("Gun")
                .sendKeys(Keys.TAB)
                .sendKeys("gunberkay@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("55222888444")
                .sendKeys(Keys.TAB)
                .sendKeys("55222888444").perform();
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//button[@id='btn-submit-form']"))
                .click();
//        5- Kaydin olusturuldugunu test edin
        WebElement emailKutusu= driver.findElement(By.xpath("//input[@id='email']"));
        ReusableMethods.bekle(2);
        actions.click(emailKutusu)
                .sendKeys("gunberkay@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("55222888444").perform();
        driver.findElement(By.xpath("//button[@id='submitlogin']"))
                .click();

        WebElement yaziTexti=driver.findElement(By.xpath("//h3[text()='Berkay']"));

        Assertions.assertTrue(yaziTexti.isDisplayed());


    }
}
