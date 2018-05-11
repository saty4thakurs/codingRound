package utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.sun.javafx.PlatformUtil;

public class BaseDriver {
	
	public WebDriver driver;
	public ApplicationUtilities utilties ;
	
	@BeforeMethod
	
	public void intiliaseWebDriverLocally() {
		setDriverPath();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		utilties= new ApplicationUtilities(driver) ;
	}
	
	
	public void setDriverPath(){
		
		File file = new File(".");
		String chromeDriverPath = file.getAbsolutePath().substring(0, file.getAbsolutePath().indexOf("."));
		chromeDriverPath = chromeDriverPath+"//chromedriver.exe";
		
		File file2 = new File(chromeDriverPath);
		if(file2.exists()){
		if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
		}
		else
			System.out.println("chrome driver doesnt exists in the path :"+chromeDriverPath);
	}
	
	
	
	 @AfterMethod
	 
	 public void closeBrowser() {
		 driver.close();
		 driver.quit();
	 }
}
