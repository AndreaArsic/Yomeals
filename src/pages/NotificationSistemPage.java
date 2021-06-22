package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage{

	public NotificationSistemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	

	public WebElement message() {
		return driver.findElement(By.xpath("//*[contains(@style,'display: block')])"));
	}
	
	public String returnMessage() {
		String message = driver.findElement(By.xpath("//*[contains(@style,'display: block')])")).getText();
		return message;
	}
	
	
	public void waitNotificationToDisappear() {
	WebDriverWait wait = new WebDriverWait (driver, 10);
	WebElement element = driver.findElement(By.xpath("//*[contains(@style,'display: block')])"));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@style,'display: none')]")));
	}
	
	
	
}
