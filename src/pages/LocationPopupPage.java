package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage{

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public WebElement getSelectLocation() {
		return driver.findElement(By.className("location-selector"));
	}
	
	public WebElement getCloseBtn() {
		return driver.findElement(By.className("close-btn close-btn-white"));
	}
	
	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}
	
	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	
	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	
	public void openDialog() {
		this.getSelectLocation().click();
	}
	
	
	
	
	
	
	
	
	
	
	
}