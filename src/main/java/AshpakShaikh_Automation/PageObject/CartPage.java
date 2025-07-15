package AshpakShaikh_Automation.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AshpakShaikh_Automation.AbstractComponent.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	

	public CartPage(WebDriver driver) {
	
		super(driver);
		this.driver=driver;	
		
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyPublicDisplay(String productName)
	
	{
		boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));	
		return match;
//		Boolean  match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
//		
//		return match;)
	
	}
	
	public checkOutPage gotoCheckOut()
	{
		checkoutEle.click();
		return new checkOutPage(driver);
	}

}
