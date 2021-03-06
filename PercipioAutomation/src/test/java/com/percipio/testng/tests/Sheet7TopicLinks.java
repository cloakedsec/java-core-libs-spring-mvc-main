package com.percipio.testng.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Sheet7TopicLinks {
	WebDriver driver;
	
	
	
@BeforeClass
	public void xssSetup() throws FileNotFoundException {
		File src = new File("C:\\Users\\cloaked\\eclipse-workspace\\PercipioAutomation\\Files\\df_prma_plan.xlsm");

		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet7 = wb.getSheetAt(6);
	}
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\cloaked\\eclipse-workspace\\PercipioAutomation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://pubdemo.qa.rocs.io/login?email";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("qa@skillsoft.com");
		driver.findElement(By.name("password")).sendKeys("qa123!");
		driver.findElement(By.className("auth0-lock-submit")).click();
	}
	
	WebElement searchInput = driver
			.findElement(By.xpath("//input[@type='text' and @data-marker='HeaderNavSearchInput']"));
	searchInput.sendKeys("Data Preprocessing");

	WebElement searchBtn = driver.findElement(By.xpath("//button[@data-marker='HeaderNavSearchSearch']"));
	searchBtn.click();

	WebElement courseName = driver.findElement(By.xpath("//a[contains(text(), 'Data Preprocessing')]"));
	courseName.click();

	WebElement courseAbout = driver.findElement(By.xpath("//div[@data-marker='CourseSummaryCardDescription']"));
	
	WebElement topicLinks = driver.findElement(By.xpath("//a[@data-marker=\"CourseContentsCardTitleLink0\"]"));
	
	topicLinks.click();
	if (sheet7.getRow(11).getCell(1).getRichStringCellValue().getString().trim().equals(courseAbout))
		;
	System.out.println("Course about content verified and matched!!!");
	
	
	
	
}

@AfterMethod
public void quitDriver(WebDriver driver1) {
	driver1.quit();
}