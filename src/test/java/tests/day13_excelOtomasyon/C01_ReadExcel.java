package tests.day13_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {
//        Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu="src/test/java/tests/day13_excelOtomasyon/ulkeler (3).xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1= workbook.getSheet("Sayfa1");

//        - 1.satirdaki 2.hucreye gidelim ve yazdirin
        Row row1= sayfa1.getRow(1);
        Cell hucre2= row1.getCell(2);
        System.out.println("1.satirdaki 2.hucre : " + hucre2);

        System.out.println(sayfa1.getRow(0).getCell(1));

//        - 1.satirdaki 2.hucreyi bir string degiskene atayin ve degerinin “Başkent (İngilizce)” oldugunu test edin
        String actualData =sayfa1.getRow(0).getCell(1).getStringCellValue();
        String expectedData="Başkent (İngilizce)";
        Assertions.assertEquals(expectedData,actualData);

//        - 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
        expectedData="Kabil";
        actualData=sayfa1.getRow(1).getCell(3).getStringCellValue();
        Assertions.assertEquals(expectedData,actualData);

//                - Ulke sayisinin 190 oldugunu test edin
        int expectedUlkeSayisi= 190;
        int actualUlkeSayisi=sayfa1.getLastRowNum() + 1 -1;

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

//      - Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        int expectedKullanilanSatirSayisi=191;
        int actualKullanilanSatirSayisi=sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);

//       - Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {
            String satirdakiIngilizceUlkdeIsmi=sayfa1.getRow(i).getCell(0).getStringCellValue();

            if (satirdakiIngilizceUlkdeIsmi.equals("Netherlands")){
                String satirdakiTurkceBaskentIsmi=sayfa1.getRow(i).getCell(3).getStringCellValue();
                Assertions.assertEquals(satirdakiTurkceBaskentIsmi,"Amsterdam");
                break;
            }
        }

//       - Turkce baskent isimlerinde Ankara bulundugunu test edin
        boolean ankaraVarMi=false;
        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {
            String satirdakiTurkceBaskentIsmi=sayfa1.getRow(i).getCell(3).getStringCellValue();

            if (satirdakiTurkceBaskentIsmi.equalsIgnoreCase("Ankara")){
                ankaraVarMi=true;
                break;
            }
        }
        Assertions.assertTrue(ankaraVarMi);


    }
}
