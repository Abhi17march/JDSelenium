package appModules;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
     
    // This is called Modularization, when we club series of actions in to one Module
	// For Modular Driven Framework, please see http://www.toolsqa.com/modular-driven/   
    public class SignIn_Action {
    	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
    	// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method
    	// For use of Functions & Parameters, please see http://www.toolsqa.com/function-parameters/
        public static void Execute(int iTestCaseRow) throws Exception{
        	
        	// Clicking on the My Account link on the Home Page
        	Home_Page.TextBox_City().clear();
        	String City = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_City);
        	Home_Page.TextBox_City().sendKeys(City);
        	//Home_Page.dropdown_Visible();
        	Home_Page.dropdown_City();
        	Log.info("City is selcted in Home page" );
            String Keywords = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Keywords);
            Home_Page.TextBox_Keyword().sendKeys(Keywords);
            Log.info(Keywords+" is entered in Search text box" );
            Thread.sleep(10);
            Home_Page.Button_Search().click();
            Log.info("Click action is performed on Submit button");
                      
        }
    }
