package academy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By login = By.cssSelector("a[href*='sign_in']");

	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");

	By navigationbar = By.xpath("//nav[@class='navbar-collapse collapse']");

	public WebElement getlogin() {
		return driver.findElement(login);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(navigationbar);
	}

}
