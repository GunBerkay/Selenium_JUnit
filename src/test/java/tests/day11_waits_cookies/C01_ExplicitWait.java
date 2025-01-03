package tests.day11_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase_Each;

import java.time.Duration;

public class C01_ExplicitWait  {
    WebDriver driver;

    @Test
    public void implictlyWaitTesti() throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//            1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");
//            2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi= driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textboxElementi.isEnabled());
//             3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[.='Enable']"))
                .click();
        Thread.sleep(3000);
//             4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textboxElementi.isEnabled());
//            5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi= driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());
    }

    @Test
    public void explictlyWaitTesti(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
       // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");
//            2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi= driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textboxElementi.isEnabled());
//             3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[.='Enable']"))
                .click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textboxElementi));

//             4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textboxElementi.isEnabled());
//            5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi= driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

    }

}
