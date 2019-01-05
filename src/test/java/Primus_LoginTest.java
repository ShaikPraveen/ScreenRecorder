import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Primus_LoginTest 
{
	
	public static WebDriver driver;
	public static  String url="http://primusbank.qedgetech.com";
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Launching_Browsers\\Launching_Browsers_Latest\\New folder\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void homepageTest() throws Exception
	{
		MyScreenRecorder.startRecordings("homepageTest");
		String pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "Primus BANK","TITLE IS NOT MATCHED");
		
		MyScreenRecorder.stopRecording();	
	}
	
	@Test
	public void loginTest()
	{
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://primusbank.qedgetech.com/adminflow.aspx");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
