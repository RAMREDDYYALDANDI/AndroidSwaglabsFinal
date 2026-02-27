package Tests;

import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.ProductPOM;
import Utils.Abstractclas;

public class ProductTest extends BaseTest {

    // REMOVE the constructor - TestNG doesn't need it
    
    @Test
    public void validateProductSelection() {
        // Since LoginTest already finished the login, 
        // we just initialize the Product Page to continue the flow
        ProductPOM productPage = new ProductPOM(driver);
        
        
        System.out.println("✅ Starting Product Selection Flow...");

        // ITEM 1: Sauce Labs Onesie
        productPage.scrolltoproduct("Sauce Labs Onesie");
        productPage.clicktoproduct("Sauce Labs Onesie");
        System.out.println("✅ Added Item 1: Onesie");
        Abstractclas.addName("Sauce Labs Onesie");

        // ITEM 2: Sauce Labs Backpack (Simply repeat the logic with the new name)
        productPage.scrolltoproduct("Sauce Labs Backpack");
        productPage.clicktoproduct("Sauce Labs Backpack");
        System.out.println("✅ Added Item 2: Backpack");
        
        System.out.println("✅ Both products added successfully!");
        Abstractclas.addName("Sauce Labs Backpack");
        
        productPage.catpage();
        
       
    }
}
