package org.page;

import org.global.GlobalClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage extends GlobalClass{
	public FundTransferPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='Fund Transfer']")
	private WebElement FundTransfer;

	public WebElement getFundTransfer() {
		return FundTransfer;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='payersaccount']")
	private WebElement PayerAccountNo;
	public WebElement getPayerAccountNo() {
		return PayerAccountNo;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='payeeaccount']")
	private WebElement PayeeAccountNo;
	public WebElement getPayeeAccountNo() {
		return PayeeAccountNo;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='ammount']")
	private WebElement Amount;
	public WebElement getAmount() {
		return Amount;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='desc']")
	private WebElement Description;
	public WebElement getDescription() {
		return Description;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='AccSubmit']")
	private WebElement SubmitButton;
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
}
