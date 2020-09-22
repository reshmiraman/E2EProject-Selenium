package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	private static final Logger logger = LogManager.getLogger(ValidateTitle.class);
	public WebDriver  driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		logger.info("Driver is initialised");
		
		String url = prop.getProperty("url");
		driver.get(url);
		logger.info("Navigated to Home Page");
		
	}

	@Test()
	public void basePageNavigation() throws IOException {
		//driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
		LandingPage login = new LandingPage(driver);
		String text = login.getTitle().getText();
		Assert.assertEquals("FEATU12RED COURSES", text);
		logger.info("Successfully validated text message");

	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}


}
