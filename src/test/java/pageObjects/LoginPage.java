package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	//Constructor page
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	
	public void enterusername(String username) {
		txtemailAddress.sendKeys(username);
	}
	
	public void enterpassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		btnlogin.click();
	}
	
	public boolean confirmationmsg() {
		try
		{
		return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
		
	}
	

}
