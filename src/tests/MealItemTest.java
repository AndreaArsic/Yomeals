package tests;

import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{
	
//	U okviru add meal to cart testa potrebno je izvršiti sledeće korake:
//		●	učitajte stranicu http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo
//		●	ugasite lokacioni iskačući dijalog
//		●	dodajte jelo u korpu, količina je proizvoljna
//		●	verifikujte da je prikazana poruka sa tekstom 
//		"The Following Errors Occurred:
//		Please Select Location"
//		●	sačekajte da obaveštenje nestane
//		●	postavite lokaciju na "City Center - Albany"
//		●	dodajte jelo u korpu, količina je proizvoljna
//		●	verifikujte da je prikazana poruka sa tekstom "Meal Added To Cart"
	
	@Test
	public void addMealToCart() {
		driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		js.executeScript("arguments[0].click()", locationPopupPage.getCloseBtn());
		
	}
	
	
	
	
	
	
//	U okviru add meal to favorite testa potrebno je izvršiti sledeće korake:
//		●	učitajte stranicu http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo
//		●	ugasite lokacioni iskačući dijalog
//		●	dodajte jelo u omiljena jela
//		●	verifikujte da je prikazana poruka sa tekstom "Please login first!"
//		●	učitajte stranicu za prijavu
//		●	prijavite se na aplikaciju preko demo naloga
//		●	učitajte stranicu http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo
//		●	dodajte jelo u omiljena jela
//		●	verifikujte da je prikazana poruka sa tekstom "Product has been added to your favorites."
	
	
	
	
	
	
//	
//	U okviru clear cart testa potrebno je izvršiti sledeće korake:
//		●	učitajte stranicu http://demo.yo-meals.com/meals
//		●	postavite lokaciju na "City Center - Albany"
//		●	čitate podatke iz xlsx fajla > Meals Sheet 
//		●	u korpu dodajte svaki proizvod sa određenom količinom
//		●	za svako dodavanje proizvioda verifikujte da je prikazana poruka sa tekstom
//		"Meal Added To Cart"
//		○	koristite SoftAssert za ovu proveru
//		●	obrišite sve stavke iz korpe
//		●	verifikujte da je prikazana poruka sa tekstom "All meals removed from Cart successfully"
	
	
	


	
	
	
	
	
	

}
