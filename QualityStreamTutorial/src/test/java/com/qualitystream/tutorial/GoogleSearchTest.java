package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		// esto estaba en el video
		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		//lo cambié a esto para que coincida en mi compu
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		
		//limpia cualquier texto que esté en la caja de búsqueda
		searchbox.clear();
		
		// la línea de abajo se cambió por youtube, porque el Test daba fallido
		//searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		searchbox.sendKeys("youtube");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software", driver.getTitle());
		assertEquals("youtube - Buscar con Google", driver.getTitle());
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	

}
