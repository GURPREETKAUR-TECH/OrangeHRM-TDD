package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.Baseclass;

public class Pomclass extends Baseclass {
	//object repository
	@FindBy(css="input[placeholder='Username']")WebElement username;

	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;

	@FindBy(xpath="//button[normalize-space()='Login']") WebElement loginbtn;

	//initiate page element
	public Pomclass() {
		PageFactory.initElements(driver, this);
	}

	// actions to be performed on webelements

	public void typeusername(String name) {
		username.sendKeys(name);
	}

	public void typepassword(String pass) {
		password.sendKeys(pass);
	}

	public void loginbtn() {
		loginbtn.click();
	}
	public String verify() {
		return driver.getTitle();
		
	}
	}


