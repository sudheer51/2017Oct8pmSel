package com.h2k.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	
	//Updating this file in my branch
	WebDriver driver;
	public HomePage(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	public void navigatetoAppointmentSchedulingPage()
	{
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
	}
	public void clickManageServiceTypes()
	{
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
	}
}
