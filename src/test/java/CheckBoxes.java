import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes {

    @Test
    public void checkBoxes(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement clickCheckBoxesButton = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        clickCheckBoxesButton.click();

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox' and not(@checked)]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox' and (@checked)]"));

        Assert.assertEquals(checkBox1.isSelected(),false);
        checkBox1.click();
        Assert.assertEquals(checkBox1.isSelected(), true);

        Assert.assertEquals(checkBox2.isSelected(),true);
        checkBox2.click();
        Assert.assertEquals(checkBox2.isSelected(), false);

        driver.quit();
    }
}
