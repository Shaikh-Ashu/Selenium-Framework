package AshpakShaikh_Automation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AshpakShaikh_Automation.AbstractComponent.AbstractComponents;

public class checkOutPage extends AbstractComponents{
	WebDriver driver;

	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
//".ta-item:nth-of-type(2)"
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectIndia;
	
	By results = By.cssSelector(".ta-results");
	
	
	
	public void selectCountry(String countryName)
	{

		Actions ac=new Actions(driver); 
		ac.sendKeys(country,countryName).build().perform();
		
		waitForElementToAppear(results);
		
		selectIndia.click();
	}
	public confirmationPage submitOrder()
	{
		submit.click();
		return new confirmationPage(driver);
	}
	
}
