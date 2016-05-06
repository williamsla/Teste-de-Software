package com.reddit.tests;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.reddit.operations.Operations;

public class C4_FazerPesquisa extends Operations{
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCondiOIV() throws Exception {
    driver.get(baseUrl);
    //caixa de pesquisa
    WebElement q=driver.findElement(By.name("q"));
    q.click();    
    q.clear();    
    //Termo a ser pesquisado
    q.sendKeys("music");
    Thread.currentThread().sleep(2000);
    //Efetua a pesquisa
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    Thread.currentThread().sleep(5000);
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
