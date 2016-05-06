package com.reddit.tests;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.reddit.operations.Operations;

public class C2_FazerPostagem {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.reddit.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCondiOII() throws Exception {
    driver.get(baseUrl + "/");    
    //Fazer login
    Operations.login(driver);
    //Para esperar carregar a página. Estava aparecendo uma mensagem de que não estava logado.
    Thread.currentThread().sleep(1000);
    //Clica no botão para submeter um novo link
    driver.findElement(By.linkText("Submit a new link")).click();
    //Recupera a caixa de texto para digitar o título do link
    WebElement title=driver.findElement(By.name("title"));
    title.click();
    title.clear();
    title.sendKeys("I love this song!");
    //Recupera a caixa de texto para digitar a URL do link
    WebElement url = driver.findElement(By.id("url"));
    url.clear();
    url.sendKeys("https://www.youtube.com/watch?v=Gw_o7XUX3fg");
    driver.findElement(By.id("sr-autocomplete")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Music')])[3]")).click();
    driver.findElement(By.id("sendreplies")).click();
    driver.findElement(By.id("sendreplies")).click();
    driver.findElement(By.cssSelector("div.roundfield.captcha")).click();
    WebElement captcha=driver.findElement(By.name("captcha"));
    captcha.click();
    captcha.clear();
    captcha.sendKeys("klfvia");
    driver.findElement(By.name("submit")).click();
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
