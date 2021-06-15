package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.Excelsheet;

public class LoginTest extends BaseHRMClass			//extends keyword makes the LoginTest class child of BaseHRMClass	
{
	PomLogin Log;
	public LoginTest()
	{
		super();									//To call constructor of the Parent class we have to use 'super' keyword
	}
	
	@BeforeMethod
	public void initsetup()
	{
		initiation();
		Log= new PomLogin();
		screenshots("Login");
	}
	
	@Test(priority=1)
	
	public void Title()
	{
		String actual= Log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual,"OrangeHRM");
	}
	
	@DataProvider
	public Object[][] Details()
	{
		Object result[][]=Excelsheet.readdata("Sheet1");
		return result;
		
	}
	@Test(priority=2,dataProvider="Details")
	public void Login(String name, String password) throws InterruptedException
	{
		Log.typeusername(name);
		Thread.sleep(3000);
		Log.typepassword(password);
		//Log.clkbtn();
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	}

