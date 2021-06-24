package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	@Test
	public void editProfile() throws InterruptedException {
		driver.get(baseUrl + "/guest-user/login-form");
		locationPopupPage.closePopup();
		loginPage.userLogin(email, password);
		Thread.sleep(1000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Login Successfull");
		notificationSistemPage.waitNotificationToDisappear();
		
		driver.get(baseUrl + "/member/profile");
		profilePage.profileUpdate("Andrea", "Arsic", "Bulevard", "18347321", "18721", "United States", "Nevada", "Las Vegas");
		Thread.sleep(1000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Setup Successful");
		notificationSistemPage.waitNotificationToDisappear();
		
		authPage.logout();
		Thread.sleep(1000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Logout Successfull!");
		notificationSistemPage.waitNotificationToDisappear();
	}
	
	@Test
	public void changeProfileImage() throws IOException, InterruptedException {
		driver.get(baseUrl + "/guest-user/login-form");
		locationPopupPage.closePopup();
		loginPage.userLogin(email, password);
		Thread.sleep(2000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Login Successfull");
		notificationSistemPage.waitNotificationToDisappear();
		
		driver.get(baseUrl + "/member/profile");
		String imgPath = new File("imagеs/slika.png").getCanonicalPath();
		profilePage.uploadPhoto("C:\\Users\\Dell\\Desktop\\Anja\\ponic.png");
		Thread.sleep(2000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Profile Image Uploaded Successfully");
		notificationSistemPage.waitNotificationToDisappear();
		
		profilePage.removePhoto();
		Thread.sleep(2000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Profile Image Deleted Successfully");
		notificationSistemPage.waitNotificationToDisappear();
		
		authPage.logout();
		Thread.sleep(2000);
		Assert.assertEquals(notificationSistemPage.returnMessage(), "Logout Successfull!");
		notificationSistemPage.waitNotificationToDisappear();
	}

	
	

}
