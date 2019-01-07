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

public class Unified extends BrowserFactory {

	@Test(priority = 1)
	public void AttendeeHousingFlow_Only() throws Throwable {

				
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
			xls.setCellData("Unified", 6, 6, "Passed");
		} else {
			xls.setCellData("Unified", 6, 6, "Failed");
		}
		System.out.println("Reached Interface Summary ");
		
		// Create New Attendee Only Flow
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'FlowCode')]")));
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonAddNewFlow")));
		driver.findElement(By.xpath("//*[@id='MainContent_ButtonAddNewFlow']")).click();
		boolean displayed8 = driver.findElement(By.xpath("//input[contains(@id,'FlowCode')]")).isDisplayed();
		if (displayed8) {
			xls.setCellData("Unified", 6, 8, "Passed");
		} else {
			xls.setCellData("Unified", 6, 8, "Failed");
		}
		System.out.println("Reached Flow Detail Page");

		// Flow Detail page
		Select flowselect = new Select(driver.findElement(By.id("DropDownSelectFlow")));
//		flowselect.selectByValue("0");
		flowselect.selectByValue("1039"); // Select existing flow for debugging
		
//		driver.findElement(By.xpath("//input[contains(@id,'FlowCode')]")).sendKeys(config.getuniflowcode());
//		driver.findElement(By.xpath("//input[contains(@id,'FlowDesc')]")).sendKeys(config.getuniflowname() );
		
		// Attendee Type Selection
		Select attdropdown = new Select(driver.findElement(By.id("MainContent_ddlRegistrationType")));
		attdropdown.selectByValue("Attendee");
//		driver.findElement(By.id("MainContent_TextBoxRegOpenDate")).sendKeys(config.getflowopendate());
//		driver.findElement(By.id("MainContent_TextBoxRegCloseDate")).sendKeys(config.getflowenddate());
		
		// Housing Type Selection
		Select houdropdown = new Select(driver.findElement(By.id("MainContent_ddlHousingType")));
		houdropdown.selectByValue("Standard");
		
//		driver.findElement(By.id("MainContent_TextBoxHousingOpenDate")).sendKeys(config.getflowopendate());		
//		driver.findElement(By.id("MainContent_TextBoxHousingCloseDate")).sendKeys(config.getflowenddate());
		
