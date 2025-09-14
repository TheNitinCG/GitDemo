package package2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,700)");
		
		
		int row=driver.findElements(By.xpath("//div[@class='left-align']//table//tr")).size();
		System.out.println(row);
		int column=driver.findElements(By.xpath("//div[@class='left-align']//table//th")).size();
		System.out.println(column);
		//WebElement table=driver.findElement(By.id("product"));
		
		//List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));



	//	System.out.println(secondrow.get(0).getText());



		//System.out.println(secondrow.get(1).getText());



		//System.out.println(secondrow.get(2).getText());
		List<WebElement> secondRow=driver.findElements(By.xpath("//div[@class='left-align']//table//tr[3]/td"));
		
		for(int i=0; i<secondRow.size();i++)
		{
			System.out.println(secondRow.get(i).getText());
		}
		
		//RAHUL CODe
		
		WebElement table=driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		List<WebElement> secondRow1=driver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondRow.get(0).getText());
		

	}

}
