package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class C03_HtmlAlerts extends TestBase_Each {

    @Test
    public void htmlAlertTesti() {

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // cookies cikarsa kabul edin

        // Title'in YouTube oldugunu test edin
        String expectedTitle="Youtube";
        String actualTitle= driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

    }


}
