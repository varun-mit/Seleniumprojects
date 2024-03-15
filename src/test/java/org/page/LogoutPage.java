package org.page;

import org.global.GlobalClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends GlobalClass{
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='Log out']")
	private WebElement Logout;

	public WebElement getLogout() {
		return Logout;
	}

}
