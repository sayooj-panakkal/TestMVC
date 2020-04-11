package com.htc.loginregtest;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.htc.webdrivergenerator.DriverGenerator;




public class TestMVC{

	static WebDriver driver;
	

	@DataProvider(name = "validLoginData")
	public Object[][] setValidLoginData() throws IOException {

		Object[][] empdata = new Object[2][2];
		int rowIndex = 0;

		//File xlsFile = new File("./Login.xls");
		File xlsFile = new File("C://Users//sayooj//.jenkins//workspace//TestMVC/Login.xls");
		FileInputStream fin = null;
		HSSFWorkbook book = null;
		fin = new FileInputStream(xlsFile);

		book = new HSSFWorkbook(fin);
		Sheet sheet = book.getSheet("empdata");
		System.out.println("Workbook created");

		for (Row row : sheet) {

			// row.getCell(1).getStringCellValue();
			String empID = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();
			empdata[rowIndex][0] = empID;
			empdata[rowIndex][1] = password;
			rowIndex++;
		}
		book.close();
		fin.close();
		return empdata;
	}

	@BeforeClass
	public void initializeDriver() {
		// rowCount=0;
		driver = DriverGenerator.genDriver();
		

	}

	@AfterClass
	public static void closedriver() {
		driver.close();

	}

	@Test(dataProvider = "validLoginData")
	public void testSuccessLoginLogout(String username, String password) throws InterruptedException {
		driver.navigate().to("http://localhost:8080/MavenSpringMVC/");
		WebElement LoginBtn = (new WebDriverWait(driver, 2)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Login')]")));

		LoginBtn.click();
		
		WebElement unameElement = driver.findElement(By.id("username"));
		// System.out.println(unameElement.isEnabled());
		unameElement.clear();
		unameElement.sendKeys(username);
		WebElement passElement = driver.findElement(By.id("password"));
		passElement.clear();
		passElement.sendKeys(password);
		Thread.sleep(3000);
		WebElement subElement = driver
				.findElement(By.xpath("//button[@id='loginbtn']"));
		subElement.click();
		
	}
	
  
	}


