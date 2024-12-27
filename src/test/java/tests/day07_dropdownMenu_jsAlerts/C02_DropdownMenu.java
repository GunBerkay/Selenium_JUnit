package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C02_DropdownMenu extends TestBase_Each {

    @Test
    public void test01(){

//        https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

//        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm= driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

//        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

//        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        select.getFirstSelectedOption().getText();

//        4.Tüm dropdown değerleri(value) yazdırın
        // 1.Yontem (sadece yazdirmak istend,g,nde kullanilabilir)
        System.out.println(ddm.getText());

        // 2. Yontem ( sadece yazdirmak degil , testler de yapmak istersek tercih edilir)
        List<String> optionYazilarList= ReusableMethods.stringListeDonustur(select.getOptions());

        System.out.println("Liste olarak options : " + optionYazilarList);

//        5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedBoyut = 4;
        int actualBoyut = optionYazilarList.size();

        Assertions.assertEquals(expectedBoyut,actualBoyut);

    }

}
