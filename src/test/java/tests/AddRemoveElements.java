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

public class AddRemoveElements {
    @Test
    public void herokuAppAddRemoveElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int x = 0; x < 2; x++) {
            addElement.click();
        }
        WebElement deleteElement = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        deleteElement.click();

        List<WebElement> deleteElementsList = driver.findElements(By.xpath("//button[@OnClick='deleteElement()']"));
        int deleteElements = deleteElementsList.size();
        Assert.assertEquals(deleteElements, 1);
        driver.quit();
    }
}
