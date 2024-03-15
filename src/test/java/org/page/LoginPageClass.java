package org.page;

import org.global.GlobalClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass extends GlobalClass {

	public LoginPageClass() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "uid")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

@FindBy(how=How.NAME,using="password")
private WebElement password;

	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(how=How.NAME,using="btnLogin")
	private WebElement LoginButton;
	public WebElement getLoginButton(){
		return LoginButton;
	}
	}
	

