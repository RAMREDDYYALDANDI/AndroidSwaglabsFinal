package Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPOM;
import Utils.Abstractclas;

public class CartLogic extends BaseTest{
	
	
	@Test
	public void cartpagevalidation()
	{
		CartPOM cartpage = new CartPOM(driver);
		cartpage.cart();
		List<String> actualInCart = cartpage.cartitems();
		
		List<String> expectedFromselected = Abstractclas.selectedNames;
		
		System.out.println("Validation: Actual :"+ actualInCart+"Vs Selected: "+expectedFromselected);
		
		Assert.assertEquals(actualInCart, expectedFromselected, "❌ Selected items do not match Present items!");
	}

}
