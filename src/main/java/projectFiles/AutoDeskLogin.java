package projectFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoDeskLogin {
	WebDriver driver = new ChromeDriver();
	
	

	@BeforeTest()
	public void openAutoDesk() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.autodesk.in/");
		WebElement signin = driver.findElement(By.xpath("//*[@id=\"memenu\"]/div/button"));
		signin.click();
	}

	@Test
	public void loginTest() throws IOException, InterruptedException {
		FileInputStream stream = new FileInputStream("AutoDeskCredentials");
		Properties properties = new Properties();
		properties.load(stream);
		String username = properties.getProperty("Email");
		String password = properties.getProperty("Password");
		WebElement emailbox = driver.findElement(By.id("userName"));
		emailbox.sendKeys(username);
		WebElement next = driver.findElement(By.id("verify_user_btn"));
		next.click();
//    	Thread.sleep(2000);
		WebElement passwordbox = driver.findElement(By.id("password"));
		passwordbox.sendKeys(password);	
		WebElement submit = driver.findElement(By.id("btnSubmit"));
		submit.click();
		
		Thread.sleep(2000);

		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshots=screenshot.getScreenshotAs(OutputType.FILE);
		File file=new File("E://Sample.png");
		FileHandler.copy(screenshots, file);		
	}
	
	@AfterTest
	public void closeAutoDesk() {
		driver.quit();
	}
}


