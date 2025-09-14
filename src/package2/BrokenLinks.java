package package2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class BrokenLinks {


	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);  // Ignore SSL errors

		System.setProperty("webdriver.chrome.driver","C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//broken link=broker URL (url nt working)
		//java method call the urls and gets you the status code
		//stpe 1 get all url tied up to the links using selenium
		//java method call the urls and gets you the status code
		//if status code greater then 400 then  that url is not working and it is broken link
		//a[@href='https://www.soapui.org/']
		
		SoftAssert a = new SoftAssert();
		
		List<WebElement> links =driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		for(WebElement link: links)
		{
			link.getAttribute("href");
			
			
			String url=	link.getAttribute("href");
				System.out.println(url);
				
				HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				
				int responseCode=conn.getResponseCode();
				System.out.println(responseCode);
				
				a.assertTrue(responseCode<400, url);
				
				
		}
		a.assertAll();
		
		
		
		
		
	
		
		
		
	}

}
