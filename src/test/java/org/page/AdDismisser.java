package org.page;

import org.global.GlobalClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdDismisser extends GlobalClass {
	@FindBy(how=How.XPATH,using="//div[@style='cursor: pointer;']")
private WebElement element;
public WebElement getElement() {
	return element;
}
@FindBy(how=How.XPATH,using="//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']")
private WebElement frameElement;
public WebElement getFrameElement() {
	return frameElement;
}
}
