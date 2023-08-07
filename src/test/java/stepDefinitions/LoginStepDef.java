package stepDefinitions;

import java.util.Properties;

import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.ElementUtil;

public class LoginStepDef {
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private DashBoardPage dashBoardPage;
	

	@Given("user launch application")
	public void user_launch_application() {
	   
	   DriverFactory.getDriver().get("https://admin-demo.nopcommerce.com/login");
	}
	@When("user enters emailId as {string}")
	public void user_enters_email_id_as(String username) {
	   loginPage.enterEmailId(username);
	}
	@When("user enters password as {string}")
	public void user_enters_password_as(String password) {
	   loginPage.enterPassword(password);
	}
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	  dashBoardPage= loginPage.clickLoginBtn();
	}
	@Then("login succssful")
	public void login_succssful() {
	    System.out.println("login successful");
	}
	@Then("user navigate to dashboard page")
	public void user_navigate_to_dashboard_page() {
	  String expected=dashBoardPage.getDashboadpageTitle();
	  Assert.assertEquals(expected, "Dashboard / nopCommerce administration");
	}




}
