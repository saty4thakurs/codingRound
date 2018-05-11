import com.sun.javafx.PlatformUtil;

import utilities.ApplicationUtilities;
import utilities.BaseDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseDriver {

	ApplicationUtilities utilties = new ApplicationUtilities(driver) ;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@Test
	public void shouldBeAbleToSearchForHotels() {

		driver.get("https://www.cleartrip.com/");
		utilties.clickElementBy(hotelLink);

		localityTextBox.sendKeys("Indiranagar, Bangalore");

		if(travellerSelection.isDisplayed()){
			Select sel = new Select(travellerSelection);
			sel.selectByVisibleText("1 room, 2 adults");
		}
		else

		System.out.println("dropdown is not displayed");
		utilties.clickElementBy(searchButton);


	}


}
