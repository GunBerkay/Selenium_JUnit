package tests.day14_getScreenshot_jsExecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import utilities.TestBase_Each;

public class C04_JavaxcriptExecutor extends TestBase_Each {

    @Test
    public void test01(){

        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        // isitme kaybi checkbox gorunecek kadar asagi inin
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        WebElement isitmekaybiCheckBox=driver.findElement(By.id("hastalikCheck5"));

        jse.executeScript("arguments[0].scrollIntoView(true);",isitmekaybiCheckBox);

        // jse kullanarak isitme kaybi checkbox'i isaretleyin

        // javascript Alert kullanarak "JUnit BITTTIIIII" yazdirin



    }


}
