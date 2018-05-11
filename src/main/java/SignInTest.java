import com.sun.javafx.PlatformUtil;

import utilities.ApplicationUtilities;
import utilities.BaseDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseDriver{

    
	
	
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	
        driver.get("https://www.cleartrip.com/");
        utilties.waitFor(2000);
        utilties.clickElementBy(By.linkText("Your trips"));
        utilties.clickElementBy(By.id("SignIn"));
        utilties.clickElementBy(By.id("signInButton"));
        String errors1 = utilties.getText(By.id("errors1"));
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        
    }


}
