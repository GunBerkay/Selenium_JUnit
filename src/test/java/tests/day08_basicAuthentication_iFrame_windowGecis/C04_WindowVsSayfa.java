package tests.day08_basicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C04_WindowVsSayfa extends TestBase_Each {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidin
        // url'i ve windowHandle degerini yazdirin
        driver.get("https://testotomasyonu.com/");
        System.out.println("Testotomasyonu.com Url : " + driver.getCurrentUrl());
        System.out.println("Testotomasyonu.com windowHandle :" + driver.getWindowHandle());

        // electronics linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        // url'i ve windowHandle degerini yazdirin
        System.out.println("electronics url : " + driver.getCurrentUrl());
        System.out.println("electronics windowHandle :" + driver.getWindowHandle());

         // ilk urunu tiklayin
        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]")).click();
         // url'i ve windowHandle degerini yazdirin
        System.out.println("ilk urun url : " + driver.getCurrentUrl());
        System.out.println("ilk urun windowHnadle : " + driver.getWindowHandle());

         // acount butonuna basin
        driver.findElement(By.xpath("(//a[@class='e-cart'])[1]")).click();
        // url'i ve windowHandle degerini yazdirin
        System.out.println("accoun url : " + driver.getCurrentUrl());
        System.out.println("account windowHandle : " + driver.getWindowHandle());

    }
}
