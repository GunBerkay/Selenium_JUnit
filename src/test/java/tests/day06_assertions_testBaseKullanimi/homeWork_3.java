package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_All;

public class homeWork_3 extends TestBase_All {

    Actions actions=new Actions(driver);

    @Test
    public void facebookTest() throws InterruptedException {
        //    a. Verilen web sayfasına gidin.
        //    https://facebook.com
        driver.get("https://facebook.com");

        //    c. Create an account buton’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // Name,Lastname,Doğum Tarihi,Email,Password bilgilerini girin ve Kaydol butonuna basin.
        WebElement nameText=driver.findElement(By.xpath("//input[@name='firstname']"));
        nameText.sendKeys("Berkay");
        WebElement lastnameText=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastnameText.sendKeys("Gun");

        WebElement selectDay= driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select select=new Select(selectDay);
        select.selectByIndex(2);

        WebElement selectMonth= driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select select1=new Select(selectMonth);
        select1.selectByVisibleText("Mar");

        WebElement selectYear= driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select select2=new Select(selectYear);
        select2.selectByValue("1995");

        WebElement emailText= driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        emailText.sendKeys("gunberkay@gmail.com");

        WebElement passwordText= driver.findElement(By.xpath("//input[@type='password']"));
        passwordText.sendKeys("12345678");

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //    d. Radio button elementlerini locate edin ve size
        //    uygun olani secin
        WebElement erkekRadioButton= driver.findElement(By.xpath("(//input[@id='sex'])[2]"));
        WebElement kadinRadioButton= driver.findElement(By.xpath("(//input[@id='sex'])[1]"));
        WebElement ozelRadioButton= driver.findElement(By.xpath("(//input[@id='sex'])[3]"));
        erkekRadioButton.click();
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //    e. Sectiginiz radio button’un seçili, ötekilerin seçili
        //    olmadigini test edin
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertFalse(ozelRadioButton.isSelected());

    }

}
