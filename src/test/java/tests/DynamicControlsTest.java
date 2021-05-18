package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

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
        WebElement checkboxExample = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        actions.click(checkboxExample).perform();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.tagName("//*[@id='checkbox']/input")).size();
        assertEquals(numberOfElements, 0, "Элемент отсутствует на странице");

        WebElement inputFrame = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        WebElement enableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        actions.click(enableButton).perform();


//        public void waitForInscription () {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(BOT_LOGO));
//            Wait<WebDriver> fluent = new FluentWait<>(driver)
//                    .withTimeout(Duration.ofSeconds(10))
//                    .pollingEvery(Duration.ofSeconds(5))
//                    .ignoring(NoSuchElementException.class);
//            WebElement foo = fluent.until(driver -> driver.findElement(By.id("foo")));
    }

}
