import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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

        List<WebElement> allElements = driver.findElements(By.xpath("//select/option"));
        Assert.assertEquals(allElements.size(), 3);

        WebElement choseOptionButton = driver.findElement(By.xpath("//select[@id='dropdown']"));
        choseOptionButton.click();

        WebElement testDropDown = driver.findElement(By.xpath("//select"));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(1);

        WebElement option1IsSelected = driver.findElement(By.xpath("//select/option [@value='1' and (@selected)]"));
        Assert.assertEquals(option1IsSelected.isDisplayed(),true);

        dropdown.selectByIndex(2);

        WebElement option2IsSelected = driver.findElement(By.xpath("//select/option [@value='2' and (@selected)]"));
        Assert.assertEquals(option2IsSelected.isDisplayed(),true);

        driver.quit();

    }

}
