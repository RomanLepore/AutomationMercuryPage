package com.webElements.packg;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import automatizacionMT.Base;

public class DropdownList_Page extends Base{

	// Locator dropdown list clasico  -- https://demo.guru99.com/test/newtours/index.php
		By dropdownList_Passengers = new By.ByName("passCount");
		By dropdownList_DepartingFrom = new By.ByName("fromPort");
		
		By flightsBtnLocator = By.linkText("Flights");
		
		// Locator SignInPage
		By userNameLocator = By.name("userName");
		By passwordLocator = By.name("password");
		By submitBtnLocator = By.name("submit");
		
		By signInMessage = By.cssSelector("h3");
		
		// dropdown list con bootstrap y react -- https://react-bootstrap.github.io/components/dropdowns/
	
		
	public DropdownList_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void signInUser() {
		if(isDisplayed(userNameLocator)) {
			type("useradmin",userNameLocator);
			type("pass1",passwordLocator);
			click(submitBtnLocator);
		}else {
			System.out.println("Sign In page was not found ");
		}
	}
	// THIS METHOD CONFIRM PRESENCE SIGN IN MESSAGE
	public String signInMessage() {
		List<WebElement> h3  =  findElements(signInMessage);
		return getText(h3.get(0));
	}
	
	// THIS METHOD ENTER IN FLIGHTS PAGE
	public void flightsIn() throws InterruptedException {
		if(findElement(flightsBtnLocator).isDisplayed()) {
			click(flightsBtnLocator);
			Thread.sleep(2000);	
		}else { 
			System.out.println("Flights page was not found");  
			}
}
	// THIS METHOD SELECT DROPDOWN LIST PASSENGERS
	public String selectedDropdownList_Passengers() {
		Select selectList = new Select(findElement(dropdownList_Passengers));
		selectList.selectByVisibleText("4");
		return getText(selectList.getFirstSelectedOption());
	}
	
	// THIS METHOD SELECT DROPDOWN LIST DEPARTING FROM
	public String selectedDropdownList_DepartingFrom() {
		Select selectList = new Select(findElement(dropdownList_DepartingFrom));
		selectList.selectByVisibleText("Paris");
		return getText(selectList.getFirstSelectedOption());
	}
	
	// THIS METHOD SELECT DROPDOWN LIST PASSENGERS (OPTION 2 LONGER)
	/*public String selectDropdownList_Passengers() {
		WebElement dropdownList = findElement(dropdownList_Passengers);
		List<WebElement> options = dropdownList.findElements(By.tagName("option"));
		for (int i = 0; i < options.size(); i++) {
			if(getText(options.get(i)).equals("4 ")) {
				click(options.get(i));
			}
		}
		String selectedOption = "";
		
		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).isSelected()) 
				selectedOption = getText(options.get(i));
		}
		return selectedOption;
	}*/
}
