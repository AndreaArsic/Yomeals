package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(By.xpath("//*[@class='filled']/a"));
	}
	
	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getRememberMeCheckBox() {
		return driver.findElement(By.name("remember_me"));
	}
	
	public WebElement getConfirmLoginBtn() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void userLogin (String userName, String password) {
		this.getUsername();
		this.getPassword();
		this.getConfirmLoginBtn();
	}

}
