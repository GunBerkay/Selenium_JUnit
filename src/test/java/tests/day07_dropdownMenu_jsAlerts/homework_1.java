package tests.day07_dropdownMenu_jsAlerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_Each;

public class homework_1 extends TestBase_Each {

    @Test
    public void test(){
//        1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

//        2. Sign in butonuna basin
        driver.findElement(By.xpath("//i[@class='icon-signin']"))
                .click();

//        3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']"))
                .sendKeys("username");

//        4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']"))
                .sendKeys("password");

//        5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//input[@type='submit']"))
                .click();
        driver.navigate().back();

//        6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@id='online-banking']"))
                .click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']"))
                .click();

//        7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']"))
                .click();

//        8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDdm= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select =new Select(currencyDdm);
        select.selectByValue("EUR");

//        9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']"))
                .sendKeys("50");

//        10. “US Dollars” in secilmedigini test edin
        WebElement radioDollars= driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assertions.assertFalse(radioDollars.isSelected());

//        11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']"))
                .click();

//        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']"))
                .click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']"))
                .click();

//        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
//        kontrol edin.
        WebElement actualtext= driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']"));
        Assertions.assertTrue(actualtext.isDisplayed());

    }



}
