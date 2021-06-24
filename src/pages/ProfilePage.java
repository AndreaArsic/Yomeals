package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("//div[@class='row']//input[@type='submit']"));
	}
	
	public void uploadPhoto(String img) throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.className("avatar"));
		action.moveToElement(element).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Uplaod']"));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Uplaod']")));
		driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys(img);
	}
	
	public void removePhoto() {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@title='Remove']")));
	}
	
	public void profileUpdate(String firstName, String lastName, String address, String phoneNum, 
			String zipCode, String country, String state, String city) throws InterruptedException {
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
		
		Thread.sleep(1000);
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(1000);
		this.getState().selectByVisibleText(state);
		Thread.sleep(1000);
		this.getCity().selectByVisibleText(city);
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].click()", getSaveBtn());
	}
	
	
	
	
	
	
	
	
}
