import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false); // <— IMPORTANT

		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String[] itemsNeeded = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']//following::span[@class='checkmark']")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		// driver.switchTo().alert().accept();
		

		WebElement staticDropdown = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select dropdpwn = new Select(staticDropdown);
		dropdpwn.selectByValue("consult");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link btn btn-primary']")));

		int j = 0;

		for (int i = 0; i < itemsNeeded.length; i++) {

			String name = itemsNeeded[i];
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(name)) {
				j++;
				driver.findElements(By.xpath("//div[@class='card-footer']/button[@class='btn btn-info']")).get(i)
						.click();
			}

			if (j == itemsNeeded.length) {
				System.out.println(j);
				break;

			}
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}

}
