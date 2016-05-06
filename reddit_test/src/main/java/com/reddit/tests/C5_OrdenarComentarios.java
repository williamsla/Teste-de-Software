package com.reddit.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C5_OrdenarComentarios {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.reddit.com/";
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

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
