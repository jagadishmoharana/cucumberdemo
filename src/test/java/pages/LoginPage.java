package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver ;
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@name='username']")
	WebElement usernameLoc;
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement passwordLoc;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement loginBtnLoc;
	
	
	public void setUsername(String str) {
		usernameLoc.sendKeys(str);
	}
	public void setPassword(String str) {
		passwordLoc.sendKeys(str);
	}
	public void clickOnLogin() {
		loginBtnLoc.click();
	}
	
}
