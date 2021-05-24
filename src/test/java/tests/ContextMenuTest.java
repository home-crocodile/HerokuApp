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

public class ContextMenuTest {
    @Test
    public void herokuAppContextMenuTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement contextMenu = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(contextMenu).perform();
        WebElement alertMenu = driver.findElement(By.xpath("//*[@id='content']/script"));
        Assert.assertEquals(alertMenu, "You selected a context menu");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.quit();
    }
}
