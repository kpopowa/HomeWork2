import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu {

    @Test
    public void ContextMenu(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement clickContextMenuButton = driver.findElement(By.xpath("//a[@href='/context_menu']"));
        clickContextMenuButton.click();

        Actions action = new Actions(driver);
        WebElement link = driver.findElement(By.id("hot-spot"));
        action.contextClick(link).perform();

        Alert alert = driver.switchTo().alert();
        alert.getText();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();

    }
}
