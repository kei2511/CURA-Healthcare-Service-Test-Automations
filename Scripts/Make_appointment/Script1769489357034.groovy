import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Page_CURA Healthcare Service/btn_MakeAppointment'))

WebUI.setText(findTestObject('Page_CURA Healthcare Service/txt_username'), 'John Doe')

WebUI.setEncryptedText(findTestObject('Page_CURA Healthcare Service/txt_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('Page_CURA Healthcare Service/btn_Login'))

WebUI.waitForElementVisible(findTestObject('Page_CURA Healthcare Service/lbl_MakeAppointment'), 5)

WebUI.selectOptionByLabel(findTestObject('Page_CURA Healthcare Service/dropdown(tokyo, hongkong, seoul)'), var_facility, 
    false)

if (var_readmission == 'Yes') {
    WebUI.check(findTestObject('Page_CURA Healthcare Service/checlist_readmission'))
} else {
    WebUI.uncheck(findTestObject('Page_CURA Healthcare Service/checlist_readmission'))
}

WebUI.click(findTestObject('Page_CURA Healthcare Service/radio_Program_Dynamic', [('program_pilihan') : var_program]))

WebUI.verifyElementChecked(findTestObject('Page_CURA Healthcare Service/radio_Program_Dynamic', [('program_pilihan') : var_program]), 
    5)

WebUI.setText(findTestObject('Page_CURA Healthcare Service/txt_visit_date'), var_date)

WebUI.setText(findTestObject('Page_CURA Healthcare Service/txt_comment'), var_comment)

WebUI.click(findTestObject('Page_CURA Healthcare Service/btn_Book Appointment'))

WebUI.waitForElementVisible(findTestObject('Page_CURA Healthcare Service/lbl_Appointment Confirmation'), 5)

WebUI.click(findTestObject('Page_CURA Healthcare Service/btn_GoToHomepage'))

WebUI.waitForElementVisible(findTestObject('Page_CURA Healthcare Service/lbl_CURA Healthcare Service'), 0)

