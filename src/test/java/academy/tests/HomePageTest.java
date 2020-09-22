package academy.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import academy.base.Base;
import academy.pageobjects.LandingPage;
import academy.pageobjects.LoginPage;

public class HomePageTest extends Base {
	private static final Logger logger = LogManager.getLogger(HomePageTest.class);
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		logger.info("Driver is initialised");
	}

	@Test(dataProvider = "getData")
	public void baseNavigation(String username, String password, String text) throws IOException
	{
		String url = prop.getProperty("url");
		driver.get(url);
		LandingPage login = new LandingPage(driver);
		// driver.findElement(By.xpath("//button[contains(text(),'NO
		// THANKS')]")).click();
		login.getlogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getlogin().click();
		logger.info("User Login");
	}

	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@abc.com";
		data[0][1] = "abcdef";
		data[0][2] = "nonrestricteduser";

		data[1][0] = "restricteduser@abc.com";
		data[1][1] = "abcdef";
		data[0][2] = "restricteduser";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
