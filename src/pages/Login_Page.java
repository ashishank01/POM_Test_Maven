package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {
	
	WebDriver driver;
	
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='email']")
	WebElement login_id;
	
	@FindBy(xpath="//input[@type='password' and @name='password']")
	WebElement login_pwd;
	
	@FindBy(xpath="//*[@id='identifierNext']")
	WebElement login_id_next;
	
	@FindBy(xpath="//*[@id='passwordNext']")
	WebElement login_pwd_next;
	
	public void setLoginId(String id)
	{
		login_id.sendKeys(id);
		login_id_next.click();
	}
	
	public void setLoginPassword(String pwd)
	{
		WebDriverWait webdriverwait = new WebDriverWait(driver, 10);
		webdriverwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passwordNext']")));
		login_pwd.sendKeys(pwd);
		login_pwd_next.click();
	}
	
	public void Login(String id, String pwd)
	{
		this.setLoginId(id);
		this.setLoginPassword(pwd);
		
	}

}
