package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private By emailID= By.id("Email");
	private By password=By.id("Password");
	private By loginBtn=By.xpath("//button[@type=\"submit\"]");
	ElementUtil util= new ElementUtil();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterEmailId(String email) {
		WebElement webElement=driver.findElement(emailID);
		util.enterTextIntoTextBox(webElement, 10,email);
	}
	
	public void enterPassword(String pwd) {
		WebElement webElement=driver.findElement(password);
		util.enterTextIntoTextBox(webElement, 10,pwd);
	}
	
	public DashBoardPage clickLoginBtn() {
		WebElement webElement=driver.findElement(loginBtn);
		util.clickElement(webElement, 10);
		return new DashBoardPage(driver);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
