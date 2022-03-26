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
public class AddReviewTest {
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
  public void addReview() {
	  
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
	  driver.findElement(By.id("header__quick-search")).click();
	  driver.findElement(By.id("header__quick-search")).sendKeys("Harry Potter");
	  driver.findElement(By.id("header__quick-search")).sendKeys(Keys.ENTER);
	  WebDriverWait wait3 = new WebDriverWait(driver, 15);   
	  wait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-list__product:nth-child(1) .product-list__product-image--grid")));
	  //.product-list__product:nth-child(1) .product-list__product-image--grid
	  driver.findElement(By.cssSelector(".product-list__product-title-link--grid")).click();
	  js.executeScript("window.scrollTo(0,72)");
	  js.executeScript("window.scrollTo(0,524.7999877929688)");
	  js.executeScript("window.scrollTo(0,896.7999877929688)");
	  js.executeScript("window.scrollTo(0,940.7999877929688)");
	  js.executeScript("window.scrollTo(0,1503.199951171875)");
	  js.executeScript("window.scrollTo(0,2067.199951171875)");
 
	  WebDriverWait wait4 = new WebDriverWait(driver, 15);   
	  wait4.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bv-write-review")));
	 
	  driver.findElement(By.cssSelector(".bv-write-review")).click();
	    
	  WebDriverWait wait5 = new WebDriverWait(driver, 60);   
	  wait5.until(ExpectedConditions.elementToBeClickable(By.id("inline-review___reviewtext_label")));
	    
	    driver.findElement(By.id("r_overall5")).click();
	    driver.findElement(By.id("inline-review___title")).click();
	    driver.findElement(By.id("inline-review___title")).sendKeys("Wow!");
	    driver.findElement(By.id("inline-review___reviewtext")).click();
	    driver.findElement(By.id("inline-review___reviewtext")).sendKeys("Wowowow!");
	    driver.findElement(By.cssSelector(".yesNo_radio_yes")).click();
	    driver.findElement(By.cssSelector(".button")).click();
	    //driver.findElement(By.id("product-section-details-extended")).click();
	    
	    WebDriverWait wait6 = new WebDriverWait(driver, 60);   
		wait6.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit_header")));
		  
	    assertThat(driver.findElement(By.cssSelector(".submit_header")).getText(), is("YOUR REVIEW HAS BEEN SUBMITTED"));
  }
}
