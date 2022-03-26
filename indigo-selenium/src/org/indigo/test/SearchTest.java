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
public class SearchTest {
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
  public void Search() {
    driver.get("https://www.chapters.indigo.ca/en-ca/");
    driver.findElement(By.id("header__quick-search")).click();
    driver.findElement(By.id("header__quick-search")).sendKeys("Harry Potter");
    driver.findElement(By.id("header__quick-search")).sendKeys(Keys.ENTER);

    driver.findElement(By.cssSelector("#resultSummary > span")).click();
    driver.findElement(By.id("aspnetForm")).click();
    assertThat(driver.findElement(By.cssSelector(".keyword-heading")).getText(), is("\"HARRY POTTER\""));
  }
}
