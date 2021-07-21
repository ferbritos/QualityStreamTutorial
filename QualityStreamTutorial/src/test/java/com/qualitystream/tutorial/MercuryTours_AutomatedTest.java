package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	
	By registerLinkLocator = By.linkText("REGISTER");

	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name=confirmPassword]");
	
	//By registerBtnLocator = By.name("register");
	//En la página nueva el botón se llama submit
	By registerBtnLocator = By.name("submit");
	
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("submit");
	
	//By homePageLocator = By.xpath("//img[@src='/image/masts/mast_flightfinder.gif']");
	// de un comentario en youtube
	By homePageLocator = By.xpath("//h3");
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
		
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void registerUser() {
		driver.findElement(registerLinkLocator).click();
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("qualityadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");
			
			driver.findElement(registerBtnLocator).click();
			
			
		}
		else {
			System.out.println("Register pass was not found");
			
		}
			
		java.util.List<WebElement> fonts = driver.findElements(By.tagName("font"));		
		
		assertEquals("Note: Your user name is qualityadmin.",fonts.get(5).getText());
		
	
		
	}
	
	
	@Test
	public void signIn() {
		if(driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("qualityadmin");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(signInBtnLocator).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			assertTrue(driver.findElement(homePageLocator).isDisplayed());
			
		}else
			System.out.println("username textbox was not present");
		
	}
	
	
	
	
	

}
