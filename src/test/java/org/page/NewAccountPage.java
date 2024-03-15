package org.page;

import org.global.GlobalClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage extends GlobalClass{
	public NewAccountPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='New Account']")
	private WebElement NewAccount;

	public WebElement getNewAccount() {
		return NewAccount;
	}
	@FindBy(how=How.XPATH,using="//input[@name='cusid']")
	private WebElement CustomerID;
	public WebElement getCustomerID() {
		return CustomerID;
	}
	@FindBy(how=How.XPATH,using="//select[@name='selaccount']")
	private WebElement AccountType;
	public WebElement getAccountType() {
		return AccountType;
	}
	@FindBy(how=How.XPATH,using="//input[@name='inideposit']")
	private WebElement InitialDeposit;
	public WebElement getInitialDeposit() {
		return InitialDeposit;
	}
	@FindBy(how=How.XPATH,using="//input[@name='button2']")
	private WebElement SubmitButton;
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
}
