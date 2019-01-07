package SSW;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Util.BrowserFactory;
import Util.Login;
import Util.XlsUtil;

public class Exhibitor_Only extends BrowserFactory {
	
	@Test
	public void Exhibitor_Flow() throws Throwable {
			
//		Login.login(driver);
		wait = new WebDriverWait(driver, 60);
		xls = new XlsUtil(config.getsswexcelpath());
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		// Select ShowCode
		driver.findElement(By.xpath("//select[@id='DropDownShowCode']/following::input[1]")).sendKeys(config.getshowcode());
		driver.findElement(By.xpath("//select[@id='DropDownShowCode']/following::input[1]")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ButtonConfigureWidgets']")));
		boolean displayed6 =driver.findElement(By.xpath("//*[@id='ButtonConfigureWidgets']")).isDisplayed();
		if (displayed6) {
			xls.setCellData("Exhibitor Only", 6, 6, "Passed");
		} else {
			xls.setCellData("Exhibitor Only", 6, 6, "Failed");
		}
		System.out.println("Reached Interface Summary ");

		// Create New Exhibitor Only Flow
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'FlowCode')]")));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonAddNewFlow")));
		driver.findElement(By.xpath("//*[@id='MainContent_ButtonAddNewFlow']")).click();
		boolean displayed8 = driver.findElement(By.xpath("//input[contains(@id,'FlowCode')]")).isDisplayed();
		if (displayed8) {
			xls.setCellData("Exhibitor Only", 6, 8, "Passed");
		} else {
			xls.setCellData("Exhibitor Only", 6, 8, "Failed");
		}
		System.out.println("Reached Flow Detail Page");

		// Flow Detail page
		Select flowselect = new Select(driver.findElement(By.id("DropDownSelectFlow")));
//		flowselect.selectByValue("0");
		flowselect.selectByValue("1004"); // Select existing flow for debugging
//		driver.findElement(By.xpath("//input[contains(@id,'FlowCode')]")).sendKeys(config.getexhiflowcode());
//		driver.findElement(By.xpath("//input[contains(@id,'FlowDesc')]")).sendKeys(config.getexhiflowname());
		
		// Exhibitor Type Selection
		Select attdropdown = new Select(driver.findElement(By.id("MainContent_ddlRegistrationType")));
		attdropdown.selectByValue("Exhibitor");
//		driver.findElement(By.id("MainContent_TextBoxRegOpenDate")).sendKeys(config.getflowopendate());
//		driver.findElement(By.id("MainContent_TextBoxRegCloseDate")).sendKeys(config.getflowenddate());
		
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonTask")));
		driver.findElement(By.id("MainContent_ButtonTask")).click();
		
//		Task overview Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ListViewTasksBasic_TextBoxDisplayName_1")));
		boolean displayed10 = driver.findElement(By.id("MainContent_ListViewTasksBasic_TextBoxDisplayName_1")).isDisplayed();
		if (displayed10) {
			xls.setCellData("Exhibitor Only", 6, 10, "Passed");
		} else {
			xls.setCellData("Exhibitor Only", 6, 10, "Failed");
		}
		System.out.println("Reached Task Overview page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonContinue")));
		driver.findElement(By.id("MainContent_ButtonContinue")).click();		
		
//		Group Summary page
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='Field Configuration']")));
		boolean displayed11 = driver.findElement(By.xpath("//*[text()='Field Configuration']")).isDisplayed();
		if (displayed11) {
			xls.setCellData("Exhibitor Only", 6, 12, "Passed");
		} else {
			xls.setCellData("Exhibitor Only", 6, 12, "Failed");
		}
		
		driver.findElement(By.xpath("//input[@class='ButtonAddE']")).click();
//		driver.findElement(By.xpath("//input[@class='ButtonAddF']")).click();
		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
		// Contact Profile Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed116 = driver.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")).isDisplayed();
		if (displayed116) {
			xls.setCellData("Exhibitor Only", 6, 14, "Passed");
		} else {
			xls.setCellData("Exhibitor Only", 6, 14, "Failed");
		}
		System.out.println("Reached Contact Profile Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		Thread.sleep(500);
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		
		// Dashboard page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'Manage Group')]")));
		boolean displayed120 = driver.findElement(By.xpath("//input[contains(@value,'Manage Group')]")).isDisplayed();
		if (displayed120) {
			xls.setCellData("Exhibitor Only", 6, 16, "Passed");
		} else {
			xls.setCellData("Exhibitor Only", 6, 16, "Failed");
		}
		System.out.println("Reached Dashboard Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
//		Flow Configured Successfully Message
		Thread.sleep(7000);
		alertOK.accept();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ButtonConfigureWidgets")));
		boolean displayed42 = driver.findElement(By.id("ButtonConfigureWidgets")).isDisplayed();
		if (displayed42) {
			xls.setCellData("Exhibitor Only", 6, 18, "Passed");
		} else {
			xls.setCellData("Exhibitor Only", 6, 18, "Failed");
		}
		
				
	}
}
