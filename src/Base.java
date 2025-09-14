
import java.lang.foreign.AddressLayout;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
	


       

      
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
		
		
	}
	
public static void addItems(WebDriver driver,String[] itemsNeeded)
{
	
	int j=0;
	List<WebElement> product =driver.findElements(By.xpath("//h4[@class='product-name']"));
	
	for(int i=0 ;i<product.size(); i++)
	{
		String[] name=product.get(i).getText().split("-");
		//name[0]=brocoli
		String formattedName=name[0].trim();
		//format it to get exact vegetable name
		
		//check whether name you extracted is present in the array or not
		//convert array into arraylist for easy search
		List itemsNeededList= Arrays.asList(itemsNeeded);
		
		
		if(itemsNeededList.contains(formattedName))
		{
		//click to add to cart
			j++;
		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
		if(j==itemsNeeded.length)
		{
			System.out.println(j);
			break;
			
		}
	}
	 
	 

}
}
	}



