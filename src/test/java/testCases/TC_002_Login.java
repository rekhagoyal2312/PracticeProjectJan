package testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestBase;

public class TC_002_Login extends TestBase {

	@Test (groups= {"master","sanity"})
	
	public void test_login()  {
		logger.info("LoginTestStarted");
		try
		{
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.Login();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.enterusername(rb.getString("email"));
		lp.enterpassword(rb.getString("password"));
		lp.clickOnLoginButton();
		
		boolean msges=lp.confirmationmsg();
		
		if(msges) {
			logger.info("Login Success ");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login Failed ");
			captureScreen(driver, "test_Login"); //Capturing screenshot
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e) {
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_Login ");
			
		}
		
	}
	
	


