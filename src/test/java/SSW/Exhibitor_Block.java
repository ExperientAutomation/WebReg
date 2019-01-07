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

public class Exhibitor_Block extends BrowserFactory{	

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
			xls.setCellData("Exhibitor Block", 6, 6, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 6, "Failed");
		}
		System.out.println("Reached Interface Summary ");

		// Create New Exhibitor Block Flow			
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'FlowCode')]")));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonAddNewFlow")));
		driver.findElement(By.xpath("//*[@id='MainContent_ButtonAddNewFlow']")).click();
		boolean displayed8 = driver.findElement(By.xpath("//input[contains(@id,'FlowCode')]")).isDisplayed();
		if (displayed8) {
			xls.setCellData("Exhibitor Block", 6, 8, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 8, "Failed");
		}
		System.out.println("Reached Flow Detail Page");

		// Flow Detail page
		Select flowselect = new Select(driver.findElement(By.id("DropDownSelectFlow")));
//		flowselect.selectByValue("0");
		flowselect.selectByValue("1005"); // Select existing flow for debugging
//		driver.findElement(By.xpath("//input[contains(@id,'FlowCode')]")).sendKeys(config.getexhiblkflowcode());
//		driver.findElement(By.xpath("//input[contains(@id,'FlowDesc')]")).sendKeys(config.getexhiblkflowname());
		
//		Exhibitor Type Selection
		Select attdropdown = new Select(driver.findElement(By.id("MainContent_ddlRegistrationType")));
		attdropdown.selectByValue("Exhibitor");
		
//		driver.findElement(By.id("MainContent_TextBoxRegOpenDate")).sendKeys(config.getflowopendate());
//		driver.findElement(By.id("MainContent_TextBoxRegCloseDate")).sendKeys(config.getflowenddate());
	
		Select houdropdown = new Select(driver.findElement(By.id("MainContent_ddlHousingType")));
		houdropdown.selectByValue("Block");
		Thread.sleep(1500);
			
//		driver.findElement(By.xpath("//input[@id='MainContent_TextBoxHousingOpenDate']")).sendKeys(config.getflowopendate());	
//		driver.findElement(By.id("MainContent_TextBoxHousingCloseDate")).sendKeys(config.getflowenddate());
		
//		driver.findElement(By.xpath("//input[@id='MainContent_TextBoxHousingReservationStartDate']")).sendKeys(config.gethouarrivaldate());
//		driver.findElement(By.xpath("//input[@id='MainContent_TextBoxHousingReservationEndDate']")).sendKeys(config.gethoudepdate());
	
//		driver.findElement(By.id("MainContent_TextBoxRABOpen")).sendKeys(config.getflowopendate());
//		driver.findElement(By.id("MainContent_TextBoxRABClose")).sendKeys(config.getflowenddate());
	
		Select blktype = new Select(driver.findElement(By.id("MainContent_ddlBlockManagementType")));
		blktype.selectByValue("RAB");
		
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ddlAttendeeType")));
		Select atttype = new Select(driver.findElement(By.id("MainContent_ddlAttendeeType")));
		atttype.selectByValue("Exhibitor Block");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonTask")));
		driver.findElement(By.id("MainContent_ButtonTask")).click();
					
//		Task overview Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ListViewTasksBasic_TextBoxDisplayName_1")));
		boolean displayed10 = driver.findElement(By.id("MainContent_ListViewTasksBasic_TextBoxDisplayName_1")).isDisplayed();
		if (displayed10) {
			xls.setCellData("Exhibitor Block", 6, 10, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 10, "Failed");
		}
		System.out.println("Reached Task Overview page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonContinue")));
		driver.findElement(By.id("MainContent_ButtonContinue")).click();	

//		Hold Room Search page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("RepeaterConfigs_ddlConfig_0")));
		boolean displayed11 = driver.findElement(By.id("RepeaterConfigs_ddlConfig_0")).isDisplayed();
		if (displayed11) {
			xls.setCellData("Exhibitor Block", 6, 12, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 12, "Failed");
		}
		System.out.println("Reached Hold Room Search page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
//		Group Summary page
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='Field Configuration']")));
		boolean displayed111 = driver.findElement(By.xpath("//*[text()='Field Configuration']")).isDisplayed();
		if (displayed111) {
			xls.setCellData("Exhibitor Block", 6, 14, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 14, "Failed");
		}
		Thread.sleep(500);
//		driver.findElement(By.xpath("//*[text()='RegType Configuration']")).click();
		driver.findElement(By.xpath("//input[@class='ButtonAddE']")).click();
		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
		// Room Search Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("RepeaterConfigs_ddlConfig_0")));
		boolean displayed12 = driver.findElement(By.id("RepeaterConfigs_ddlConfig_0")).isDisplayed();
		if (displayed12) {
			xls.setCellData("Exhibitor Block", 6, 16, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 16, "Failed");
		}
		System.out.println("Reached Room Search page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
		// Room Occupants
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed14 = driver.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")).isDisplayed();
		if (displayed14) {
			xls.setCellData("Exhibitor Block", 6, 18, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 18, "Failed");
		}
		System.out.println("Reached Room Occupants page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
		// Contact Profile Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed16 = driver.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")).isDisplayed();
		if (displayed16) {
			xls.setCellData("Exhibitor Block", 6, 20, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 20, "Failed");
		}
		System.out.println("Reached Contact Profile Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		Thread.sleep(500);
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		
		// Dashboard page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'Hotel Reservation')]")));
		boolean displayed120 = driver.findElement(By.xpath("//input[contains(@value,'Hotel Reservation')]")).isDisplayed();
		if (displayed120) {
			xls.setCellData("Exhibitor Block", 6, 22, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 22, "Failed");
		}
		System.out.println("Reached Dashboard Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
//		Dashboard Hold Rooms
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ddlAttendeeType")));
		boolean displayed121 = driver.findElement(By.id("MainContent_ddlAttendeeType")).isDisplayed();
		if (displayed121) {
			xls.setCellData("Exhibitor Block", 6, 24, "Passed");
		} else {	
			xls.setCellData("Exhibitor Block", 6, 24, "Failed");
		}
		
		Select holdroom = new Select(driver.findElement(By.id("MainContent_ddlAttendeeType")));
		holdroom.selectByValue("Exhibitor Block");
		
		System.out.println("Reached Dashboard Hold Rooms Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
				
//		Dashboard Hotel Reservation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ListViewSectionActions_TextBoxDisplayName_0")));
		boolean displayed122 = driver.findElement(By.id("MainContent_ListViewSectionActions_TextBoxDisplayName_0")).isDisplayed();
		if (displayed122) {
			xls.setCellData("Exhibitor Block", 6, 26, "Passed");
		} else {
			xls.setCellData("Exhibitor Block", 6, 26, "Failed");
		}
		System.out.println("Reached Dashboard Hotel Reservation Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
//		Flow Configured Successfully Message
		Thread.sleep(7000);
		driver.switchTo().alert();
		alertOK.accept();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ButtonConfigureWidgets")));
		boolean displayed42 = driver.findElement(By.id("ButtonConfigureWidgets")).isDisplayed();
		if (displayed42) {
			xls.setCellData("Exhibitor Only", 6, 28, "Passed");
		} else {
			xls.setCellData("Exhibitor Only", 6, 28, "Failed");
		}
						
	}
	
}
