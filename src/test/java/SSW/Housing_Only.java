package SSW;

import java.util.concurrent.TimeUnit;

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

public class Housing_Only extends BrowserFactory{

	@Test
	public void Housing_FLow() throws Throwable {
		
			
//		Login.login(driver);
		wait = new WebDriverWait(driver, 60);
		xls = new XlsUtil(config.getsswexcelpath());	
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("scroll(0, -250);");  // This line will scroll to bottom of the page	
		
		boolean displayed3 = driver.findElement(By.id("LoginStatus1")).isDisplayed();
		if (displayed3) {
			xls.setCellData("Housing Only", 6, 3, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 3, "Failed");
		}
		System.out.println("Logged in successfully ");

		// Select ShowCode
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='DropDownShowCode']/following::input[1]")).sendKeys(config.getshowcode());
		driver.findElement(By.xpath("//select[@id='DropDownShowCode']/following::input[1]")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ButtonConfigureWidgets']")));
		boolean displayed6 =driver.findElement(By.xpath("//*[@id='ButtonConfigureWidgets']")).isDisplayed();
		
		if (displayed6) {
			xls.setCellData("Housing Only", 6, 6, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 6, "Failed");
		}
		System.out.println("Reached Interface Summary ");

		// Create New Housing Only Flow
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'FlowCode')]")));
//		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("//*[@id='MainContent_ButtonAddNewFlow']")));
//		jse.executeScript("scroll(0, -250);");  // This line will scroll to bottom of the page 
		
//		driver.findElement(By.xpath("//*[@id='MainContent_ButtonAddNewFlow']")).click();
		
		boolean displayed8 = driver.findElement(By.xpath("//input[contains(@id,'FlowCode')]")).isDisplayed();
		if (displayed8) {
			xls.setCellData("Housing Only", 6, 8, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 8, "Failed");
		}
		System.out.println("Reached Flow Detail Page");

		// Flow Detail page
		Select existflow = new Select(driver.findElement(By.id("DropDownSelectFlow")));
//		 existflow.selectByValue("0");
		existflow.selectByValue("1038"); // Select existing flow for debugging
		 
//		 driver.findElement(By.xpath("//input[contains(@id,'FlowCode')]")).sendKeys(config.gethouflowcode());
//		 driver.findElement(By.xpath("//input[contains(@id,'FlowDesc')]")).sendKeys(config.gethouflowname());
		
		Select houdropdown = new Select(driver.findElement(By.id("MainContent_ddlHousingType")));
		houdropdown.selectByValue("Standard");
