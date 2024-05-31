package com.base;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;

	public static WebDriver launchTheBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			}
		else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();		
		return driver;
	}

	public static void launchURL(WebDriver driver,String url,int sec) {
		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		} catch (Exception e) {
			System.out.println("Error found while launching the URL");
			e.printStackTrace();
		}
	}
	public static void clickTheElement(WebDriver driver,WebElement element,int sec) {
		
		try {
			new WebDriverWait(driver,Duration.ofSeconds(sec))
			.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void frame( int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void passValue(WebDriver driver,WebElement element,String value,int sec) {
		
		try {
			new WebDriverWait(driver,Duration.ofSeconds(sec))
			.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void staticwait(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  void implicitWait(int sec) {
	
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static String screenShot() throws IOException {
		
			try {
				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File destination = new File("D:\\eclipse\\eclipse\\TestNG\\ScreenShot\\.png"+ "_"+ timestamp +".png");
				FileHandler.copy(source, destination);
				return destination.getAbsolutePath();
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;	
	}
	
	public static void dropDown(WebElement element,String options, String ddvalue) {
		
		try {
			Select s = new Select(element);

			if(options.equalsIgnoreCase("Index")) {
			s.selectByIndex(Integer.parseInt(ddvalue));
			}
			else if(options.equalsIgnoreCase("visibletext")) {
				s.selectByVisibleText(ddvalue);
			}
			else if (options.equalsIgnoreCase("value")) {
				s.selectByValue(ddvalue);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeTab(WebDriver driver) {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void terminateBrowser(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void scroll(WebDriver driver, int x, int y) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy("+x+"," +y+");");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String fullScreenShot(String location) {
	
	try {
		Screenshot take = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(take.getImage(), "PNG",new File(location));
	} catch (IOException e) {
		e.printStackTrace();
	}
	return location;
	}
	public static void windowHandles() {
		try {
			Set<String> windows_id=driver.getWindowHandles();
			Iterator<String> itr=windows_id.iterator();
			itr.next();
			while(itr.hasNext()) {
			   driver.switchTo().window((String) itr.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void javaScriptClick(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("argument[0].click", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void robot(int key1,int key2) {
//		try {
//			Robot rb = new Robot();
//			rb.keyPress(KeyEvent.key1);
//			rb.keyRelease(KeyEvent.key2);
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void extendReportStart(String location) {
		try {
			extentReports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter spartreporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(spartreporter);
//			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//			extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void extendReportEnd(String location) throws IOException {
		try {
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//		public void newWindow(WebDriver driver,String currentWindow ) {
//			String currentWindow1 = driver.getWindowHandle();
//			driver.navigate().to(currentWindow1);
//			
//		}
	


	
}
