package AshpakShaikh_Automation.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AshpakShaikh_Automation.PageObject.PageObject.CartPage;
import AshpakShaikh_Automation.PageObject.PageObject.CatalogPage;
import AshpakShaikh_Automation.PageObject.PageObject.LandingPage;
import AshpakShaikh_Automation.PageObject.PageObject.checkOutPage;
import AshpakShaikh_Automation.PageObject.PageObject.confirmationPage;
import AshpakShaikh_Automation.tests.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

	@Test

	public void submitOrder() throws IOException, InterruptedException {

		String productdName = "ZARA COAT 3";
		LandingPage landingPage = launchApplication();

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
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	}

}
