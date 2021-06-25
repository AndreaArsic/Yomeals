package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest{
	
	
	@Test
	public void addMealToCart() throws InterruptedException {
		driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		js.executeScript("arguments[0].click()", locationPopupPage.getCloseBtn());
		Thread.sleep(1000);
		
		mealPage.addToCart(2.0);
		Thread.sleep(1000);
		Assert.assertTrue(notificationSistemPage.returnMessage().contains("The Following Errors Occurred:"));
		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Please Select Location"));	
			
		notificationSistemPage.waitNotificationToDisappear();
		
		locationPopupPage.openDialog();
		Thread.sleep(1000);
		locationPopupPage.setLocationName("City Center - Albany");
		
		mealPage.addToCart(2.0);
		Thread.sleep(1000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Meal Added To Cart");
	}
	
	
	@Test(priority = 1)
	public void addMealToFavorite() throws InterruptedException {
		driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		js.executeScript("arguments[0].click()", locationPopupPage.getCloseBtn());
		Thread.sleep(1000);
		
		mealPage.addToFavorite();
		Thread.sleep(1000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Please login first!");
		notificationSistemPage.waitNotificationToDisappear();
		
		loginPage.userLogin(email, password);
		
		driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(1000);
		
		mealPage.addToFavorite();
		Thread.sleep(1000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Product has been added to your favorites.");
		notificationSistemPage.waitNotificationToDisappear();
	}

	
		@Test
		public void clearCart() throws InterruptedException, IOException {
			driver.get(baseUrl + "/meals");
			locationPopupPage.setLocationName("City Center - Albany");
			
			File file = new File ("data/Data.xlsx");
			FileInputStream fis = new FileInputStream (file);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Meals");
			
			for (int i = 1; i < 6; i++) {
				String mealUrl = sheet.getRow(i).getCell(0).getStringCellValue();
				double quantity = sheet.getRow(i).getCell(1).getNumericCellValue();
				driver.get(mealUrl);
				mealPage.addToCart(quantity);
				Thread.sleep(1000);
				
				SoftAssert softAssertion= new SoftAssert();
				softAssertion.assertEquals(notificationSistemPage.returnMessage(), "Meal Added To Cart");
				
				System.out.println(mealUrl + ", " + quantity);
			}
			cartSummaryPage.clearAll();
			Thread.sleep(1000);
			Assert.assertEquals(notificationSistemPage.returnMessage(), "All meals removed from Cart successfully");
			notificationSistemPage.waitNotificationToDisappear();
		}
	


	
	
	
	
	
	

}
