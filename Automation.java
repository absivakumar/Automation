import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;

//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class Automation {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://www.google.com/";
        String expectedTitle = "Google";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        
        WebElement ele = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input"));
        ele.sendKeys("facebook");
     // get the actual value of the title
        actualTitle = driver.getTitle();
        
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Title Verification: Test Passed!");
        } 
        else
        {
        	  System.out.println("Title Verification: Test failed!");
        }
      
        
         ele = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
        
         
      // Create object of Action class
      Actions action = new Actions(driver);
       
      // Sendkeys using Action class object
      action.sendKeys(Keys.ENTER).build().perform();
      
      //Getting first Link
      List<WebElement> eles = driver.findElements(By.xpath("//h3"));
      ele = eles.get(0);
      ele.click();
      
      
      //FirstName
      ele=driver.findElement(By.xpath("//*[@id='u_0_n']"));
      ele.sendKeys("Mathi");
      
      //lastName
      ele=driver.findElement(By.xpath("//*[@id='u_0_p']"));
      ele.sendKeys("Kuamr");
      
      //password
      
      ele=driver.findElement(By.cssSelector("#u_0_x"));
      ele.sendKeys("Kuamr@01");
      
      //Phone
      ele=driver.findElement(By.cssSelector("#u_0_s"));
      ele.sendKeys("1234567890");
      
      //gender
      ele=driver.findElement(By.cssSelector("#u_0_6"));
      ele.click();
      
      //date
      ele = driver.findElement(By.cssSelector("#day"));
      
      Select date = new Select(ele);
      
      date.selectByVisibleText("22");

      //Btn Sign up   
      ele=driver.findElement(By.cssSelector("#u_0_14"));
      
      
      
      ele.click();
        
       
      ele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#reg_error_inner")));
    	
    	 //ele=driver.findElement(By.cssSelector("#reg_error_inner"));
     	String errormsg =  ele.getText();
    	
        if(errormsg==null)
         {
        	System.out.println("Sign Up Verification: Test passed!");
         }
        else
        {
        	System.out.println("Sign Up Failed!");
        	 try {
        	
        	if(errormsg!=null)
        	System.out.println("Test Failed due to "+ errormsg + "!");
        			takeSnapShot(driver, "C://Automationtest/1.png") ;
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}  
        }
          
        //close Driver
       driver.close();
       
    }
    
    
    
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
    	//Convert web driver object to TakeScreenshot
    	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    	//Call getScreenshotAs method to create image file
    	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    	//Move image file to new destination
    	File DestFile=new File(fileWithPath);
    	//Copy file at destination
    	FileUtils.copyFile(SrcFile, DestFile);
    	}

}