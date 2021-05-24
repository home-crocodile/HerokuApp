package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HerokuAppTest {

    @Test
    public void herokuAppTest (){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputFiled = driver.findElement(By.xpath("//*[@type='number']"));

        inputFiled.sendKeys("20");
        String actualText = inputFiled.getAttribute("value");
        Assert.assertEquals(actualText, "20");
        inputFiled.sendKeys(Keys.ARROW_UP);
        actualText = inputFiled.getAttribute("value");
        Assert.assertEquals(actualText, "21");

        driver.quit();

    }
}
