package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme yapilamadi");
        }
    }

    public static List<String> stringListeDonustur(List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();
        for (WebElement each: webElementList){
            stringList.add(each.getText());
        }
        return stringList;
    }

    public static void titleIleWindowGecisi(WebDriver driver,String hedefWindowTitle){
        Set<String> acikWindowWhdSeti=driver.getWindowHandles();

        for (String eachWhd:acikWindowWhdSeti){
            driver.switchTo().window(eachWhd);
            if (driver.getTitle().equals(hedefWindowTitle)){
                break;
            }
        }
    }

    public static void urlIleWindowGecisi(WebDriver driver,String hedefWindowUrl){

        // 1- acik tum window'larin whd'lerini kaydedelim
        Set<String> acikTumWindowlarinWhdSeti = driver.getWindowHandles();

        for (String eachWhd : acikTumWindowlarinWhdSeti){

            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefWindowUrl)){
                break;
            }
        }
    }

    public static void tumSayfaScreenshot(WebDriver driver){
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi= ldt.format(formatter);

        //1.ADIM
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        //2.ADIM
        File asilResim=new File("target/screenshots/tumSayfaScreenshot " + tarihEtiketi + ".jpg");

        //3.ADIM
        File geciciResim=takesScreenshot.getScreenshotAs(OutputType.FILE);

        //4.ADIM
        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }


    }

    public static void isimliTumSayfaScreenshot(WebDriver driver,String resimIsmi){
        //1.ADIM
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        //2.ADIM
        File asilResim=new File("target/screenshots/" + resimIsmi + ".jpg");

        //3.ADIM
        File geciciResim=takesScreenshot.getScreenshotAs(OutputType.FILE);

        //4.ADIM
        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }


    }

    public static void webElementScreenshoot(WebElement hedefElement){
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi= ldt.format(formatter);

        // 1.ADIM
        // 2.ADIM
        File asilResim=new File("target/screenshots/webelementScreenshot" + tarihEtiketi +".jpg");
        // 3.ADIM
        File geciciResim = hedefElement.getScreenshotAs(OutputType.FILE);
        // 4.ADIM
        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }

    }


}
