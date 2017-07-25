package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {
	
	WebDriver driver;
	
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public String getPageTitle()
	{
		WebDriverWait webdriverwait = new WebDriverWait(driver, 10);
		webdriverwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//title[starts-with(text(),'Inbox')]")));
		return driver.getTitle().substring(13);
	}

}
