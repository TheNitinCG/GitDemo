package package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// select the checkbox
		// grab the label of selected checkbox
		// select drop down.here option should come from checkbox
		// enter step 2 label name into edit box
		// click alert and verify if text present from step 2
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		String opt = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();

		System.out.println(opt);
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropdpwn = new Select(staticDropdown);
		dropdpwn.selectByVisibleText(opt);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(opt);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		if(text.contains(opt))
		{
			System.out.println("Success");
		}
		else
		System.out.println("Not success");
			
		
		driver.switchTo().alert().accept();

	}

}
