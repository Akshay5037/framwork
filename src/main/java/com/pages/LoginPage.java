package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id="email")
	WebElement uname;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy (xpath="//button")
	WebElement loginbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void loginToApplication(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		
		loginbtn.click();
	}
}
