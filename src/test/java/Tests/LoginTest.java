package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class LoginTest {

    public WebDriver driver;

   @Test
  public void metodatest() {
       driver = new ChromeDriver();
       driver.get("https://demo.nopcommerce.com/");
       driver.manage().window().maximize();

       WebElement loginelement = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
       loginelement.click();

       WebElement emailelement = driver.findElement(By.id("Email"));
       emailelement.sendKeys("cozmaalina@gmail.com");

       WebElement passwordelement = driver.findElement(By.id("Password"));
       passwordelement.sendKeys("1324547546");

       WebElement errorElement=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));
       String expectedmessage="Returning Customer";
       String actualmessage=errorElement.getText();
       Assert.assertEquals(actualmessage,expectedmessage);

       WebElement loginbutton=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
       loginbutton.click();

        errorElement=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));
       String expectederror="Login was unsuccessful. Please correct the errors and try again.\n" +
               "No customer account found";
       String actualerror=errorElement.getText();
       Assert.assertEquals(actualerror,expectederror);

       driver.quit();
   }

}