//		driver.findElement(By.id("MainContent_TextBoxHousingReservationStartDate")).sendKeys(config.gethouarrivaldate());
//		driver.findElement(By.id("MainContent_TextBoxHousingReservationEndDate")).sendKeys(config.gethoudepdate());
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ddlAttendeeType")));
		Select attdropdownuni = new Select(driver.findElement(By.id("MainContent_ddlAttendeeType")));
		attdropdownuni.selectByValue("Attendee");
		driver.findElement(By.id("MainContent_ButtonTask")).click();

		// Task overview Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ListViewTasksBasic_TextBoxDisplayName_1")));
		boolean displayed10 = driver.findElement(By.id("MainContent_ListViewTasksBasic_TextBoxDisplayName_1")).isDisplayed();
		if (displayed10) {
			xls.setCellData("Unified", 6, 10, "Passed");
		} else {
			xls.setCellData("Unified", 6, 10, "Failed");
		}
		System.out.println("Reached Task Overview page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("MainContent_ButtonContinue")));
		driver.findElement(By.id("MainContent_ButtonContinue")).click();

		// Member Search Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_CheckBoxEnableCompanyMember")));
		boolean displayed12 = driver.findElement(By.id("MainContent_CheckBoxEnableCompanyMember")).isDisplayed();
		if (displayed12) {
			xls.setCellData("Unified", 6, 12, "Passed");
		} else {
			xls.setCellData("Unified", 6, 12, "Failed");
		}
		System.out.println("Reached Membership Search page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Profile page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_CheckBoxDetail_StandardBadgeFieldsetVisible")));
		boolean displayed14 = driver.findElement(By.id("MainContent_CheckBoxDetail_StandardBadgeFieldsetVisible")).isDisplayed();
		if (displayed14) {
			xls.setCellData("Unified", 6, 14, "Passed");
		} else {
			xls.setCellData("Unified", 6, 14, "Failed");
		}
		System.out.println("Reached Profile page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Show Questions page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LabelMainContentHeader")));
		boolean displayed16 = driver.findElement(By.id("LabelMainContentHeader")).isDisplayed();
		if (displayed16) {
			xls.setCellData("Unified", 6, 16, "Passed");
		} else {
			xls.setCellData("Unified", 6, 16, "Failed");
		}
		System.out.println("Reached Show Questions Page");
		
		driver.findElement(By.xpath("//a[@class='button toggle-nav-toolbar']")).click();
		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[contains(@class,'ButtonAddBirthDate')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='stickytitle']/a")).click();
		
		 /*jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//input[contains(@class,'ButtonAddPriJob')]")));
		 driver.findElement(By.xpath("//input[contains(@class,'ButtonAddPriJob')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[contains(@class,'ButtonAddPrefix')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@class='ButtonAddSecJob']")).click();
		 Thread.sleep(2000);*/
		 jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		 Thread.sleep(2000);
		 driver.findElement(By.id("ButtonSaveContinue")).click();

		// Registration Type page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_CheckBoxSkipRegTypePage")));
		boolean displayed18 = driver.findElement(By.id("MainContent_CheckBoxSkipRegTypePage")).isDisplayed();
		if (displayed18) {
			xls.setCellData("Unified", 6, 18, "Passed");
		} else {
			xls.setCellData("Unified", 6, 18, "Failed");
		}
		System.out.println("Reached Registration Page");
		 driver.findElement(By.xpath("//a[@class='button toggle-nav-toolbar']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='MainContent_ListViewAvailableRegTypes_ButtonAdd_0']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='MainContent_ListViewAvailableRegTypes_ButtonAdd_1']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[@class='stickytitle']/a")).click();
		 jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		 driver.findElement(By.id("ButtonSaveContinue")).click();

		// Guests page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_DropDownListGuestLimit")));

		boolean displayed20 = driver.findElement(By.id("MainContent_DropDownListGuestLimit")).isDisplayed();
		if (displayed20) {
			xls.setCellData("Unified", 6, 20, "Passed");
		} else {
			xls.setCellData("Unified", 6, 20, "Failed");
		}

		System.out.println("Reached Guest Page");
		Select limitdropdown = new Select(driver.findElement(By.id("MainContent_DropDownListGuestLimit")));
		limitdropdown.selectByValue("4");
		Select guestdropdown = new Select(driver.findElement(By.id("MainContent_DropDownListGuestRegType")));
		guestdropdown.selectByValue("G");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Your Events page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_CheckBoxEnableLikes")));
		
		boolean displayed22 = driver.findElement(By.id("MainContent_CheckBoxEnableLikes")).isDisplayed();
		if (displayed22) {
			xls.setCellData("Attendee Only", 6, 22, "Passed");
		} else {
			xls.setCellData("Attendee Only", 6, 22, "Failed");
		}
		
		System.out.println("Reached Your Events Page");
		driver.findElement(By.id("MainContent_CheckBoxEnableLikes")).click();
		driver.findElement(By.id("MainContent_CheckBoxEnableSearchFilterPinning")).click();
		
//		driver.findElement(By.id("MainContent_CheckBoxEnableQuickSearch")).click();
//		 driver.findElement(By.id("MainContent_ListViewQuickSearchFilter_TextBoxNewDisplayName")).click();
//		 driver.findElement(By.xpath("//input[contains(@name,'TextBoxNewDisplayName')]")).sendKeys("Sample Quick");
//		 Thread.sleep(500);
//		 driver.findElement(By.xpath("//input[contains(@name,'ButtonAddFilter')]")).click();
//		 Thread.sleep(500);
//		 driver.findElement(By.id("MainContent_ListViewQuickSearchFilter_LabelEditTracks_9")).click();
//		 driver.findElement(By.id("track-ESP")).click();
//		 Thread.sleep(500);
//		 driver.findElement(By.xpath("//span[.='Save']")).click();
		 Thread.sleep(500);
		 driver.findElement(By.id("MainContent_CheckBoxEnableKeywordSearch")).click();
		 driver.findElement(By.id("MainContent_CheckBoxEnableFilters")).click();
		
