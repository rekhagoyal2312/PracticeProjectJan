package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title='My Account']")
	WebElement linkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linkLogin;
	
	public void clickMyAccount() {
		linkMyaccount.click();
	}
	
	public void clickRegister() {
		linkRegister.click();
	}
	
	public void Login() {
		linkLogin.click();
	}

}


