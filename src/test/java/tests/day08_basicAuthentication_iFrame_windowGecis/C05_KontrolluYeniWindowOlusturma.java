package tests.day08_basicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase_Each;

public class C05_KontrolluYeniWindowOlusturma extends TestBase_Each {

    @Test
    public void test01(){
        // Testotomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com/");
        // url'i ve windowHandle degerini yazdirin
        System.out.println("Testotomasyonu Url : " + driver.getCurrentUrl());
        System.out.println("Testotomasyonu windowHandle :" + driver.getWindowHandle());
        String testotomasyonuWhd= driver.getWindowHandle();
        // Yeni bir tab acarak wiseqouarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com/");
        // url'i ve windowHandle degerini yazdirin
        System.out.println("wiseqouarter Url : " + driver.getCurrentUrl());
        System.out.println("wiseqouarter windowHandle :" + driver.getWindowHandle());
        String wisequarterWhd= driver.getWindowHandle();

        // yeni bir window acarak youtube anasayfaya gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://youtube.com/");
        System.out.println("youtube Url : " + driver.getCurrentUrl());
        System.out.println("youtube windowHandle :" + driver.getWindowHandle());
        String youtubetWhd= driver.getWindowHandle();

        driver.switchTo().window(testotomasyonuWhd);
        String expectesUrlIcerik="testotomasyonu";
        String actualUrl= driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectesUrlIcerik));

        driver.switchTo().window(wisequarterWhd);
        String expectesUrl="wisequarter";
        String actualUrlwise= driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlwise.contains(expectesUrl));




    }



}
