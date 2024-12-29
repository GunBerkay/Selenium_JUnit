package tests.Selenium_Practice.day01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class form_homework extends TestBase_Each {
    @Test
    public void demoqaformTesti() {
        driver.get("https://demoqa.com/automation-practice-form");
        Actions actions = new Actions(driver);
        //Locate almak yerine Actions Classindan TAB yaparak Webelementleri arasinda gecis yapabildim
        // Date of Birth bolumde DropDown menu oldugu icin Select classindan selec objesi olusturdum
        driver.findElement(By.xpath("//input[@id='firstName']"))
                // Name
                .sendKeys("Berkay");
                actions.sendKeys(Keys.TAB)
                // Last Name
               .sendKeys("Gun");
                actions.sendKeys(Keys.TAB)
               // Email
                .sendKeys("gunberkay@gmail.com").perform();
                // Gender
                driver.findElement(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[1]"))
                 .click();
                actions.sendKeys(Keys.TAB)
                // Mobile Number
                .sendKeys("12345678910");
                actions.sendKeys(Keys.TAB).perform();
                // Date of Birth
                // Dropdown menu oldugu icin Select objesi kullandim
                WebElement monthDdm= driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
                 Select select =new Select(monthDdm);
                 select.selectByVisibleText("March");

                 WebElement yearDdm=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
                 Select select1=new Select(yearDdm);
                 select1.selectByValue("1995");

                 driver.findElement(By.xpath("(//div[@tabindex='-1'])[6]"))
                  .click();
                 // Subjects
                   actions.sendKeys(Keys.TAB).sendKeys("English").sendKeys(Keys.ENTER).perform();
                   ReusableMethods.bekle(2);
                   // Hobbies checkBoxlarini sayfada ki reklam nedeniyle  goremedigi icin PAGE DOWN yaptim
                   actions.sendKeys(Keys.PAGE_DOWN).perform();
                   ReusableMethods.bekle(2);
                    // Hobbies
                    driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"))
                    .click();
                    driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"))
                    .click();
                    driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"))
                    .click();
                    actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                    // Current Address
                    .sendKeys("Turkey");
                     actions.sendKeys(Keys.TAB)
                     // State
                     .sendKeys("Haryana");
                     actions.sendKeys(Keys.ENTER).sendKeys(Keys.TAB)
                      // City
                      .sendKeys("Panipat");
                      actions.sendKeys(Keys.ENTER).perform();
                      // Submit button
                    driver.findElement(By.xpath("//button[@id='submit']"))
                    .click();

    }


}
