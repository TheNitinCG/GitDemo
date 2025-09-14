package package2;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//first click on column
		driver.findElement(By.xpath("//tr/th/span[text()='Veg/fruit name']")).click();
		
		//stored weblement in one list
		List<WebElement> elementsList=driver.findElements(By.xpath("//tr/td[1]"));
	

		
		//capture text of all web elements into new list
		List<String> originalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		//sort in the new list 
		List<String> sortedList =originalList.stream().sorted().collect(Collectors.toList());
		//compare original vs new list
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		//scan the name column with gettext->rice then ask to print the price of the beans
		do {
			List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
		 price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
	String priceValue=	s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
