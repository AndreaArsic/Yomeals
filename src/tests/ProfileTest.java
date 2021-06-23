package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{
//	U okviru edit profile testa potrebno je izvršiti sledeće korake:
//		●	učitajte stranicu http://demo.yo-meals.com/guest-user/login-form
//		●	ugasite lokacioni iskačući dijalog
//		●	prijavite se na aplikaciju preko demo naloga
//		●	verifikujte da je prikazana poruka sa tekstom "Login Successfull"
	
//		●	učitajte stranicu http://demo.yo-meals.com/member/profile
//		●	zamenite sve osnovne informacije korisnika
//		●	verifikujte da je prikazana poruka sa tekstom "Setup Successful"
//		●	odjavite se sa sajta
//		●	verifikujte da je prikazana poruka sa tekstom "Logout Successfull!"
	
//	@Test
//	public void editProfile() {
//		driver.get(baseUrl + "/guest-user/login-form");
//		js.executeScript("arguments[0].click()", locationPopupPage.getCloseBtn());
//		loginPage.userLogin(email, password);
//		Assert.assertEquals(notificationSistemPage.message(), "Login Succesfull");
//		
//		driver.get(baseUrl + "/member/profile");
//		profilePage.profileUpdate("Andrea", "Arsic", "Bulevard", "18347321", "18721", "SAD", "New York", "New York");
//		Assert.assertEquals(notificationSistemPage.message(), "Setup Succesfull");
//		
//		authPage.getLogout().click();
//		Assert.assertEquals(notificationSistemPage.message(), "Logout Succesfull");
//	}
	
//	U okviru change profile image testa potrebno je izvršiti sledeće korake:
//		●	učitajte stranicu http://demo.yo-meals.com/guest-user/login-form
//		●	ugasite lokacioni iskačući dijalog
//		●	prijavite se na aplikaciju preko demo naloga
//		●	verifikujte da je prikazana poruka sa tekstom "Login Successfull"
	
//		●	učitajte stranicu http://demo.yo-meals.com/member/profile
//		●	otpremite profilnu sliku
//		○	sliku iz images foldera
//		○	s obzirom na to da se za otpremanje šalje apsolutna putanja do slike, a mi 
//		koristimo relativnu, moramo da pribavimo putanju na sledeći način
//		○	String imgPath = new File("imagеs/slika.png").getCanonicalPath();
//		○	Koristan link
//		●	verifikujte da je prikazana poruka sa tekstom "Profile Image Uploaded Successfully"
//		●	sačekajte da nestane obaveštenje
	
//		●	obrišite profilnu sliku
//		●	verifikujte da je prikazana poruka sa tekstom "Profile Image Deleted Successfully"
//		●	sačekajte da nestane obaveštenje
	
//		●	odjavite se sa sajta
//		●	verifikujte da je prikazana poruka sa tekstom "Logout Successfull!"
	
	@Test
	public void changeProfileImage() throws IOException {
		driver.get(baseUrl + "/guest-user/login-form");
		js.executeScript("arguments[0].click()", locationPopupPage.getCloseBtn());
		loginPage.userLogin(email, password);
		Assert.assertEquals(notificationSistemPage.message(), "Login Succesfull");
		
		driver.get(baseUrl + "/member/profile");
		String imgPath = new File("imagеs/slika.png").getCanonicalPath();
		profilePage.uploadPhoto(imgPath);
		Assert.assertEquals(notificationSistemPage.message(), "Profile Image Uploaded Successfully");
		notificationSistemPage.waitNotificationToDisappear();
		
		profilePage.removePhoto();
		Assert.assertEquals(notificationSistemPage.message(), "Profile Image Deleted Successfully");
		notificationSistemPage.waitNotificationToDisappear();
		
		authPage.getLogout().click();
		Assert.assertEquals(notificationSistemPage.message(), "Logout Succesfull");
	}

	
	

}
