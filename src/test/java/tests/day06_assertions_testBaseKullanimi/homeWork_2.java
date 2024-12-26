package tests.day06_assertions_testBaseKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class homeWork_2 extends TestBase_All {

//    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Test
    public void chexboxTesti() throws InterruptedException {
        //    a. Verilen web sayfasına gidin.
//    https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //    b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement chexkbox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement chexkbox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //    c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!chexkbox1.isSelected()){
            chexkbox1.click();
        }
        Thread.sleep(2000);

        //    d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!chexkbox2.isSelected()){
            chexkbox2.click();
        }
        Thread.sleep(2000);

        //    e. Checkbox1 ve Checkbox2’nin seçili olduğunu test edin
        Assertions.assertTrue(chexkbox1.isSelected());
        Assertions.assertTrue(chexkbox2.isSelected());


    }









}
