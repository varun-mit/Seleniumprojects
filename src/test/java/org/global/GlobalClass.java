package org.global;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalClass {
	public static WebDriver driver;
	public static String password;
	public static String value;
	public static String date;
	public static Sheet sheet;
	

	public static void getWebDriver(String browsertype) {
		switch (browsertype) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Edge":
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid_Browser_Type");
			break;
		}
	}

	public static void winMax() {
		driver.manage().window().maximize();
	}

	public static String readExcell(int rowIndex, int cellIndex) throws IOException {
		// defining the file location
		File file = new File("D:\\PracticeAutomation.xlsx");
		// get file as input
		FileInputStream stream = new FileInputStream(file); // throws FileNotFound Exception
		// To check the type of book(XSSF or HSSF)
		Workbook book = new XSSFWorkbook(stream); // throws IOException (which is the superclass of
													// FileNotFoundException)
		// To get sheet from workbook
		sheet = book.getSheet("Sheet1");
		// To get row from the sheet
		Row row = sheet.getRow(rowIndex);
		// To get cell from row
		Cell cell = row.getCell(cellIndex);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MMMM/yyyy");
				value = simple.format(dateCellValue);

			} else {
				DecimalFormat df = new DecimalFormat("#");
                value = df.format(cell.getNumericCellValue());
			}
			break;

		default:
			break;
		}
		return value;

	}

	public static void screenCapture(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File location = new File("D:\\Screenshots\\" + name + ".png");
		FileUtils.copyFile(screenshotAs, location);

	}

	public static void sleep(int count) throws InterruptedException {
		Thread.sleep(count);
	}

	public static void click(WebElement element) {
		element.click();

	}

	public static void textSend(WebElement element, String emailId) {
		element.sendKeys(emailId);
	}
	public static void PageScrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	public static void PageScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
		
	}
	public static void PageScrollTop(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0, 0)");
		
	}
	public static void PageScrollEnd (WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
		
	}
	public static  void PageRefresh() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	public void PageAlert(String content) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+content+"')");
	}
	public void AlertOK() {
		 driver.switchTo().alert().accept();
	}
	public void AlertCancel() {
		driver.switchTo().alert().dismiss();
	}
	public void keyboardActions(String press) throws AWTException {
		Robot robot = new Robot();
		switch (press.toLowerCase()) {
		 case "arrowup":
             robot.keyPress(KeyEvent.VK_UP);
             robot.keyRelease(KeyEvent.VK_UP);
             break;
         case "arrowdown":
             robot.keyPress(KeyEvent.VK_DOWN);
             robot.keyRelease(KeyEvent.VK_DOWN);
             break;
         case "arrowleft":
             robot.keyPress(KeyEvent.VK_LEFT);
             robot.keyRelease(KeyEvent.VK_LEFT);
             break;
         case "arrowright":
             robot.keyPress(KeyEvent.VK_RIGHT);
             robot.keyRelease(KeyEvent.VK_RIGHT);
             break;
         case "enter":
             robot.keyPress(KeyEvent.VK_ENTER);
             robot.keyRelease(KeyEvent.VK_ENTER);
             break;
         case "tab":
             robot.keyPress(KeyEvent.VK_TAB);
             robot.keyRelease(KeyEvent.VK_TAB);
             break;
         case "backspace":
             robot.keyPress(KeyEvent.VK_BACK_SPACE);
             robot.keyRelease(KeyEvent.VK_BACK_SPACE);
             break;
         case "delete":
             robot.keyPress(KeyEvent.VK_DELETE);
             robot.keyRelease(KeyEvent.VK_DELETE);
             break;
         case "esc":
         case "escape":
             robot.keyPress(KeyEvent.VK_ESCAPE);
             robot.keyRelease(KeyEvent.VK_ESCAPE);
             break;
         case "ctrl":
             robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             break;
         case "alt":
             robot.keyPress(KeyEvent.VK_ALT);
             robot.keyRelease(KeyEvent.VK_ALT);
             break;
         case "shift":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "capslock":
             robot.keyPress(KeyEvent.VK_CAPS_LOCK);
             robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
             break;
         case "space":
             robot.keyPress(KeyEvent.VK_SPACE);
             robot.keyRelease(KeyEvent.VK_SPACE);
             break;
         case "pageup":
             robot.keyPress(KeyEvent.VK_PAGE_UP);
             robot.keyRelease(KeyEvent.VK_PAGE_UP);
             break;
         case "pagedown":
             robot.keyPress(KeyEvent.VK_PAGE_DOWN);
             robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
             break;
         case "home":
             robot.keyPress(KeyEvent.VK_HOME);
             robot.keyRelease(KeyEvent.VK_HOME);
             break;
         case "end":
             robot.keyPress(KeyEvent.VK_END);
             robot.keyRelease(KeyEvent.VK_END);
             break;
         case "insert":
             robot.keyPress(KeyEvent.VK_INSERT);
             robot.keyRelease(KeyEvent.VK_INSERT);
             break;
         case "a":
             robot.keyPress(KeyEvent.VK_A);
             robot.keyRelease(KeyEvent.VK_A);
             break;
         case "b":
             robot.keyPress(KeyEvent.VK_B);
             robot.keyRelease(KeyEvent.VK_B);
             break;
         case "c":
             robot.keyPress(KeyEvent.VK_C);
             robot.keyRelease(KeyEvent.VK_C);
             break;
         case "d":
             robot.keyPress(KeyEvent.VK_D);
             robot.keyRelease(KeyEvent.VK_D);
             break;
         case "e":
             robot.keyPress(KeyEvent.VK_E);
             robot.keyRelease(KeyEvent.VK_E);
             break;
         case "f":
             robot.keyPress(KeyEvent.VK_F);
             robot.keyRelease(KeyEvent.VK_F);
             break;
         case "g":
             robot.keyPress(KeyEvent.VK_G);
             robot.keyRelease(KeyEvent.VK_G);
             break;
         case "h":
             robot.keyPress(KeyEvent.VK_H);
             robot.keyRelease(KeyEvent.VK_H);
             break;
         case "i":
             robot.keyPress(KeyEvent.VK_I);
             robot.keyRelease(KeyEvent.VK_I);
             break;
         case "j":
             robot.keyPress(KeyEvent.VK_J);
             robot.keyRelease(KeyEvent.VK_J);
             break;
         case "k":
             robot.keyPress(KeyEvent.VK_K);
             robot.keyRelease(KeyEvent.VK_K);
             break;
         case "l":
             robot.keyPress(KeyEvent.VK_L);
             robot.keyRelease(KeyEvent.VK_L);
             break;
         case "m":
             robot.keyPress(KeyEvent.VK_M);
             robot.keyRelease(KeyEvent.VK_M);
             break;
         case "n":
             robot.keyPress(KeyEvent.VK_N);
             robot.keyRelease(KeyEvent.VK_N);
             break;
         case "o":
             robot.keyPress(KeyEvent.VK_O);
             robot.keyRelease(KeyEvent.VK_O);
             break;
         case "p":
             robot.keyPress(KeyEvent.VK_P);
             robot.keyRelease(KeyEvent.VK_P);
             break;
         case "q":
             robot.keyPress(KeyEvent.VK_Q);
             robot.keyRelease(KeyEvent.VK_Q);
             break;
         case "r":
             robot.keyPress(KeyEvent.VK_R);
             robot.keyRelease(KeyEvent.VK_R);
             break;
         case "s":
             robot.keyPress(KeyEvent.VK_S);
             robot.keyRelease(KeyEvent.VK_S);
             break;
         case "t":
             robot.keyPress(KeyEvent.VK_T);
             robot.keyRelease(KeyEvent.VK_T);
             break;
         case "u":
             robot.keyPress(KeyEvent.VK_U);
             robot.keyRelease(KeyEvent.VK_U);
             break;
         case "v":
             robot.keyPress(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_V);
             break;
         case "w":
             robot.keyPress(KeyEvent.VK_W);
             robot.keyRelease(KeyEvent.VK_W);
             break;
         case "x":
             robot.keyPress(KeyEvent.VK_X);
             robot.keyRelease(KeyEvent.VK_X);
             break;
         case "y":
             robot.keyPress(KeyEvent.VK_Y);
             robot.keyRelease(KeyEvent.VK_Y);
             break;
         case "z":
             robot.keyPress(KeyEvent.VK_Z);
             robot.keyRelease(KeyEvent.VK_Z);
             break;
         case "f1":
             robot.keyPress(KeyEvent.VK_F1);
             robot.keyRelease(KeyEvent.VK_F1);
             break;
         case "f2":
             robot.keyPress(KeyEvent.VK_F2);
             robot.keyRelease(KeyEvent.VK_F2);
             break;
         case "f3":
             robot.keyPress(KeyEvent.VK_F3);
             robot.keyRelease(KeyEvent.VK_F3);
             break;
         case "f4":
             robot.keyPress(KeyEvent.VK_F4);
             robot.keyRelease(KeyEvent.VK_F4);
             break;
         case "f5":
             robot.keyPress(KeyEvent.VK_F5);
             robot.keyRelease(KeyEvent.VK_F5);
             break;
         case "f6":
             robot.keyPress(KeyEvent.VK_F6);
             robot.keyRelease(KeyEvent.VK_F6);
             break;
         case "f7":
             robot.keyPress(KeyEvent.VK_F7);
             robot.keyRelease(KeyEvent.VK_F7);
             break;
         case "f8":
             robot.keyPress(KeyEvent.VK_F8);
             robot.keyRelease(KeyEvent.VK_F8);
             break;
         case "f9":
             robot.keyPress(KeyEvent.VK_F9);
             robot.keyRelease(KeyEvent.VK_F9);
             break;
         case "f10":
             robot.keyPress(KeyEvent.VK_F10);
             robot.keyRelease(KeyEvent.VK_F10);
             break;
         case "f11":
             robot.keyPress(KeyEvent.VK_F11);
             robot.keyRelease(KeyEvent.VK_F11);
             break;
         case "f12":
             robot.keyPress(KeyEvent.VK_F12);
             robot.keyRelease(KeyEvent.VK_F12);
             break;
         case "`":
             robot.keyPress(KeyEvent.VK_BACK_QUOTE);
             robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
             break;
         case "1":
             robot.keyPress(KeyEvent.VK_1);
             robot.keyRelease(KeyEvent.VK_1);
             break;
         case "2":
             robot.keyPress(KeyEvent.VK_2);
             robot.keyRelease(KeyEvent.VK_2);
             break;
         case "3":
             robot.keyPress(KeyEvent.VK_3);
             robot.keyRelease(KeyEvent.VK_3);
             break;
         case "4":
             robot.keyPress(KeyEvent.VK_4);
             robot.keyRelease(KeyEvent.VK_4);
             break;
         case "5":
             robot.keyPress(KeyEvent.VK_5);
             robot.keyRelease(KeyEvent.VK_5);
             break;
         case "6":
             robot.keyPress(KeyEvent.VK_6);
             robot.keyRelease(KeyEvent.VK_6);
             break;
         case "7":
             robot.keyPress(KeyEvent.VK_7);
             robot.keyRelease(KeyEvent.VK_7);
             break;
         case "8":
             robot.keyPress(KeyEvent.VK_8);
             robot.keyRelease(KeyEvent.VK_8);
             break;
         case "9":
             robot.keyPress(KeyEvent.VK_9);
             robot.keyRelease(KeyEvent.VK_9);
             break;
         case "0":
             robot.keyPress(KeyEvent.VK_0);
             robot.keyRelease(KeyEvent.VK_0);
             break;
         case "-":
             robot.keyPress(KeyEvent.VK_MINUS);
             robot.keyRelease(KeyEvent.VK_MINUS);
             break;
         case "=":
             robot.keyPress(KeyEvent.VK_EQUALS);
             robot.keyRelease(KeyEvent.VK_EQUALS);
             break;
         case "~":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_BACK_QUOTE);
             robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "!":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_1);
             robot.keyRelease(KeyEvent.VK_1);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "@":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_2);
             robot.keyRelease(KeyEvent.VK_2);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "#":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_3);
             robot.keyRelease(KeyEvent.VK_3);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "$":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_4);
             robot.keyRelease(KeyEvent.VK_4);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "%":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_5);
             robot.keyRelease(KeyEvent.VK_5);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "^":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_6);
             robot.keyRelease(KeyEvent.VK_6);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "&":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_7);
             robot.keyRelease(KeyEvent.VK_7);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "*":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_8);
             robot.keyRelease(KeyEvent.VK_8);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "(":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_9);
             robot.keyRelease(KeyEvent.VK_9);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case ")":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_0);
             robot.keyRelease(KeyEvent.VK_0);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "_":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_MINUS);
             robot.keyRelease(KeyEvent.VK_MINUS);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "+":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_EQUALS);
             robot.keyRelease(KeyEvent.VK_EQUALS);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "[":
             robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
             robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
             break;
         case "]":
             robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
             robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
             break;
         case "\\":
             robot.keyPress(KeyEvent.VK_BACK_SLASH);
             robot.keyRelease(KeyEvent.VK_BACK_SLASH);
             break;
         case "{":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
             robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "}":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
             robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "|":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_BACK_SLASH);
             robot.keyRelease(KeyEvent.VK_BACK_SLASH);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case ";":
             robot.keyPress(KeyEvent.VK_SEMICOLON);
             robot.keyRelease(KeyEvent.VK_SEMICOLON);
             break;
         case ":":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_SEMICOLON);
             robot.keyRelease(KeyEvent.VK_SEMICOLON);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "'":
             robot.keyPress(KeyEvent.VK_QUOTE);
             robot.keyRelease(KeyEvent.VK_QUOTE);
             break;
         case "\"":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_QUOTE);
             robot.keyRelease(KeyEvent.VK_QUOTE);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case ",":
             robot.keyPress(KeyEvent.VK_COMMA);
             robot.keyRelease(KeyEvent.VK_COMMA);
             break;
         case "<":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_COMMA);
             robot.keyRelease(KeyEvent.VK_COMMA);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case ".":
             robot.keyPress(KeyEvent.VK_PERIOD);
             robot.keyRelease(KeyEvent.VK_PERIOD);
             break;
         case ">":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_PERIOD);
             robot.keyRelease(KeyEvent.VK_PERIOD);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
         case "/":
             robot.keyPress(KeyEvent.VK_SLASH);
             robot.keyRelease(KeyEvent.VK_SLASH);
             break;
         case "?":
             robot.keyPress(KeyEvent.VK_SHIFT);
             robot.keyPress(KeyEvent.VK_SLASH);
             robot.keyRelease(KeyEvent.VK_SLASH);
             robot.keyRelease(KeyEvent.VK_SHIFT);
             break;
		default:
			System.out.println("InValid_Key_Action" + press);
			break;
		}
	}
	public static  void waitForElementToBePresent() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void getUrl(String Url) {
		driver.get(Url);
		
	}
	public static void selectOption( WebElement element, String option ) {
        Select select = new Select(element);

        String optionValue = String.valueOf(option);

        try {
            // Try selecting by visible text
            select.selectByVisibleText(optionValue);
        } catch (Exception e) {
            // If not successful, try selecting by value
            select.selectByValue(optionValue);
        }

	}
	public static void dismissAdIfPresent(WebElement element, String adType) {
	    try {
	        // Click the dismiss button to close the ad pop-up
	        if (element.isDisplayed()) {
	            element.click();
	            System.out.println(adType + " Ad pop-up dismissed.");
	        }
	    } catch (Exception e) {
	        // Handle any exceptions or log messages related to the ad pop-up dismissal
	        System.out.println(adType + " Ad pop-up not present or could not be dismissed: " + e.getMessage());
	    }
	}
	public static void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }
	public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

	
}
