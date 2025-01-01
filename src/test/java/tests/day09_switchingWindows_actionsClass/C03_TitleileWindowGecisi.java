package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C03_TitleileWindowGecisi extends TestBase_Each {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']"))
                .click();

        ReusableMethods.titleIleWindowGecisi(driver,"New Window");
        //● Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu test edin

        String expectedYeniWindowTitle="New Window";
        String actualTitle= driver.getTitle();

        Assertions.assertEquals(expectedYeniWindowTitle,actualTitle);

        //● Sayfadaki textin "New Window" olduğunu doğrulayın.
        WebElement sayfa2Text = driver.findElement(By.xpath("//h3[text()='New Window']"));
        String expectedText2 = "New Window";
        String actualTitle2 = sayfa2Text.getText();

        Assertions.assertEquals(expectedText2, actualTitle2);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu test edin
        ReusableMethods.titleIleWindowGecisi(driver,"The Internet");

        String expectedTitle="The Internet";
        String actualTitleInternet= driver.getTitle();

        Assertions.assertEquals(expectedYeniWindowTitle,actualTitleInternet);


    }

}