/*//		 Add Show Items
		 driver.findElement(By.xpath("//a[@class='button toggle-nav-toolbar']")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//*[contains(@value,'35MM')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[contains(@value,'A1$')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[contains(@value,'A2$')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[contains(@value,'A3$')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[contains(@value,'A4$')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[contains(@value,'A5$')]")).click();
		 Thread.sleep(1000);
		 jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(@value,'ESP1$')]")));
		 driver.findElement(By.xpath("//*[contains(@value,'ESP1$')]")).click();
		 
		 Thread.sleep(500);
		 driver.findElement(By.id("MainContent_ButtonAddConfigItems")).click();
		 Thread.sleep(500);*/
		 jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//div[@class='stickytitle']/a")));
		 driver.findElement(By.xpath("//div[@class='stickytitle']/a")).click();
		 jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		 driver.findElement(By.id("ButtonSaveContinue")).click();


		// Invite Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ddlFriendLimit")));
		boolean displayed24 = driver.findElement(By.id("MainContent_ddlFriendLimit")).isDisplayed();
		if (displayed24) {
			xls.setCellData("Unified", 6, 24, "Passed");
		} else {
			xls.setCellData("Unified", 6, 24, "Failed");
		}
		System.out.println("Reached Invite A Friend Page");
		boolean disablecheckbox = driver.findElement(By.id("CheckBoxDisableTask")).isSelected();

		if (disablecheckbox) {
			driver.findElement(By.id("CheckBoxDisableTask")).click();
		}
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		 Thread.sleep(2000);
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Room Search Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("RepeaterConfigs_ddlConfig_0")));
		boolean displayed11 = driver.findElement(By.id("RepeaterConfigs_ddlConfig_0")).isDisplayed();
		if (displayed11) {
			xls.setCellData("Unified", 6, 26, "Passed");
		} else {
			xls.setCellData("Unified", 6, 12, "Failed");
		}
		System.out.println("Reached Room Search page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Room Occupants
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed114 = driver.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")).isDisplayed();
		if (displayed114) {
			xls.setCellData("Unified", 6, 28, "Passed");
		} else {
			xls.setCellData("Unified", 6, 28, "Failed");
		}
		System.out.println("Reached Room Occupants page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Configure Confirmation Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")));
		boolean displayed26 = driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")).isDisplayed();
		if (displayed26) {
			xls.setCellData("Unified", 6, 30, "Passed");
		} else {
			xls.setCellData("Unified", 6, 30, "Failed");
		}
		System.out.println("Reached Confirmation Page");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_0_txtItemValue_0")).sendKeys("www.facebook.com");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_1")).click();
////		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_1_txtItemValue_0")).sendKeys("Twitter Text");
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_1_txtItemValue_1")).sendKeys("https://twitter.com/");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_2")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_2_txtItemValue_0")).sendKeys("Test Email Subject");
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_2_txtItemValue_1")).sendKeys("Test Email Body");
		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_3")).click();
