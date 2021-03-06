package academy.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import academy.base.Base;
import academy.pageobjects.LandingPage;

import java.io.IOException;

public class ValidateNavigationBarTest extends Base {
	private static final Logger logger = LogManager.getLogger(HomePageTest.class);
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		logger.info("Driver is initialised");
		String url = prop.getProperty("url");
		driver.get(url);
	}

	@Test()
	public void basePageNavigation() throws IOException {
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
		LandingPage login = new LandingPage(driver);
		Assert.assertTrue(login.getNavigationBar().isDisplayed());
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
