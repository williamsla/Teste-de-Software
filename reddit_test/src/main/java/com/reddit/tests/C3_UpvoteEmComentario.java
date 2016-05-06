package com.reddit.tests;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.reddit.operations.Operations;

public class C3_UpvoteEmComentario extends Operations{
  private WebDriver driver;
  
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCondiOIII() throws Exception {
    driver.get(baseUrl + "/r/worldnews/comments/4ekk9a/uk_jeremy_corbyn_found_to_have_overpaid_tax_after/");
    driver.findElement(By.xpath("//div[@id='thing_t1_d20zlyw']/div/div")).click();
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
