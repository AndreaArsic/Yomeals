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
	
//	●	metodu koja vraća poruku koja se nalazi u obaveštenju
//	●	metodu koja čeka da obaveštenje nestane
//	○	čeka se da element //*[contains(@class, 'system_message')]
//	○	za atribut style dobije vrednost  "display: none;"

	public WebElement message() {
		return driver.findElement(By.xpath("//*[contains(@style,'display: block')])"));
	}
	
	public String returnMessage() {
		String message = driver.findElement(By.xpath("//*[contains(@style,'display: block')])")).getText();
		return message;
	}
	
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	WebElement we = driver.findElement(By.id("lblOrderHeaderSaving"));   
//	Assert.assertEquals("none", we.getCssValue("display"));
	
//	Pravis eksplicitni waiter
//	Zatim, pravis kao novi webelement koji maltene hvata onaj msg alert
//	Na kraju kroz waiter.until-expected conditions hvatas ovaj webelement iz prethodnog reda 
//	i stavljas koj deo tog elementa treba da prikaze "none"
	
	public void waitNotificationToDisappear() {
	WebDriverWait wait = new WebDriverWait (driver, 10);
	WebElement element = driver.findElement(By.xpath("//*[contains(@style,'display: block')])"));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@style,'display: none')]")));
	}
	
	
	
}
