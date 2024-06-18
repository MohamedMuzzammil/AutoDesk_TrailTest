package projectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoDeskCheck {
	
	@Test
	public void check() {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.autodesk.com");
		driver.findElement(By.xpath("//*[@id='tabs-a09eca5831-item-217bae274e-tab']")).click();
		
		}

}
