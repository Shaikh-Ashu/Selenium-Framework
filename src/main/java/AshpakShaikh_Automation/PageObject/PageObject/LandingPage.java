package AshpakShaikh_Automation.PageObject.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AshpakShaikh_Automation.AbstractComponent.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	public LandingPage (WebDriver driver)
	{
		super(driver);
	this.driver=driver;	
	
	PageFactory.initElements(driver, this);
		
	}

//	WebElement userEmailv = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//driver.findElement(By.id("userPassword"))
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	// driver.findElement(By.id("login"))
	
	@FindBy(id="login")
	WebElement submit;
	
	public CatalogPage loginApplication(String email, String password) 
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();	
		
		CatalogPage ctlPage= new CatalogPage(driver);
		return ctlPage;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}	
	
}
