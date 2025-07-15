package AshpakShaikh_Automation.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import AshpakShaikh_Automation.PageObject.CartPage;
import AshpakShaikh_Automation.PageObject.CatalogPage;
import AshpakShaikh_Automation.PageObject.OrderPage;
import AshpakShaikh_Automation.PageObject.checkOutPage;
import AshpakShaikh_Automation.PageObject.confirmationPage;
import AshpakShaikh_Automation.tests.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productdName = "ZARA COAT 3";

	@Test

	public void submitOrder() throws IOException, InterruptedException {


		CatalogPage ctlPage = landingPage.loginApplication("shaikhashu7860@gmail.com", "Simmu@7860");

		List<WebElement> products = ctlPage.getProductList();
		ctlPage.addProductToCart(productdName);
		CartPage crtPage = ctlPage.goToCartPage();

		Boolean match = crtPage.verifyPublicDisplay(productdName);
		Assert.assertTrue(match);
		checkOutPage checkOutPage = crtPage.gotoCheckOut();
		checkOutPage.selectCountry("india");
		confirmationPage cnfgPage = checkOutPage.submitOrder();

		String confirmationMessage = cnfgPage.getConfirmationMessage();
		AssertJUnit.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));


	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest()
	{
		CatalogPage ctlPage = landingPage.loginApplication("shaikhashu7860@gmail.com", "Simmu@7860");
		OrderPage orderPage= ctlPage.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productdName));
		
	}

}
