package package2;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options= new ChromeOptions();
		Proxy proxy= new Proxy();
		proxy.setHttpProxy("abc.com");
		
		Map<String, Object> prefs= new HashMap<String, Object>();
		prefs.put("download.default_directory", "Downloads");
		options.setExperimentalOption("prefs", prefs);
		
		options.setAcceptInsecureCerts(true);
		options.setCapability("proxy", proxy);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
