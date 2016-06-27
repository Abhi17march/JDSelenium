package pageObjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.ExcelUtils;
    public class Search_Page039 extends BaseClass
    
    {
           private static WebElement element = null;
        
        public Search_Page039(WebDriver driver)
        {
            	super(driver);
        }     
        public static WebElement Search_results(int iTestCaseRow) throws Exception
        {
        	String paraValue = null;
        	String mcat = ExcelUtils.getCellData(iTestCaseRow,
    				Constant.Col_Keywords);
        	for (int i = 0; i < 500; i++)  
    		{
    			paraValue = "'bcard" + i + "'";
    			try
    			{
    			WebElement LINKS = driver.findElement(By.xpath("//*[@id="
    					+ paraValue + "]/div[1]/section/div[1]/ul[3]/li[2]/a"));
    			String link = LINKS.getAttribute("href");
    			System.out.println(LINKS.getAttribute("href"));
    			((JavascriptExecutor) driver)
    					.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    			Thread.sleep(10);
    			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    			utility.ExcelWrite039.data.put(String.valueOf(i + 2), new Object[] {link, mcat});
    			}
    			catch (NoSuchElementException e)
    			   {
    				System.err.println("Unable to find element");
    				return element;
    				
    			   }

    		  }
			return element;

             }
        
    }
