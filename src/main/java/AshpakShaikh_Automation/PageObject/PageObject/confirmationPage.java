package AshpakShaikh_Automation.PageObject.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AshpakShaikh_Automation.AbstractComponent.AbstractComponents;

public class confirmationPage extends AbstractComponents{
	WebDriver driver;
	
	public confirmationPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;	
		
		PageFactory.initElements(driver, this);
	}
	
	//  driver.findElement(By.cssSelector(".hero-primary"))
	

	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	
	{
		return confirmationMessage.getText();
	}

}
