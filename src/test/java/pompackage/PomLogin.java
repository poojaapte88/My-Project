package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	
	//object repository
	
	@FindBy(id="txtUsername")		//driver.findElement(By.)= @FindBy(css="path")
	WebElement username;
	@FindBy(id="txtPassword")		
	WebElement password;
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	
	//initiate page elements
	
	public PomLogin()						//constructor with same class name
	{
		PageFactory.initElements(driver,this);
	}
	
	public void typeusername(String name)
	{
		username.sendKeys(name);
		
	}
	
	public void typepassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clkbtn()
	{
		loginbtn.click();
	}
	
	
	public String verify()
	{
		return driver.getTitle();
	}
}
