package AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class ApplicationHooks {
	
	private WebDriver driver;
	private ConfigReader configReader;
	private DriverFactory driverFactory;
	Properties props;
	
	@Before(order=0)
	public void init_properties() throws IOException {
		configReader = new ConfigReader();
		props= configReader.loadProperties();
		System.out.println("properties are loaded");
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browserName= props.getProperty("browser");
		driverFactory= new DriverFactory();
		driver=driverFactory.init_browser(browserName);
		System.out.println("driver is initialized");
	}
	
	@After()
	public void tearDown() {
		driver.close();
	}

}
