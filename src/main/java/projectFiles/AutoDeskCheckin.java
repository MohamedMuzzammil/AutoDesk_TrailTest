package projectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AutoDeskCheckin {
	WebDriver driver = new ChromeDriver();
	long beforetime;
	long aftertime;
	long totaltime;

	@BeforeSuite
	public void getWebsite() {
		beforetime=System.currentTimeMillis();
		driver.navigate().to("https://www.autodesk.com/");
	}

	@Test
	public void checkAutoCad() {
		WebElement productstab = driver.findElement(By.id("tabs-a09eca5831-item-217bae274e-tab"));
		productstab.click();
		WebElement AutoCadImg = driver.findElement(By.xpath("//*[@id=\"title-40d6cf9c83\"]/h2"));
		String value = AutoCadImg.getText();
		System.out.println(value);
		WebElement Shopall = driver.findElement(By.id("button-989db418f3"));
		Shopall.click();
		WebElement AutoCadFee = driver.findElement(
				By.xpath("//*[@id=\"text-32b7e394bf\"]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div/span[1]"));
		String AutoCadFEE = AutoCadFee.getText();
		System.out.println("The AutoCad Fee for a year is =" + AutoCadFEE);
		}
	@AfterSuite
	public void closeWebsite() {
		aftertime=System.currentTimeMillis();
		totaltime=aftertime-beforetime;
		System.out.println("Total Time Taken ="+totaltime);
		driver.quit();
	}
}
