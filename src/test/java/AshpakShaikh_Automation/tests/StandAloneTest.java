package AshpakShaikh_Automation.tests;

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

import AshpakShaikh_Automation.PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		String prodName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage =new  LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("shaikhashu7860@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Simmu@7860");
		driver.findElement(By.id("login")).click();
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equals(prodName)).findFirst()	.orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
//		driver.findElement(By.cssSelector(".form-group input")).sendKeys("IND");
//		Thread.sleep(3000);
//		List<WebElement> countryList = driver.findElements(By.cssSelector(".ta-item"));
//		
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
//		
//		countryList.stream().filter(country->country.getText().equalsIgnoreCase("India")).forEach(s->s.click());
		
		Actions ac=new Actions(driver);
		ac.sendKeys(driver.findElement(By.cssSelector(" [placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results"))); 
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String orderCOnfirm = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	Assert.assertTrue(orderCOnfirm.equalsIgnoreCase("Thankyou for the order."));
	
	driver.close();
	}  

}
