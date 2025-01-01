package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;

public class Homework_3 extends TestBase_Each {
    @Test
    public void test01(){
//        1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//        2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverButton= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverButton)
                .perform();
//        3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]"))
                .click();
//        4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
//        5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//        6- “Click and hold" kutusuna basili tutun
        WebElement clickBox= driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickBox)
                .perform();
//        7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickBox.getText());
//        8- “Double click me" butonunu cift tiklayin
        WebElement dcmButton= driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(dcmButton).perform();

    }
}
