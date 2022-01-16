import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {

    @Test
    public void fileUpload(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement clickFileUploadButton = driver.findElement(By.xpath("//a[@href='/upload']"));
        clickFileUploadButton.click();

        WebElement clickUploadButton = driver.findElement(By.xpath("//input[@class='button']"));
        clickUploadButton.click();




//        WebElement inputUpDown = driver.findElement(By.xpath("//input[@type='number']"));
//        inputUpDown.sendKeys(Keys.UP);
//
//        Assert.assertEquals(inputUpDown.getAttribute("value"),"1");
//
//        inputUpDown.sendKeys(Keys.DOWN);
//        inputUpDown.sendKeys(Keys.DOWN);
//
//        Assert.assertEquals(inputUpDown.getAttribute("value"),"-1");

        driver.quit();
    }
}
