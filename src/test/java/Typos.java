

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Typos {
    @Test
    public void typosTest(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement clickAddRemoveElements = driver.findElement(By.xpath("//a[@href='/typos']"));
        clickAddRemoveElements.click();


        String expectedMessage = "Sometimes you'll see a typo, other times you won't.";
        String message = driver.findElements(By.xpath("//p")).get(1).getText();
        Assert.assertTrue(message.contains(expectedMessage));

        driver.quit();
//

    }



}
