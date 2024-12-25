package tests.day05_jUnit_Annotations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeEach_AfterEach {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testotomasyonuTesti(){
        // 3 farkli method olusturup asagidaki gorevleri yapin
        // 1- testotomasyonu sayfasina gidin ve url'in testotomasyonu icerdigini test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik="testotomayonu";
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu testi PASSED");
        }else System.out.println("Testotomasyonu testi FAILED");

    }

    @Test
    public void youtubeTesti(){
        // 2- youtube ana sayfaya gidin ve Title'in YouTube oldugunu test edin
        driver.get("https://www.youtube.com");

        String expectedTitle="Youtube";
        String actualTitle= driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");


    }

    @Test
    public void wisequarterTesti(){
        // 3- wisequarter anasayfaya gidin ve Title'in case sensitive olmadan wisequarter icerdigini test edin
        driver.get("https://www.wisequarter.com");

        String expectedTitleIcerik="wisequarter";
        String actualTitle= driver.getTitle().toLowerCase();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else System.out.println("Wisequarter testi FAILED");

    }










}
