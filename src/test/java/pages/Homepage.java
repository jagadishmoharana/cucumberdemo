package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver ;
	public Homepage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@class=\"oxd-main-menu-item-wrapper\"]//span[.=\"PIM\"]")
	WebElement pimloc;
	
	public void clickonPim() {
		pimloc.click();
	}
}
