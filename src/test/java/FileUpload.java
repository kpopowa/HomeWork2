import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        WebElement clickChooseFileButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
        clickChooseFileButton.sendKeys("/Users/kristinapopova/Downloads/chromedriver");

        WebElement clickUploadButton = driver.findElement(By.id("file-submit"));
        clickUploadButton.click();

        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(By.id("uploaded-files")));

        WebElement uploadedFileText = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFileText.getText(), "chromedriver");

        driver.quit();
    }
}
