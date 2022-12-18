import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonDropdown extends BaseProcesses {
    /*
        Create A Class: AmazonDropdown
        Create A Method dropdownTest
     */


    @Test
    public void dropdownTest() throws InterruptedException {
        //Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //Print the first selected option and assert if it equals “All Departments”.
        // If it fails, then comment that code out and continue rest of the test case.
        Select select=new Select(dropdown2);
        String selectedOption=select.getFirstSelectedOption().getText();
        System.out.println("First Selected Option : " + selectedOption);
        String expedtedSelectedOption="All Departments";
        Assert.assertEquals("Actual data does not match expected data",expedtedSelectedOption,selectedOption);


        //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        select.selectByIndex(3);
        Thread.sleep(2000);
        selectedOption=select.getFirstSelectedOption().getText();
        System.out.println("First Selected Option : " + selectedOption);
        expedtedSelectedOption="Amazon Devices";
        //Assert.assertEquals("Actual data does not match expected data",expedtedSelectedOption,selectedOption);

        //Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> allOptions=select.getOptions();
        allOptions.stream().forEach(item-> System.out.println(item.getText()));

        //Print the the total number of options in the dropdown
        System.out.println("Total number of options in the dropdown : " + select.getOptions().size());

        //Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        boolean isAnOption=false;
        for (WebElement option:allOptions){
            if(option.getText().equals("Electronics")) {
                isAnOption=true;
                break;
            }
        }
        Assert.assertTrue("Can Not Find Option : Appliances",isAnOption);

        //BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> textsListOfDropdown = new ArrayList<>();
        for (WebElement option : allOptions) {
            textsListOfDropdown.add(option.getText());
        }
        System.out.println("Original List Texts:" + textsListOfDropdown);

        List<String> tempList = new ArrayList<>(textsListOfDropdown);
        Collections.sort(tempList);

        System.out.println("temp List Texts :" + tempList);

        Assert.assertTrue("Option List in not in Alphabetical Order",textsListOfDropdown.equals(tempList));
        Assert.assertEquals(tempList,textsListOfDropdown);



    }

}
