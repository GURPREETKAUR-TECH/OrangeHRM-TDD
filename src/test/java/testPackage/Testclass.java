package testPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.Baseclass;
import pomPackage.Pomclass;
import testdata.Excelsheet;

public class Testclass extends Baseclass {
	Pomclass pom;
	public Testclass() {
		super();
	}
	@BeforeMethod
	public void initialsetup() {
		initiation();
		 pom=new Pomclass();
		//pic("homepage");
	}
	
		
	
	@Test(priority=1)
	public void title() {
		String t=pom.verify();
		Assert.assertEquals(t, "OrangeHRM");
	}

	
	  @DataProvider 
	  public Object [][] details1(){ 
		  Object result[][]=Excelsheet.readdata("sheet1");
	  return result;
	  }
	
	@Test(priority=2, dataProvider="details1")
	public void login(String name,String password) throws InterruptedException {
		//pom.typeusername(prop.getProperty("username"));
		pom.typeusername(name);
		Thread.sleep(3000);
		//pom.typepassword(prop.getProperty("password"));
		pom.typepassword(password);
		Thread.sleep(3000);
		//pom.loginbtn();
	}
		
		@AfterMethod
		public void close() {
			driver.close();
		}
}


