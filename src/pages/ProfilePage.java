package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
	
	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhoneNum() {
		return driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}
	
	public Select getCountry() {
		 Select country = new Select(driver.findElement(By.id("user_country_id")));
		return country;
	}
	
	public Select getState() {
		 Select state = new Select(driver.findElement(By.id("user_state_id")));
		return state;
	}
	
	public Select getCity() {
		 Select city = new Select(driver.findElement(By.id("user_city")));
		return city;
	}
	
//	public WebElement getPhotoPath() {
//		return 
//	}
	
	public void uploadPhoto(String img) {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@type=\"file\"]")));
		driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys("C:\\Users\\Dell\\Desktop\\Anja\\ponic.png");
	}
	
//	public WebElement getPhotoRemove() {
//		return driver.findElement(By.xpath("//*[class=\"avatar\"]/img"));
//	}
	
	public void removePhoto() {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[class=\"avatar\"]/img")));
	}

	public void selectCountry(String countryText) {
		getCountry().selectByVisibleText(countryText);
	}
	
	public void selectState(String stateText) {
		getCountry().selectByVisibleText(stateText);
	}
	
	public void selectCity(String cityText) {
		getCountry().selectByVisibleText(cityText);
	}
	
	public void profileUpdate(String firstName, String lastName, String address, String phoneNum, 
			String zipCode, String country, String state, String city) {
		getFirstName().clear();
		getLastName().clear();
		getAddress().clear();
		getPhoneNum().clear();
		getZipCode().clear();
		
		getFirstName().sendKeys(firstName);
		getLastName().sendKeys(lastName);
		getAddress().sendKeys(address);
		getPhoneNum().sendKeys(phoneNum);
		getZipCode().sendKeys(zipCode);
		
		selectCountry(country);
		selectState(state);
		selectCity(city);
	}
	
	
	
	
	
	
	
	
}