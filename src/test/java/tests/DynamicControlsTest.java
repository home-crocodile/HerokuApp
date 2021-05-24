package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DynamicControlsTest {
    @Test
    public void herokuAppDinamicControlTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox']/input"));
        actions.click(checkBox).perform();
        Assert.assertTrue(checkBox.isSelected(), "чекбокс на месте, кликнут");
        WebElement checkboxExample = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        actions.click(checkboxExample).perform();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement inscriptionGone = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertEquals(inscriptionGone, "It's gone!");
        Assert.assertTrue(checkBox.isEnabled(), "чекбокса нет");


        WebElement inputFrame = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        Assert.assertTrue(inputFrame.isEnabled(), "поле ввода не активно");
        WebElement inputExample = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        actions.click(inputExample).perform();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement inscriptionEnabled = driver.findElement(By.xpath("//*[@id='content']/script[2]/text()"));
        Assert.assertEquals(inscriptionEnabled, "It's enabled!");
        Assert.assertTrue(inputFrame.isDisplayed(), "поле ввода активно");

    }

}
