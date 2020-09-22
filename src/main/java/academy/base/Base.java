package academy.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		// Load the Properties
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\reshmi\\work\\eclipse-workspace\\E2EProject\\src\\main\\java\\academy\\resources\\data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String chromeDriver = prop.getProperty("chrome_driver");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",chromeDriver);
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			/*
			 * Get Firefox driver
			 */
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenShotpath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}

}
