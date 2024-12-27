package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C01_DropdownMenu extends TestBase_Each {


    @Test
    public void dropdownmenuTesti(){

//        ● https://testotomasyonu.com/form adresine gidin.
        driver.get("ttps://testotomasyonu.com/form");
//        1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement gunDdm= driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectGun=new Select(gunDdm);
        selectGun.selectByIndex(5);

//        2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDdm= driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy=new Select(ayDdm);
        selectAy.selectByValue("nisan");

//        3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm= driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil=new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

//        4. Secilen değerleri konsolda yazdirin
        System.out.println("Gun : " + selectGun.getFirstSelectedOption().getText());
        System.out.println("Ay : " + selectAy.getFirstSelectedOption().getText());
        System.out.println("Yil : " + selectYil.getFirstSelectedOption().getText());

//        5. Ay dropdown menüdeki tum değerleri(value) yazdırın

        //System.out.println(ayDdm.getText());

         List<WebElement> ayDdmOptionElementleriList = selectAy.getOptions();
         for (WebElement each:ayDdmOptionElementleriList){
             System.out.println(each.getText());
         }

         // ay dropdown menusunde mart kelimesinin gecmedigini test edin

        // 1. Alternatif :
//        boolean martVarMi= false;
//         for (WebElement each:ayDdmOptionElementleriList){
//             if (each.getText().equals("mart")){
//                 martVarMi=true;
//             }
//         }
//             Assertions.assertFalse(martVarMi);

         // 2. Yontem : ******** DAHA KULLANISLI YONTEM ********
        List<String> ddmOptionsStringList=new ArrayList<>();

                for(WebElement each:ayDdmOptionElementleriList){
                    ddmOptionsStringList.add(each.getText());
                }
                Assertions.assertFalse(ddmOptionsStringList.contains("mart"));


//        6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedDdmBoyutu=13;
        int actualDdmBoyutu=ayDdmOptionElementleriList.size();

        Assertions.assertEquals(expectedDdmBoyutu,actualDdmBoyutu);


        ReusableMethods.bekle(2);


    }





}
