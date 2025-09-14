package package2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> values=driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		List<WebElement> values1=driver.findElements(By.xpath("//div[@class='left-align']//table//td[3]"));
		int sum=0;
		for(int i= 0 ;i<values.size();i++)
		{
			
			
			sum= sum+ Integer.parseInt(values.get(i).getText());
		}
		
		int sum1=0;
		for(int i=0;i<values1.size();i++)
		{
			sum1= sum1+ Integer.parseInt(values1.get(i).getText());
		}
	System.out.println(sum);
	System.out.println(sum1);
	
	driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
	driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
	int total= Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
	Assert.assertEquals(sum, total);
	}

}
