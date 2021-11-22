import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HerokuappTest {

//    @Test
//    public void validEmail(){
//
//
//        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.sharelane.com/cgi-bin/register.py");
//
//        WebElement zipCodeInput = driver.findElement(By.xpath("//input[@name='zip_code']"));
//         zipCodeInput.sendKeys("12345");
//
//         WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
//         continueButton.click();
//
//         boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
//         Assert.assertEquals(isDisplayed,true);
//
//         WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='first_name']"));
//         firstNameInput.sendKeys("kristina");
//
//         WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='last_name']"));
//         lastNameInput.sendKeys("popowa");
//
//         WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
//         emailInput.sendKeys("popowa.kri2011yandex.ru");
//
//         WebElement password1Input = driver.findElement(By.xpath("//input[@name='password1']"));
//         password1Input.sendKeys("1111");
//
//         WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@name='password2']"));
//         confirmPasswordInput.sendKeys("1111");
//
//         WebElement registerButton = driver.findElement(By.xpath("//input[@value='Register']"));
//         driver.findElements();
//         registerButton.click();
//
//         boolean mistakeIsDisplayed2 = driver.findElement(By.xpath("//span[@class='error_message']")).isDisplayed();
//         Assert.assertEquals(mistakeIsDisplayed2,true);
//
//         driver.quit();

//}

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