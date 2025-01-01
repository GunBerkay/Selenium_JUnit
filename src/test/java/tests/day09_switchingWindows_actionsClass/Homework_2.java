package tests.day09_switchingWindows_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_Each;

public class Homework_2 extends TestBase_Each {
    @Test
    public void test02() {
//        1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
//        2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);

        WebElement dragmeButton = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drophereButton = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(dragmeButton, drophereButton).perform();

//        3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedElement = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String actualText = droppedElement.getText();
        String expectedText = "Dropped!";

        Assertions.assertEquals(expectedText, actualText);

    }
}
