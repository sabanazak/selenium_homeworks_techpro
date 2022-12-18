import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest extends BaseProcesses  {
    /*
        Create a new class : GoogleSearchTest
        Create main method and complete the following task.
        >	When user goes to https:// www.google.com/
        >	Search for "porcelain teapot"
        >	And print how many related results displayed on Google


        Then create 3 different test methods using the following names. And Go to google.
            -titleTest =>Verify if google title = "Google"
            -imageTest => Verify if google image displays or not
            -gmailLinkTest => Verify if the Gmail link is displayed or not
        Close the browser after each test
     */

/*    public static void main(String[] args)  {
        // Set Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //When user goes to https:// www.google.com/
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Search for "porcelain teapot"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("porcelain teapot");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBox.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //And print how many related results displayed on Google
        WebElement result=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(result.getText());

        driver.quit();
    }*/

    @Test
    public void titleTest() {
        //Verify if google title = "Google"
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");

        Assert.assertEquals("Google", driver.getTitle());


    }
    @Test
    public void imageTest() {
        //Verify if google image displays or not
        driver.get("https://www.google.com/");
        WebElement element_id=driver.findElement(By.id("hplogo"));
        WebElement element_css=driver.findElement(By.cssSelector("img[id='hplogo']"));
        WebElement element_css2=driver.findElement(By.cssSelector("img#hplogo"));
        WebElement element_xpath=driver.findElement(By.xpath("//img[@id='hplogo']"));
        Assert.assertTrue(element_id.isDisplayed());
        Assert.assertTrue(element_css.isDisplayed());
        Assert.assertTrue(element_css2.isDisplayed());
        Assert.assertTrue(element_xpath.isDisplayed());

    }
    @Test
    public void gmailLinkTest() {
        //Verify if the Gmail link is displayed or not
        driver.get("https://www.google.com/");
        WebElement element=driver.findElement(By.xpath("//a[@data-pid='23']"));
        Assert.assertEquals("Gmail", element.getText());
    }

    @Test
    public void linkTest() {
        driver.get("https://www.google.com/");
        List<WebElement> elements=driver.findElements(By.tagName("a"));

        for(WebElement element:elements) {
            System.out.println("Element Text :" + element.getText());
        }

    }

}