//		driver.findElement(By.id("MainContent_TextBoxHousingOpenDate")).sendKeys(config.getflowopendate());
//		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[3]/a")).click();
//		driver.findElement(By.id("MainContent_TextBoxHousingCloseDate")).sendKeys(config.getflowenddate());
//		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a")).click();
//		driver.findElement(By.id("MainContent_TextBoxHousingReservationStartDate")).sendKeys(config.gethouarrivaldate());
//		driver.findElement(By.id("MainContent_TextBoxHousingReservationEndDate")).sendKeys(config.gethoudepdate());
		
		Select attdropdown = new Select(driver.findElement(By.id("MainContent_ddlAttendeeType")));
		attdropdown.selectByValue("Attendee");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonTask")));
		driver.findElement(By.id("MainContent_ButtonTask")).click();

		// Task overview Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ButtonContinue")));
		boolean displayed10 = driver.findElement(By.id("MainContent_ListViewTasksBasic_TextBoxDisplayName_1")).isDisplayed();
		if (displayed10) {
			xls.setCellData("Housing Only", 6, 10, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 10, "Failed");
		}
		System.out.println("Reached Task Overview page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonContinue")));
		driver.findElement(By.id("MainContent_ButtonContinue")).click();

		// Room Search Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("RepeaterConfigs_ddlConfig_0")));
		boolean displayed12 = driver.findElement(By.id("RepeaterConfigs_ddlConfig_0")).isDisplayed();
		if (displayed12) {
			xls.setCellData("Housing Only", 6, 12, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 12, "Failed");
		}
		System.out.println("Reached Room Search page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Room Occupants
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed14 = driver
				.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0"))
				.isDisplayed();
		if (displayed14) {
			xls.setCellData("Housing Only", 6, 14, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 14, "Failed");
		}
		System.out.println("Reached Room Occupants page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Configure Confirmation Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")));
		boolean displayed26 = driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")).isDisplayed();
		if (displayed26) {
			xls.setCellData("Housing Only", 6, 16, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 16, "Failed");
		}
		System.out.println("Reached Confirmation Page");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_0_txtItemValue_0")).sendKeys("www.facebook.com");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_1")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_1_txtItemValue_0")).sendKeys("Twitter Text");
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_1_txtItemValue_1")).sendKeys("https://twitter.com/");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_2")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_2_txtItemValue_0")).sendKeys("Test Email Subject");
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_2_txtItemValue_1")).sendKeys("Test Email Body");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_3")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_3_txtItemValue_0")).sendKeys("https://www.linkedin.com/");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Contact Profile Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed16 = driver.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")).isDisplayed();
		if (displayed16) {
			xls.setCellData("Housing Only", 6, 18, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 18, "Failed");
		}
		System.out.println("Reached Contact Profile Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Create New Record
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed30 = driver.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")).isDisplayed();
		if (displayed30) {
			xls.setCellData("Housing Only", 6, 20, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 20, "Failed");
		}
		System.out.println("Reached Create New Record Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		driver.findElement(By.id("ButtonSaveContinue")).click();
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();

		// Dashboard page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value,'Hotel Reservation')]")));
		boolean displayed20 = driver.findElement(By.xpath("//input[contains(@value,'Hotel Reservation')]")).isDisplayed();
		if (displayed20) {
			xls.setCellData("Housing Only", 6, 22, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 22, "Failed");
		}
		System.out.println("Reached Dashboard Page");
		boolean GEHousing = driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_1")).isSelected();
		if (GEHousing) {
			driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_1")).click();
		}

		boolean SocialMediachecked = driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_2"))
				.isSelected();
		if (SocialMediachecked) {
			driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_2")).click();
		}
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Hotel Reservation
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("MainContent_ListViewSectionActions_TextBoxDisplayName_0")));
		boolean displayed24 = driver.findElement(By.id("MainContent_ListViewSectionActions_TextBoxDisplayName_0"))
				.isDisplayed();
		if (displayed24) {
			xls.setCellData("Housing Only", 6, 24, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 24, "Failed");
		}
		System.out.println("Reached Hotel Reservation Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Dashboard Confirmation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("RepeaterConfigs_cbConfig_0")));
		boolean displayed261 = driver.findElement(By.id("RepeaterConfigs_cbConfig_0")).isDisplayed();
		if (displayed261) {
			xls.setCellData("Housing Only", 6, 26, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 26, "Failed");
		}
		System.out.println("Reached Dashboard Confirmation Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Explore Hotels
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_TextBoxGEOpenDate")));
//		driver.findElement(By.id("MainContent_TextBoxGEOpenDate")).sendKeys(config.gethouarrivaldate());
//		driver.findElement(By.id("MainContent_TextBoxGECloseDate")).sendKeys(config.gethoudepdate());
		
		boolean displayed27 = driver.findElement(By.id("MainContent_TextBoxGEOpenDate")).isDisplayed();
		if (displayed27) {
			xls.setCellData("Housing Only", 6, 28, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 28, "Failed");
		}
		System.out.println("Reached Explore Hotels Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Dashboard Connect With Socail Media
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")));
		boolean displayed40 = driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0"))
				.isDisplayed();
		if (displayed40) {
			xls.setCellData("Housing Only", 6, 30, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 30, "Failed");
		}
		System.out.println("Reached Connect With Social Media Page");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_0_txtItemValue_0")).sendKeys("Test Facebook Title");
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_0_txtItemValue_1")).sendKeys("Test Facbook Description");
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_0_txtItemValue_2")).sendKeys("https://www.facebook.com/");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_1")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_1_txtItemValue_0")).sendKeys("Test LinkedIn Text");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_2")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_2_txtItemValue_0")).sendKeys("Test Twitter Tetxt");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Flow Configured Successfully Message
		Thread.sleep(7000);
		driver.switchTo().alert();
		alertOK.accept();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ButtonConfigureWidgets")));
		boolean displayed42 = driver.findElement(By.id("ButtonConfigureWidgets")).isDisplayed();
		if (displayed42) {
			xls.setCellData("Housing Only", 6, 32, "Passed");
		} else {
			xls.setCellData("Housing Only", 6, 32, "Failed");
		}

		System.out.println("WOW!! Housing Flow Configured Successfully and reached Interface Summary  Page");

	}

}
