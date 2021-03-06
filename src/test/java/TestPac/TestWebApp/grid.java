package TestPac.TestWebApp;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class grid
{
	public WebDriver driver;
	public String URL,Node;
	@Parameters("browser")
	@BeforeTest
	public void testgrid(String browser) throws MalformedURLException
	{
	String URL="http://182.19.39.173:8090/webapp/";
	if(browser.equalsIgnoreCase("firefox"))
	{
		System.out.println("Executing on Firefox");
		String Node="http://182.19.39.173:3334/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.firefox();
		                                                                                                                                                                                                                                                                                               
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN10);
		driver=new RemoteWebDriver(new URL(Node),cap);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}
	
	else if(browser.equalsIgnoreCase("chrome"))
	{
		System.out.println("Executing on Chrome");
		//System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver_2.28.exe");
		String Node="http://182.19.39.173:3335/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		driver=new RemoteWebDriver(new URL(Node),cap);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}
	}
	
	@Test
	public void testWebApp() 
	{
		//driver.get("http://192.168.100.121:8090/SimpleWebApp");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.name("stname")).sendKeys("Vinu");
		driver.findElement(By.name("roll")).sendKeys("123");
		driver.findElement(By.name("course")).sendKeys("MCA");
		driver.findElement(By.name("fees")).sendKeys("30000");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.findElement(By.name("submit")).submit();
		/*System.out.println("Title:" +driver.getTitle());
		/*String name=driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td[2]")).getText();*/
		String title=driver.getTitle();
		if(title.equals("Welcome"))
		{
		System.out.println("******Test Case Passed,Title Verified******");
		System.out.println("You are Navigate to Next Page");
	        }
		else
		{
			System.out.println("\nTest Failed");
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}


