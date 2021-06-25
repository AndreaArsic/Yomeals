package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public abstract class BasicTest {

//	●	apstraktna klasa koja sadrži sve zajedničke funkcionalnosti za sve test klase
//	●	od dodatnih atributa ima:
//	○	baseUrl 
//	○	imejl i lozinku demo korisnika customer@dummyid.com/12345678a
//	●	BeforeMethod metoda koja konfiguriše Selenium drajver
//	●	AfterMethod metoda koja u slučaju pada testa kreira screenshot stranice i te slike 
//	čuva u okviru screenshots direktorijuma i zatvara sesiju drajvera
//	●	sve ostale test klase nasleđuju ovu klasu
	
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	
	protected AuthPage authPage;
	protected CartSummaryPage cartSummaryPage;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected MealPage mealPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;
	
	protected String baseUrl="http://demo.yo-meals.com";
	protected String email="customer@dummyid.com";
	protected String password="12345678a";
	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, 10);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		authPage = new AuthPage (driver, js, wait);
		cartSummaryPage = new CartSummaryPage (driver, js, wait);
		locationPopupPage = new LocationPopupPage (driver, js, wait);
		loginPage = new LoginPage (driver, js, wait);
		mealPage = new MealPage (driver, js, wait);
		notificationSistemPage = new NotificationSistemPage (driver, js, wait);
		profilePage = new ProfilePage (driver, js, wait);
	}
	
	@AfterMethod
	public void takeScreenshotWhenFailure(ITestResult result) throws InterruptedException, IOException{
		if(ITestResult.FAILURE==result.getStatus()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File scr = screenshot.getScreenshotAs(OutputType.FILE);
			
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
			
			FileUtils.copyFile(scr, new File("./screenshots/"+ldt.format(dtf)+".png"));
			
			Thread.sleep(2000);
			this.driver.quit();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
