package tests.day11_waits_cookies;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class homework_1 extends TestBase_Each {

    @Test
    public void test01() {

        // Actions Class Homework

//        1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

//        2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);

        WebElement homfBox = driver.findElement(By.xpath("//button[text()='Hover Over Me Second!']"));
        actions.moveToElement(homfBox)
                .perform();

//        3. "Link 1" e tiklayin
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//div[2]//div[1]//a[1]"))
                .click();

//        4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

//        5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

//        6. "Click and hold" kutusuna basili tutun
        WebElement cahBox = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(cahBox)
                .perform();
        ReusableMethods.bekle(1);

//        7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(cahBox.getText());

//        8. "Double click me" butonunu cift tiklayin
        WebElement dcmButton = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(dcmButton)
                .perform();

    }

}
