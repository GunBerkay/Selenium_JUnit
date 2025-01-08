package tests.day12_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.sql.Driver;
import java.util.List;

public class C02_KlasikTabloTaglariIleWetable extends TestBase_Each {

    @Test
    public void test01(){

//        1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

//        2.Web table tum body’sini yazdirin
        WebElement tunBodyElementi= driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum table body : \n" + tunBodyElementi.getText());

        System.out.println("====================");

//        3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTabloBodyIcerik="Comfortable Gaming Chai";
        String actualTumBody=tunBodyElementi.getText();

        Assertions.assertTrue(actualTumBody.contains(expectedTabloBodyIcerik));

//        4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriList=driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi=5;
        int actualSatirSayisi=satirElementleriList.size();

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

//        5. Tum satirlari yazdirin
        System.out.println(ReusableMethods.stringListeDonustur(satirElementleriList));

        // daha guzel gorunmesi icin satir satir yazdıralim
        for (int i = 0; i < satirElementleriList.size(); i++) {
            System.out.println(1+i+" . satir : \n" + satirElementleriList.get(i).getText());

        }

//        6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> birinciSatirDataElementleriList=driver.findElements(By.xpath("/tbody/tr[1]/td"));

        int expectedSutunSayisi=4;
        int actualBirinciSatirdakiDataSayisi= birinciSatirDataElementleriList.size();

        Assertions.assertEquals(expectedSutunSayisi,actualBirinciSatirdakiDataSayisi);

//        7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleriList=driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));

        System.out.println(ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));

//        8. Tablodaki basliklari yazdirin
        WebElement headerSatirElementi=driver.findElement(By.xpath("//thead/tr"));
        System.out.println(headerSatirElementi.getText());

        List<WebElement> baslikDataElementleriList=driver.findElements(By.xpath("//thead/tr/th"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikDataElementleriList));


//        9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(getCellData(1, 2));
        System.out.println(getCellData(2, 3));
        System.out.println(getCellData(3, 2));

//        10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedDeger="Furniture";
        String actualDeger=getCellData(4,2);

        Assertions.assertEquals(expectedDeger,actualDeger);
//
    }


    public String getCellData(int satirNo,int sutunNo){
        String dinamikXpath="//tbody/tr[" + satirNo + "]/td[" +sutunNo + "]";

        WebElement hedefCellElementi= driver.findElement(By.xpath(dinamikXpath));
        return hedefCellElementi.getText();
    }

}
