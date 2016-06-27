package pageObjects;
        import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;
    public class Home_Page extends BaseClass{
            private static WebElement element = null;
           public static List<WebElement> ss;
           
        public Home_Page(WebDriver driver){
            	super(driver);
        }    
        public static WebElement TextBox_City() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//*[@id='city']"));
	             Log.info("TextBox_City is found on the Home Page");
	              }
            catch (Exception e){
           		Log.error("TextBox_City is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }
        public static void dropdown_Visible() throws Exception{
            try{
            	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            	element = driver.findElement(By.xpath("//*[@id='cauto']"));
	        	System.out.println("Element visible" + element);
	        	JavascriptExecutor js=(JavascriptExecutor) driver;
	        	js.executeScript("arguments[0].setAttribute('style', 'visibility: visible;');", element);
	 		 	Log.info("dropdown_City link is visible the Home Page");
            }catch (Exception e){
            	Log.error("dropdown_City is not visible on the Home Page");
           		throw(e);
           		}
           
        }
        
        public static void dropdown_City() throws Exception{
            try{
            	WebElement element = driver.findElement(By.xpath("//*[@id='cuto']"));
            	WebDriverWait wait = new WebDriverWait(driver,30);
            	wait.until(ExpectedConditions.visibilityOf(element));
	        	System.out.println("Element visible" + element);
	 		      do {
			    ss = element.findElements(By.tagName("li"));
			   } while(ss.size() == 0);
			   Iterator<WebElement> z = ss.iterator();
			   while(z.hasNext()) {
			    WebElement s = z.next();
			    System.out.println(s.getText());
			    s.click();
			    break;
			   }   
	        
	            Log.info("dropdown_City link is found on the Home Page");
            }catch (Exception e){
            	Log.error("dropdown_City is not found on the Home Page");
           		throw(e);
           		}
           
        }
        
        public static WebElement TextBox_Keyword() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//*[@id='srchbx']"));
	             Log.info("TextBox_Keyword is found on the Home Page");
	              }
            catch (Exception e){
           		Log.error("TextBox_Keyword is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement Button_Search() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//*[@id='search']/button"));
	             Log.info("TextBox_Keyword is found on the Home Page");
	              }
            catch (Exception e){
           		Log.error("TextBox_Keyword is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }
        
      
    }
