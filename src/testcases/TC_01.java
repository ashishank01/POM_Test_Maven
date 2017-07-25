package testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Login_Page;

public class TC_01 {
	WebDriver driver;
	Login_Page objLoginPage;
	Home_Page objHomePage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.gmail.com");	
	}
	
	@Test
	public void QA_TC_01()
	{
		objLoginPage=new Login_Page(driver);
		objLoginPage.setLoginId("ashishank.20097@gmail.com");
		objLoginPage.setLoginPassword("17november");
		objHomePage=new Home_Page(driver);
		Assert.assertEquals(objHomePage.getPageTitle(), "ashishank.20097@gmail.com - Gmail", "Expected Title is not correct.");
		objHomePage.getPageTitle();
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
