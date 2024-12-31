package tests.day08_basicAuthentication_iFrame_windowGecis;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class homework extends TestBase_Each {

    @Test
    public void test01(){
//        1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
//        2) Cookies kabul edin
//        Cookies cikmadi
//        3) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Toplam iframe sayısı: " + iframes.size());
//        4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@title='Oynat']")).click();
//        5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
//        6) ikinci iframe'deki (Jmeter Made Easy) linke
//        (https://www.guru99.com/live-selenium-project.html) tıklayınız
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

    }

}
