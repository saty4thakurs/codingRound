package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplicationUtilities {
	WebDriver driver;
	
	public ApplicationUtilities(WebDriver driver){
		this.driver = driver;
	}
	
	public  void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	public boolean clickElementBy(By elementBy){
		boolean isClicked = false;
		
		waitFor(1000);
		try{
		if(driver.findElement(elementBy).isDisplayed()){
			driver.findElement(elementBy).click();
			isClicked= true;
		}
		}
		catch(Exception ex){
			System.out.println("element not displayed :"+ex.getMessage());
		}
				
		
		return isClicked;
	}
	
	public String getText(By elementBy){
		String text= null;
		
		try{
			if(driver.findElement(elementBy).isDisplayed()){
				text = driver.findElement(elementBy).getText();
			}
			}
			catch(Exception ex){
				System.out.println("element not displayed :"+ex.getMessage());
			}
				
		
		return text;
	}
	
	public boolean clickElementBy(WebElement element){
		boolean isClicked = false;
		
		waitFor(1000);
		try{
		if(element.isDisplayed()){
			element.click();
			isClicked= true;
		}
		}
		catch(Exception ex){
			System.out.println("element not displayed :"+ex.getMessage());
		}
				
		
		return isClicked;
	}
	
	public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
