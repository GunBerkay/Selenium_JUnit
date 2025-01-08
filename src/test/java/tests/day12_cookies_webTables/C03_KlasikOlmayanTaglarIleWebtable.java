package tests.day12_cookies_webTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C03_KlasikOlmayanTaglarIleWebtable extends TestBase_Each {

    @Test
    public void test01(){

       // /*[@role='trow'][2]/*[@role='tdata'][3]

//        1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
//        2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikDataElementleriList=
                driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikDataElementleriList));

//        3. 3.sutunun basligini yazdirin
        System.out.println(baslikDataElementleriList.get(2).getText());

//        4. Tablodaki tum datalari yazdirin
        List<WebElement> tablodakiTumElementlerList=driver.findElements(By.xpath("/*[@role='trow']/*[@role='tdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(tablodakiTumElementlerList));

//        5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("tablodaki data sayisi : " + tablodakiTumElementlerList.size());

//        6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList=driver.findElements(By.xpath("/*[@role='trow']"));

        System.out.println("tablodaki satir sayisi : " + satirElementleriList.size() );

//        7. Tablodaki sutun sayisini yazdirin
        List<WebElement> birinciSatirDataElementleriList=driver.findElements(By.xpath("//*[@role='trow'][1]/*[@role='tdata']"));

        System.out.println("tablodaki sutun sayisi : " + birinciSatirDataElementleriList.size());

//        8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList=driver.findElements(By.xpath("/*[@role='trow'][*]/*[@role='tdata'][3]"));

        System.out.println(ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));

//        9. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

        // 10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        for (int i = 1; i <=5 ; i++) {
            String categoryXpath="//*[@role='trow'][" + i + "] / *[@role='tdata'][2]";
            String fiyatXpath = "//*[@role='trow'][" + i + "] / *[@role='tdata'][3]";

            String categoryDegeri = driver.findElement(By.xpath(categoryXpath))
                    .getText();
            if (categoryDegeri.equalsIgnoreCase("Furniture")){

                String fiyatStr = driver.findElement(By.xpath(fiyatXpath))
                        .getText();

                System.out.println(fiyatStr);
            }
        }

    }





    public String getCellData(int satirno, int sutunno){

        String dinamikXpath="//*[@role='trow'][" + satirno + "]/*[@role='tdata'][" + sutunno + "]";

        WebElement hedefElement=driver.findElement(By.xpath(dinamikXpath));

          return hedefElement.getText();

    }


}
