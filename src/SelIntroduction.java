import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nitdixit\\Desktop\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
        driver.get("http://www.rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

      

        System.out.println("Git 1");
        System.out.println("Git 2");

       // later adding
        
        System.out.println("git x 1");
        System.out.println("git x 2");
        
        
        System.out.println("Develop branch1");
        System.out.println("Develop branch2");
        driver.close();
	}

}
