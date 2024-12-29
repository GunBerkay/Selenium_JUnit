package tests.Selenium_Practice.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03_driverMethods {

     /*
  /....Exercise-1:...
  +Create a chrome driver
  +Maximize window
  +Open google home page https://www.google.com
  +On the same class, navigate to amazon home page https://www.amazon.com
   and navigate back to google
  +Wait about 4 sn
  +Navigate forward to amazon
  +Refresh page
  +quit the browser
  And Last step print "All is well" on console
*/
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.wisequarter.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
        System.out.println("All is well");

    }

}
