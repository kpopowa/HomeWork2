import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls {

    @Test
    public void dynamicControls(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement clickInputsButton = driver.findElement(By.xpath("//a[@href='/dynamic_controls']"));
        clickInputsButton.click();

        WebElement checkboxesRemoveButton = driver.findElement(By.xpath("//button[@autocomplete='off']"));
        checkboxesRemoveButton.click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("message")));

        WebElement disabledInput = driver.findElement(By.xpath("//form[@id='input-example']/input[@type='text']"));
        Assert.assertEquals(disabledInput.isEnabled(), false);

        WebElement clickEnableButton = driver.findElement(By.xpath("//form[@id='input-example']/button[@type='button']"));
        clickEnableButton.click();

        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/p[@id='message']")));

        WebElement enabledInput = driver.findElement(By.xpath("//form[@id='input-example']/p[@id='message']"));
        Assert.assertEquals(enabledInput.isEnabled(), true);

        driver.quit();
    }
}
