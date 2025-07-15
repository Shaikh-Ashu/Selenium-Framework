package AshpakShaikh_Automation.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AshpakShaikh_Automation.PageObject.CartPage;
import AshpakShaikh_Automation.PageObject.CatalogPage;
import AshpakShaikh_Automation.PageObject.checkOutPage;
import AshpakShaikh_Automation.PageObject.confirmationPage;
import AshpakShaikh_Automation.tests.testComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test

	public void errorValidation() throws IOException, InterruptedException {

		String productdName = "ZARA COAT 3";

	landingPage.loginApplication("shaikhashu7860@gmail.com", "Simmu@78960");
		AssertJUnit.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());

	}
	
	@Test

	public void productErrorValidation() throws IOException, InterruptedException {

		String productdName = "ZARA COAT 3";

		CatalogPage ctlPage = landingPage.loginApplication("shaikhashu7860@gmail.com", "Simmu@7860");

		List<WebElement> products = ctlPage.getProductList();
		ctlPage.addProductToCart(productdName);
		CartPage crtPage = ctlPage.goToCartPage();

		Boolean match = crtPage.verifyPublicDisplay("ZARA COAT 33");
		Assert.assertFalse(match);



	}

}
