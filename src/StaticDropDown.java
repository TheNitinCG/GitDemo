import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//drop down with select tag
		//WebElement staticDropdown= driver.findElement(By.id(""));
		WebElement staticDropdown= driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdpwn= new Select(staticDropdown);
		dropdpwn.selectByIndex(3);
		
		System.out.println(dropdpwn.getFirstSelectedOption().getText());
		dropdpwn.selectByVisibleText("AED");
		System.out.println(dropdpwn.getFirstSelectedOption().getText());
		dropdpwn.selectByValue("INR");
		System.out.println(dropdpwn.getFirstSelectedOption().getText());

	}

}
