import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HerokuappTest {

    @Test
    public void addRemoveElements(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement clickAddRemoveElements = driver.findElement(By.xpath("//a[@href='/add_remove_elements/']"));
        clickAddRemoveElements.click();

        WebElement clickAddElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        clickAddElement.click();
        clickAddElement.click();


        WebElement removeElement = driver.findElement(By.xpath("//div[@id='elements']/button"));
        removeElement.click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='elements']/button"));
        Assert.assertEquals(elements.size(),1);

        driver.quit();
    }

}