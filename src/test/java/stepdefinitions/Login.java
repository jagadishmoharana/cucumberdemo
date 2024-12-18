package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;
import pages.LoginPage;

public class Login {

	WebDriver driver;
	LoginPage login;
	Homepage homepage;
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		login = new LoginPage(driver);
		homepage = new Homepage(driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("I launch browser and navigate to the login page")
	public void i_launch_browser_and_navigate_to_the_login_page() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}

	@When("I enter valid username {string} into username field")
	public void i_enter_valid_username_into_username_field(String string) {
	     
	    login.setUsername(string);
	}

	@And("I enter valid password {string} into password field")
	public void i_enter_valid_password_into_password_field(String string) {
		login.setPassword(string);
	}

	@And("I click on login button")
	public void i_click_on_login_button() {
		login.clickOnLogin();
	}

	@Then("i successfully login")
	public void i_successfully_login() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index"));
	}
	

	@When("I enter invalid username {string} into username field")
	public void i_enter_invalid_username_into_username_field(String string) {
		login.setUsername(string);
	}

	@When("I enter invalid password {string} into password field")
	public void i_enter_invalid_password_into_password_field(String string) {
		login.setPassword(string);
	}

	@When("I click on login  button to login")
	public void i_click_on_login_button_to_login() {
		login.clickOnLogin();
	}

	@Then("i should not be successfully login and get an error")
	public void i_should_not_be_successfully_login_and_get_an_error() {
		 Assert.assertTrue(! driver.getCurrentUrl().contains("dashboard/index"));
	}
	@When("I click on pim")
	public void i_click_on_pim() throws InterruptedException {
	   
	   Thread.sleep(4000);
	   homepage.clickonPim();
	}

	@Then("check url contains pim")
	public void check_url_contains_pim() throws InterruptedException {
		 Thread.sleep(4000);
	    Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewEmployeeList"));
	}
}
