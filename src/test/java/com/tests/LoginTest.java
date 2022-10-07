package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.listeners.MyListeners;
import com.pages.LoginPage;

@Listeners(MyListeners.class)
public class LoginTest extends BaseClass {

	LoginPage lp=null;
	
	@BeforeSuite
	public void setup() throws Exception{
		initialization();
		reportInit();
		lp= new LoginPage(driver);
	}
	@Test
	public void test01(){
		lp.loginToApplication("kiran@gmail.com", "123456");
	}
	@Test
	public void test02() {
		System.out.println("test02");
		Assert.assertTrue(false);
	}
	@Test
	public void test03() {
		throw new SkipException("Skipping testcase");
	}
}
