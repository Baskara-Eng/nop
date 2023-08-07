package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public  WebDriver init_browser(String browser) {
		
		switch (browser) {
		case "chrome":
			tldriver.set(new ChromeDriver());
			break;
		case "firefox":
			tldriver.set(new FirefoxDriver());
			break;
		case "edge":
			tldriver.set(new EdgeDriver());
			break;
		default:
			System.out.println("Enter enter browser name");
		
			
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

}
