package AshpakShaikh_Automation.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AshpakShaikh_Automation.AbstractComponent.AbstractComponents;

public class OrderPage extends AbstractComponents{
	WebDriver driver;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> orderProducts;
	

	public OrderPage(WebDriver driver) {
	
		super(driver);
		this.driver=driver;	
		
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyOrderDisplay(String productName)
	
	{
		boolean match = orderProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));	
		return match;
//		Boolean  match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
//		
//		return match;)
	
	}
	

}
