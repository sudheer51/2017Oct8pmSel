package com.h2k.openmrs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServiceTypePage {
	
	WebDriver driver;
	public ServiceTypePage(WebDriver driver1) {
		driver = driver1;
	}
	public boolean addServiceType(String serviceName)
	{
		driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/button")).click();
		driver.findElement(By.id("name-field")).clear();
		driver.findElement(By.id("name-field")).sendKeys(serviceName);
		driver.findElement(By.id("duration-field")).sendKeys("10");
		driver.findElement(By.id("description-field")).sendKeys(serviceName);
		driver.findElement(By.id("save-button")).click();
		return true;

	}
	public boolean editServiceType(String serviceName)
	{

		//logic for findElements
		return true;

	}
	public boolean deleteServiceType(String serviceName)
	{

		//logic for findElements
		return true;

	}
	public boolean verifyServiceType(String serviceName)
	{
		boolean result  = false;
		List<WebElement> pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		System.out.println("Number of Pages:::" + pageList.size());
		outerloop:
		for(int i=0;i<pageList.size();i++)
		{
			List <WebElement> serviceTypeList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
			for(int j=0;j<serviceTypeList.size();j++)
			{
				
				System.out.println(serviceTypeList.get(j).getText());
				if(serviceTypeList.get(j).getText().contains(serviceName))
				{
					System.out.println("Service Name Found");
					result = true;
					break outerloop ;
				}
			}
			System.out.println("Clicking on the page..");
			pageList.get(i+1).click();
			System.out.println("After Clicking on the page");
		}
		//logic for findElements
		return result;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
