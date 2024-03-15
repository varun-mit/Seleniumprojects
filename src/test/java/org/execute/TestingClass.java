package org.execute;

import java.awt.AWTException;
import java.io.IOException;

import org.global.GlobalClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.LoginPageClass;
import org.page.LogoutPage;

import org.page.NewAccountPage;
import org.page.NewCustomerPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.page.AdDismisser;
import org.page.DeleteCustomerPage;
import org.page.EditCustomerPage;
import org.page.FundTransferPage;

public class TestingClass extends GlobalClass {
	public static GlobalClass global = new GlobalClass();
	public static LoginPageClass login = new LoginPageClass();
	public static NewCustomerPage newCustomer = new NewCustomerPage();
	public static EditCustomerPage editCustomer = new EditCustomerPage();
	public static DeleteCustomerPage deleteCustomer = new DeleteCustomerPage();
	public static NewAccountPage newAccount = new NewAccountPage();
	public static FundTransferPage fundTransfer = new FundTransferPage();
	public static LogoutPage logout = new LogoutPage();
	public static AdDismisser ad = new AdDismisser();

	@Test
	public static void tc01() throws IOException {
		try {
			getWebDriver(readExcell(1, 2));
		} catch (Exception e) {
			screenCapture("Web Initialization");
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void tc02() throws IOException {
		try {
			getUrl(readExcell(1, 3));
			winMax();
			  JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("document.getElementById('card').style.display='none';");

		} catch (Exception e) {
			screenCapture("Url Initialization");
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void tc03() throws IOException {
		try {
			login = new LoginPageClass();
			WebElement username = login.getUsername();
			WebElement password = login.getPassword();
			textSend(username, readExcell(1, 0));
			textSend(password, readExcell(1, 1));
			login.getLoginButton().click();
			System.out.println("Login Successful");
			waitForElementToBePresent();
			WebElement frameElement = ad.getFrameElement();
			switchToFrame(frameElement);
			waitForElementToBePresent();
			WebElement element = ad.getElement();
			dismissAdIfPresent(element, "card");
			switchToDefaultContent();
		} catch (Exception e) {
			screenCapture("Login Credentials entry");
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void tc04() throws IOException {
		try {
			WebElement frameElement = ad.getFrameElement();
			switchToFrame(frameElement);
			waitForElementToBePresent();
			WebElement element = ad.getElement();
			dismissAdIfPresent(element, "card");
			switchToDefaultContent();
			newCustomer.getNewCustomer().click();
			newCustomer.getCustomerName().sendKeys(readExcell(1, 8));
			newCustomer.getGenderMale().click();
			newCustomer.getDOB().click();
			newCustomer.getDOB().sendKeys(readExcell(9, 8));
			global.keyboardActions("arrowleft");
			newCustomer.getDOB().sendKeys(readExcell(10, 8));
			keyboardActions("arrowleft");
			global.keyboardActions("arrowleft");
			newCustomer.getDOB().sendKeys(readExcell(11, 8));
			newCustomer.getAddress().sendKeys(readExcell(2, 8));
			newCustomer.getCity().sendKeys(readExcell(3, 8));
			newCustomer.getState().sendKeys(readExcell(4, 8));
			newCustomer.getPinNumber().sendKeys(readExcell(5, 8));
			newCustomer.getTelePhoneNumber().sendKeys(readExcell(6, 8));
			newCustomer.getEmailId().sendKeys(readExcell(7, 14));
			newCustomer.getPassword().sendKeys(readExcell(8, 8));
			newCustomer.getSubmitButton().click();
			screenCapture("New Customer Details");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			screenCapture("New Customer");
		}

	}

	@Test
	public void tc05() throws IOException {
		try {
			WebElement frameElement = ad.getFrameElement();
			switchToFrame(frameElement);
			waitForElementToBePresent();
			WebElement element = ad.getElement();
			dismissAdIfPresent(element, "card");
			switchToDefaultContent();
			editCustomer = new EditCustomerPage();
			editCustomer.getEditCustomer().click();
			editCustomer.getCustomerID().sendKeys(readExcell(13, 8));
			editCustomer.getSubmitButton().click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void tc06() {
		try {
			WebElement frameElement = ad.getFrameElement();
			switchToFrame(frameElement);
			waitForElementToBePresent();
			WebElement element = ad.getElement();
			dismissAdIfPresent(element, "card");
			switchToDefaultContent();
			deleteCustomer = new DeleteCustomerPage();
			deleteCustomer.getDeleteCustomer().click();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void tc07() throws IOException {
		try {
			newAccount = new NewAccountPage();
			waitForElementToBePresent();
			newAccount.getNewAccount().click();
			newAccount.getCustomerID().sendKeys(readExcell(13, 11));
			WebElement accountType = newAccount.getAccountType();
			selectOption(accountType, readExcell(25, 8));
			newAccount.getInitialDeposit().sendKeys(readExcell(26, 8));
			newAccount.getSubmitButton().click();
			newAccount.AlertOK();
			screenCapture("new Account Details");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void tc08() throws IOException {
		try {
			fundTransfer = new FundTransferPage();
			fundTransfer.getFundTransfer().click();
			fundTransfer.getPayerAccountNo().sendKeys(readExcell(28, 8));
			fundTransfer.getPayeeAccountNo().sendKeys(readExcell(28, 11));
			fundTransfer.getAmount().sendKeys(readExcell(36, 8));
			fundTransfer.getDescription().sendKeys("Paid");
			fundTransfer.getSubmitButton().click();
			screenCapture("Transaction Details");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void tc09() {
		try {
			logout = new LogoutPage();
			logout.getLogout().click();
			logout.AlertOK();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
