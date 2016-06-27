package appModules;

import pageObjects.Search_Page039;


// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Framework, please see http://www.toolsqa.com/modular-driven/ 
public class Verification_Action039 {
	 // I could have created a Function for it but I keep calculations in Functions and test steps in Module Actions
	 // It could have been avoided and simply put these steps in Test Case, it depends totally on you, everybody has their own choice
	public static void Execute() throws Exception
	{
		Search_Page039.Search_results(1);
	}
}
