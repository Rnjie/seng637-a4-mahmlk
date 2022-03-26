package org.indigo.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SignoutTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void Signout() {
	    driver.get("https://www.chapters.indigo.ca/en-ca/");
	    driver.findElement(By.cssSelector(".browsepopup-closebtn")).click();
	    driver.findElement(By.cssSelector(".browse-signin-down")).click();
	    WebDriverWait wait = new WebDriverWait(driver, 15);   
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("browseCart-signInPopup-emailTextbox"))); 
	    driver.findElement(By.id("browseCart-signInPopup-emailTextbox")).sendKeys("jmatthewssarno@gmail.com");
	    driver.findElement(By.id("browseCart-signInPopup-passwordTextbox")).sendKeys("p@ssword12345");
	    driver.findElement(By.cssSelector(".js-clickSignIn-button")).click();
	    WebDriverWait wait2 = new WebDriverWait(driver, 15);   
	    wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".service-link__greeting-name")));
	    driver.findElement(By.cssSelector(".account-dropdown__text")).click();
	    driver.findElement(By.cssSelector(".account-dropdown__sign-out")).click();
    	driver.findElement(By.cssSelector(".account-dropdown__text")).click();
    	WebDriverWait wait3 = new WebDriverWait(driver, 15);   
	    wait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".browse-signin-down")));
    	assertThat(driver.findElement(By.cssSelector(".browse-signin-down")).getText(), is("SIGN IN"));
  }
}
