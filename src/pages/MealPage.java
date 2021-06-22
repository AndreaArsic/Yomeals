package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public List<WebElement> getProduct(){
		return driver.findElements(By.xpath("//*[class='featured-img']/a"));
	}
	
	public WebElement getAddToCart() {
		return driver.findElement(By.linkText("Add To Cart"));
	}
	
	public WebElement getQuantity() {
		return driver.findElement(By.name("product_qty"));
	}
	
	public WebElement getFavorite() {
		return driver.findElement(By.xpath("//*[class='product-detail-image']/a"));
	}
	
	public void addToCart (String quantity) {
		this.getQuantity().sendKeys(quantity);
		this.getAddToCart().click();
	}
	
	public void addToFavorite() {
		this.getFavorite().click();
	}
	
	
	
	
	
	

}
