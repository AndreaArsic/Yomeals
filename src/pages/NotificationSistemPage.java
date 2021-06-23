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
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
	public String returnMessage() {
		return message().getText();
	}
	
	
	public void waitNotificationToDisappear() {
//	WebDriverWait wait = new WebDriverWait (driver, 10);
//	WebElement element = driver.findElement(By.xpath("//*[contains(@style,'display: block')])"));
//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@style,'display: none')]")));
	wait.until(ExpectedConditions.attributeContains(message(), "style", "display: none"));
	}
	
	
	
}
