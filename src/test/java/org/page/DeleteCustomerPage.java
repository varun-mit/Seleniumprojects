package org.page;

import org.global.GlobalClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage extends GlobalClass{
	public DeleteCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='Delete Customer']")
	private WebElement DeleteCustomer;

	public WebElement getDeleteCustomer() {
		return DeleteCustomer;
	}
}
