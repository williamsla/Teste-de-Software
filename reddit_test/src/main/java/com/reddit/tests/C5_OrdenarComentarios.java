package com.reddit.tests;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.reddit.operations.Operations;

public class C5_OrdenarComentarios extends Operations{
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCondiOV() throws Exception {
    driver.get(baseUrl + "/r/worldnews/comments/4ekk9a/uk_jeremy_corbyn_found_to_have_overpaid_tax_after/");
    driver.findElement(By.cssSelector("div.dropdown.lightdrop > span.selected")).click();
    driver.findElement(By.linkText("no topo")).click();
    driver.findElement(By.cssSelector("div.dropdown.lightdrop > span.selected")).click();
    driver.findElement(By.linkText("melhores")).click();
    driver.findElement(By.cssSelector("div.dropdown.lightdrop > span.selected")).click();
    driver.findElement(By.linkText("novos")).click();
    driver.findElement(By.cssSelector("div.dropdown.lightdrop > span.selected")).click();
    driver.findElement(By.linkText("controversos")).click();
    driver.findElement(By.cssSelector("div.dropdown.lightdrop > span.selected")).click();
    driver.findElement(By.linkText("antigos")).click();
    driver.findElement(By.cssSelector("div.dropdown.lightdrop > span.selected")).click();
    driver.findElement(By.linkText("q&a")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
