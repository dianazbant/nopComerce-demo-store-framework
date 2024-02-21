package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class JewerlyProductsTest {

    public WebDriver driver;

    @Test
    public void metodatest(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //Search for jewerly menu element
        // Add to cart a jewerly
        //Use email a friend feature
        WebElement jewerlyelement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a"));
        jewerlyelement.click();

        WebElement jewerlypictureelement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a/img"));
        jewerlypictureelement.click();

        WebElement addtocartbutton = driver.findElement(By.id("add-to-cart-button-42"));
        addtocartbutton.click();

        WebElement emailafriendbutton = driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[8]/div[3]/button"));
        emailafriendbutton.click();

        WebElement friendsemailelement = driver.findElement(By.id("FriendEmail"));
        friendsemailelement.sendKeys("sandabor@gmail.com");

        WebElement youremailelement = driver.findElement(By.id("YourEmailAddress"));
        youremailelement.sendKeys("antonandrei@gmail.com");

        WebElement messageelement = driver.findElement(By.id("PersonalMessage"));
        messageelement.sendKeys("Look how beautiful is this jewerly!");

        WebElement sendbutton = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button"));
        sendbutton.click();

        WebElement errorElement=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]"));
        String expectederror="Only registered customers can use email a friend feature";
        String actualerror=errorElement.getText();
        Assert.assertEquals(actualerror,expectederror);

        driver.quit();
    }

}
