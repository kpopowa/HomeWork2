import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frames {

    @Test
    public void frames(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement clickFramesButton = driver.findElement(By.xpath("//a[@href='/frames']"));
        clickFramesButton.click();

        WebElement clickIframessButton = driver.findElement(By.xpath("//a[@href='/iframe']"));
        clickIframessButton.click();

        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@id='mce_0_ifr']")));

        WebElement iFrame= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);

        WebElement iFrameText = driver.findElement(By.xpath("//p"));


        Assert.assertEquals(iFrameText.getText(), "Your content goes here.");

        driver.quit();
    }
}
