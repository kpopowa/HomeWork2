import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown {

    @Test
    public void dropDown() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement clickDropDownButton = driver.findElement(By.xpath("//a[@href='/dropdown']"));
        clickDropDownButton.click();

        List<WebElement> allElements = driver.findElements(By.xpath("//select"));
        Assert.assertEquals(allElements.size(), 2);

        WebElement choseOptionButton = driver.findElement(By.xpath("//select[@id='dropdown']"));
        choseOptionButton.click();

    }
}
