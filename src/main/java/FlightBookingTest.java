import com.sun.javafx.PlatformUtil;

import utilities.ApplicationUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest {

    WebDriver driver = new ChromeDriver();

	ApplicationUtilities utilties = new ApplicationUtilities(driver) ;
    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        driver.get("https://www.cleartrip.com/");
        utilties.clickElementBy(By.id("OneWay"));

        driver.findElement(By.id("FromTag")).clear();
        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");

        //wait for the auto complete options to appear for the origin

        utilties.waitFor(2000);
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        utilties.clickElementBy(originOptions.get(0));

        driver.findElement(By.id("toTag")).clear();
        driver.findElement(By.id("toTag")).sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination

        utilties.waitFor(2000);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        utilties.clickElementBy( destinationOptions.get(0));

        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

        //all fields filled in. Now click on search
        
        utilties.clickElementBy(By.id("SearchBtn"));

        utilties.waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(utilties.isElementPresent(By.className("searchSummary")));

    }




    

}
