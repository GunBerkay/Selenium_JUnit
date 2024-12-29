package tests.Selenium_Practice.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_firstClass {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.wisequarter.com/");
        driver.quit();


    }


}
