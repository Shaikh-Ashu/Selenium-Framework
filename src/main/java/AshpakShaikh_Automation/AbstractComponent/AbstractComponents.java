package AshpakShaikh_Automation.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AshpakShaikh_Automation.PageObject.PageObject.CartPage;

public class AbstractComponents {
	// Parent Class for all the POM classes
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage crtPage=new  CartPage(driver);
		return crtPage;
		
	}
	

	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

}
	public void waitForElementToDisAppear(WebElement  ele) throws InterruptedException
	{
		
		Thread.sleep(1000);
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.invisibilityOf(ele));
	
}
}
