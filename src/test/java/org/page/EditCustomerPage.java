package org.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.global.GlobalClass;
public class EditCustomerPage extends GlobalClass{
	public EditCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='Edit Customer']")
	private WebElement EditCustomer;

	public WebElement getEditCustomer() {
		return EditCustomer;
	}
	@FindBy(how=How.XPATH, using="//input[@name='cusid']")
	private WebElement CustomerID;
	public WebElement getCustomerID() {
		return CustomerID;
	}
	@FindBy(how=How.XPATH,using="//input[@name='AccSubmit']")
	private WebElement SubmitButton;
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
}
