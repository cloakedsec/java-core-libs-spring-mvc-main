import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderWay {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://orders.takeaway.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("pizze1794");
		driver.findElement(By.name("password")).sendKeys("vmsduj2mej");
		driver.findElement(By.name("login")).click();

		if (driver.findElement(By.xpath("")).isDisplayed()) {

		}
	}
}
