import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Math.*;

public class AmazonSearch extends TestBase {
    //Create a new class: AmazonSearch
    //TC01_As user I want to know how many item are there on amazon in the first page after
    // I search “porcelain teapot”?
    //TC02_ Order the the tea pot prices, find the min, max, and average price to the nearest cent.


    @Test
    public void amazonSearch() {
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot");
        driver.findElement(By.id("nav-search-submit-button")).click();

        String result=driver.findElement(By.xpath("//*[@id='search']/span/div/h1/div/div[1]/div/div/span[1]")).getText();
        System.out.println("First Page Item Count :" + result);

        WebElement orderCombo=driver.findElement(By.id("s-result-sort-select"));
        Select select = new Select(orderCombo);
        select.selectByIndex(1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='s-pagination-strip']")));

        List<WebElement> webElements=driver.findElements(By.xpath("//span[@class='a-offscreen']"));  //normalde 60 civarı elemnt döndürmeli

        webElements.stream().forEach(item-> System.out.println(item.getAttribute("innerHTML")));


        List<Double> prices=webElements.stream().map(item->Double.parseDouble(item.getAttribute("innerHTML").replaceAll("[^0-9.]",""))).collect(Collectors.toList());

        Double minPrice=prices.stream().sorted().findFirst().get();
        System.out.println("Min Price : " + minPrice);

        Double maxPrice=prices.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("Max Price : " + maxPrice);

        Double avgPrice=prices.stream().mapToDouble(i->i).average().getAsDouble();
        System.out.println("Avg Price : " + avgPrice);

        //OR for Avg
        Double sumValue = prices.stream().mapToDouble(i->Double.valueOf(i)).sum();
        System.out.println("Avg Value = " + sumValue/prices.size());


    }
}
