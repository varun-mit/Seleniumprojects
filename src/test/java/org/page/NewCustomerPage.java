package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.global.GlobalClass;

public class NewCustomerPage extends GlobalClass{
	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	private WebElement NewCustomer;

	public WebElement getNewCustomer() {
		return NewCustomer;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	private WebElement CustomerName;

	public WebElement getCustomerName() {
		return CustomerName;
	}
	

	@FindBy(how = How.XPATH, using = "//input[@value='m']")
	private WebElement GenderMale;

	public WebElement getGenderMale() {
		return GenderMale;
	}
	@FindBy(how = How.ID,using="dob")
	private WebElement DOB;
	public WebElement getDOB() {
		return DOB;
	}

	@FindBy(how = How.XPATH, using = "//input[@value='f']")
	private WebElement GenderFemale;

	public WebElement getGenderFemale() {
		return GenderFemale;
	}

	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")
	private WebElement Address;

	public WebElement getAddress() {
		return Address;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	private WebElement City;

	public WebElement getCity() {
		return City;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='state']")
	private WebElement State;

	public WebElement getState() {
		return State;
	}
	@FindBy(how = How.XPATH, using = "//input[@name='pinno']")
	private WebElement PinNumber;

	public WebElement getPinNumber() {
		return PinNumber;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='telephoneno']")
	private WebElement TelePhoneNumber;

	public WebElement getTelePhoneNumber() {
		return TelePhoneNumber;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	private WebElement EmailId;

	public WebElement getEmailId() {
		return EmailId;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement Password;

	public WebElement getPassword() {
		return Password;
	}
	@FindBy(how=How.XPATH, using="//input[@name='sub']")
	private WebElement SubmitButton;
	public WebElement getSubmitButton() {
		return SubmitButton;
	}

}