//		driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_lvSocialMediaShareValues_3_txtItemValue_0")).sendKeys("https://www.linkedin.com/");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Contact Profile Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed116 = driver.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")).isDisplayed();
		if (displayed116) {
			xls.setCellData("Unified", 6, 32, "Passed");
		} else {
			xls.setCellData("Unified", 6, 32, "Failed");
		}
		System.out.println("Reached Contact Profile Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Create New Record
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")));
		boolean displayed30 = driver.findElement(By.id("MainContent_FieldSelectionControl1_ListViewSelectedFields_DisplayName_0")).isDisplayed();
		if (displayed30) {
			xls.setCellData("Unified", 6, 34, "Passed");
		} else {
			xls.setCellData("Unified", 6, 34, "Failed");
		}
		System.out.println("Reached Create New Record Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();	
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();

		// Dashboard page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ListViewSections_TextBoxDisplayName_0")));
		boolean displayed120 = driver.findElement(By.id("MainContent_ListViewSections_TextBoxDisplayName_0")).isDisplayed();
		if (displayed120) {
			xls.setCellData("Unified", 6, 36, "Passed");
		} else {
			xls.setCellData("Unified", 6, 36, "Failed");
		}
		System.out.println("Reached Dashboard Page");
		boolean GESessions = driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_1")).isSelected();
		if (GESessions) {
			driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_1")).click();
		}

		boolean GEHousing = driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_3")).isSelected();
		if (GEHousing) {
			driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_3")).click();
		}

		boolean SocialMediachecked = driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_4")).isSelected();
		if (SocialMediachecked) {
			driver.findElement(By.id("MainContent_ListViewSections_CheckBoxDisabled_4")).click();
		}
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Registration
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ListViewSectionActions_CheckBoxActive_0")));
		boolean displayed34 = driver.findElement(By.id("MainContent_ListViewSectionActions_CheckBoxActive_0")).isDisplayed();
		if (displayed34) {
			xls.setCellData("Unified", 6, 38, "Passed");
		} else {
			xls.setCellData("Unified", 6, 38, "Failed");
		}
		System.out.println("Reached Registration Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Sessions and Events Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_CheckBoxEnableLikes")));
		boolean displayed36 = driver.findElement(By.id("MainContent_CheckBoxEnableLikes")).isDisplayed();
		if (displayed36) {
			xls.setCellData("Unified", 6, 40, "Passed");
		} else {
			xls.setCellData("Unified", 6, 40, "Failed");
		}
		System.out.println("Reached Sessions and Events Page");
		driver.findElement(By.id("MainContent_CheckBoxEnableLikes")).click();
		driver.findElement(By.id("MainContent_CheckBoxEnableSearchFilterPinning")).click();
		Thread.sleep(500);
		driver.findElement(By.id("MainContent_CheckBoxEnableKeywordSearch")).click();
		driver.findElement(By.id("MainContent_CheckBoxEnableFilters")).click();
		
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		Thread.sleep(2000);
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
		
		// Hotel Reservation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_ListViewSectionActions_TextBoxDisplayName_0")));
		boolean displayed124 = driver.findElement(By.id("MainContent_ListViewSectionActions_TextBoxDisplayName_0")).isDisplayed();
		if (displayed124) {
			xls.setCellData("Unified", 6, 42, "Passed");
			} else {
			xls.setCellData("Unified", 6, 42, "Failed");
		}
		System.out.println("Reached Hotel Reservation Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
		// Explore Hotels
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_TextBoxGEOpenDate")));
		
//		driver.findElement(By.id("MainContent_TextBoxGEOpenDate")).sendKeys(config.gethouarrivaldate());
//		driver.findElement(By.id("MainContent_TextBoxGECloseDate")).sendKeys(config.gethoudepdate());
		Thread.sleep(500);
		
		Thread.sleep(500);
		boolean displayed27 = driver.findElement(By.id("MainContent_TextBoxGEOpenDate")).isDisplayed();
		if (displayed27) {
			xls.setCellData("Unified", 6, 44, "Passed");
		} else {
			xls.setCellData("Unified", 6, 44, "Failed");
		}
		System.out.println("Reached Explore Hotels Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();
		
		// Dashboard Confirmation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("RepeaterConfigs_cbConfig_0")));
		boolean displayed261 = driver.findElement(By.id("RepeaterConfigs_cbConfig_0")).isDisplayed();
		if (displayed261) {
			xls.setCellData("Unified", 6, 46, "Passed");
		} else {
			xls.setCellData("Unified", 6, 46, "Failed");
		}
		System.out.println("Reached Dashboard Confirmation Page");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("ButtonSaveContinue")));
		driver.findElement(By.id("ButtonSaveContinue")).click();

		// Dashboard Connect With Social Media
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")));
		boolean displayed40 = driver.findElement(By.id("MainContent_lvSocialMediaShareKeyContainers_ckIsEnabled_0")).isDisplayed();
		if (displayed40) {
			xls.setCellData("Unified", 6, 48, "Passed");
		} else {
			xls.setCellData("Unified", 6, 48, "Failed");
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

//		 Flow Configured Successfully Message
		Thread.sleep(7000);
		driver.switchTo().alert();
		alertOK.accept();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ButtonConfigureWidgets")));
		boolean displayed42 = driver.findElement(By.id("ButtonConfigureWidgets")).isDisplayed();
		if (displayed42) {
			xls.setCellData("Unified", 6, 50, "Passed");
		} else {
			xls.setCellData("Unified", 6, 50, "Failed");
			
		}
						
	}
	

}
