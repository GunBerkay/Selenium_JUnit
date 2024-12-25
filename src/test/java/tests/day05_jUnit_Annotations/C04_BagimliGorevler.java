package tests.day05_jUnit_Annotations;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BagimliGorevler {

    WebDriver driver;

    // 3 farkli test method'u olusturup asagidaki gorevleri tamamlayin
    // 1- testotomasyonu anasayfaya gidip, url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip, arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, acilan sayfadaki urun isminde
    //    case sensitive olmadan "phone" bulundugunu test edin

    public void setup(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void teardown(){
        driver.quit();
    }



    @Test
    public void test01(){
        // 1- testotomasyonu anasayfaya gidip, url'in testotomasyonu icerdigini test edin




    }

    @Test
    public void test02(){
        // 2- phone icin arama yapip, arama sonucunda urun bulunabildigini test edin

    }

    @Test
    public void test03(){
        // 3- ilk urunu tiklayip, acilan sayfadaki urun isminde
        //    case sensitive olmadan "phone" bulundugunu test edin

    }











}
