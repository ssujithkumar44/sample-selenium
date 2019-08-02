package test.java.aspxopencover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
    private final String url="http://localhost:4200";
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeTest
    public void openApplication(){
        System.setProperty("webdriver.chrome.driver","D:\\guil\\Automation\\driver\\one\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,30);
        driver.get(url);

    }
    @Test(priority = 1)
    public void clickOnButton() throws Exception {
        Assert.assertEquals("title",driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button"))));
        driver.findElement(By.xpath("//button")).click();
        Assert.assertEquals("Button Clicked",driver.findElement(By.xpath("//div")).toString());
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }


    @AfterTest
    public void cleanup()
    {
        driver.close();
        driver.quit();
    }

}
