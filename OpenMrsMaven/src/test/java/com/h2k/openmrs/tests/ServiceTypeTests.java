package com.h2k.openmrs.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.h2k.openmrs.pages.HomePage;
import com.h2k.openmrs.pages.LoginPage;
import com.h2k.openmrs.pages.ServiceTypePage;

public class ServiceTypeTests {
	ServiceTypePage sType;
	WebDriver driver ;
	LoginPage lPage;
	HomePage hPage;
	@Parameters({"browserType","url"})
	@BeforeClass
	public void invokeBrowser(String browserType,String url)
	{
		if(browserType.equals("IE"))
		{ 
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserType.equals("CH"))
		{	//executable chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver  = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver  = new FirefoxDriver();
		}
		driver.get(url);
		sType=new ServiceTypePage(driver);
		lPage = new LoginPage(driver);
	     hPage = new HomePage(driver);
	}
	@AfterClass
	public void closeBrowser()
	{

	}
	@BeforeMethod
	public void login()
	{
		lPage.login("Admin", "Admin123");

	}
	@AfterMethod
	public void logout()
	{

	}
	 
	@Test(priority=1)
	public void validateAddServiceType() throws InterruptedException
	{
		Thread.sleep(5000);
		hPage.navigatetoAppointmentSchedulingPage();
		hPage.clickManageServiceTypes();
		sType.addServiceType("orthopedic");
		boolean result = sType.verifyServiceType("orthopedic" );
		Assert.assertTrue(result);
	}
//
//	@Test(priority=2)
//	public void validateEditServiceType()
//	{
//		sType.editServiceType("orthopedic");
//		boolean result = sType.verifyServiceType("orthopedic" );
//		Assert.assertTrue(result);
//	}
//
//	@Test(priority=3)
//	public void validateDeleteServiceType()
//	{
//		sType.deleteServiceType("orthopedic");
//		boolean result = sType.verifyServiceType("orthopedic" );
//		Assert.assertFalse(result);
//	}

}













