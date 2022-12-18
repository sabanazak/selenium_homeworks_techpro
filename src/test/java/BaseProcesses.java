import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseProcesses {

    protected static WebDriver driver;
    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver","./src/resources/driver/chromedriver.exe");
        //driver=new ChromeDriver();
        //comment
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearIt() {
        driver.quit();
    }


}
