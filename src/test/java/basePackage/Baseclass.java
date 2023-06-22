package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
	
		public static Properties prop=new Properties();
		 public static WebDriver driver;
		 public Baseclass() {
try {
		
		FileInputStream file1=new FileInputStream("C:\\Users\\gurpr\\eclipse-workspace\\newguru\\edited\\src\\test\\java\\environmentvariables\\config.properties");
	    prop.load(file1);
		} 
			
	 catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}}
	
	public static void initiation() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
			driver=new ChromeDriver();
			
		}
		
		else if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe" );
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));;
		driver.get(prop.getProperty("url"));
		
		
		/*
		 * public static void pic(String Filename) { File
		 * file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); try {
		 * FileUtils.copyFile(file, new File(
		 * "C:\\Users\\gurpr\\eclipse-workspace\\newguru\\Orangehrm\\src\\test\\java\\screenshot"+
		 * Filename+".jpg")); } catch(IOException e){ e.printStackTrace();
		 * 
		 * } }
		 */
	 
}

	
	}

	
	
	
	
	

