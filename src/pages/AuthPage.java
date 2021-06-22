package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getAccountfield() {
		return driver.findElement(By.className("filled "));
	}
	
	public WebElement getMyAccount() {
		return driver.findElement(By.xpath("//*[class='my-account-dropdown'/ul/li/a"));
	}
	
	public WebElement getLogout() {
		return driver.findElement(By.xpath("//*[class='my-account-dropdown'/ul/li[2]/a"));
	}
	
	public void logout() {
		getAccountfield().click();
		getLogout().click();
	}
	
	


	
}
