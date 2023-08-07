package pages;

import org.openqa.selenium.WebDriver;

public class DashBoardPage {

	private WebDriver driver;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public String getDashboadpageTitle() {
		return driver.getTitle();
	}
}
