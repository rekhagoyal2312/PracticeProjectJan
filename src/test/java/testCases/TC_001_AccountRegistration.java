package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountResgistrationPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_001_AccountRegistration extends TestBase{

	

	@Test (groups= {"master","reg"})
	
	public void test_account_resgistration() {
		try {
		logger.info("test_account_resgistration started");
		driver.get(rb.getString("appURL"));
		logger.info("Open URL");
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("Registeration page open");
		
		AccountResgistrationPage regpage = new AccountResgistrationPage(driver);
		regpage.setFirstName("John");
		regpage.setLastName("Canedy");
		regpage.setEmail(randomestring()+"@gmail.com");
		regpage.setTelephone("65656565");
		regpage.setPassword("abcxyz");
		regpage.setConfirmPassword("abcxyz");
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("All the data filed");
		
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			logger.info("TestPass");
		}else {
			Assert.assertTrue(false);
			logger.error("Testfailed");
			captureScreen(driver,"test_account_resgistration");
		}
		}catch(Exception e)
		{
			logger.error("Testfailed");
			Assert.fail();
		}
		
	}
	
}
