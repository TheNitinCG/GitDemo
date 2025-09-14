package package2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String monthNumber="6";
		String date = "15";
		String year ="2027";
		String[] expectedList= {monthNumber,date ,year};
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navigation__label')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navigation__label')]")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.xpath("//button[contains(@class,'react-calendar__year-view__months__month')]")).get(Integer.parseInt(monthNumber)-1).click();
		
		driver.findElement(By.xpath("//abbr[(text()='"+date+"')]")).click();
	//	System.out.println(driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")));
	 List<WebElement> actualList=	driver.findElements(By.xpath("//input[contains(@class,'react-date-picker__inputGroup__input react-date-picker')]"));
	 
	 for(int i=0 ; i<actualList.size();i++)
	 {
		
		 System.out.println( actualList.get(i).getAttribute("value"));
		 Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i+1]);
		 
		 
	 }
		driver.close();
		

}}
