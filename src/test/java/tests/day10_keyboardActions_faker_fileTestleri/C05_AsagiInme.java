package tests.day10_keyboardActions_faker_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_AsagiInme extends TestBase_Each {

    @Test
    public void test01(){
//        1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

//        2- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
//        3- videoyu izlemek icin Play tusuna basin
        WebElement videoIframe=driver.findElement(By.xpath("(//iframe)[1]"));

        driver.switchTo().frame(videoIframe);

        driver.findElement(By.xpath("//button[@aria-label='Oynat']"))
                .click();

//        4- videoyu calistirdiginizi test edin
        ReusableMethods.bekle(2);
        WebElement videoYoutubeLogo= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assertions.assertTrue(videoYoutubeLogo.isDisplayed());


    }
}
