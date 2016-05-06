package com.reddit.tests;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.reddit.operations.Operations;
/*
 * Usu�rio: testsw
 * Senha: testsw
 * */

public class C1_FazerComentario extends Operations{
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCondiOI() throws Exception {
    driver.get(baseUrl);
    //Fazer login
    login(driver);    
    //Simula um click no elemento HTML, no qual, a palavra 'coment�rio' � o texto da tag 'a'.
    //Bot�o para ver coment�rios de um t�pico
    driver.findElement(By.partialLinkText("coment�rio")).click();
    //Simula um click no primeiro elemento HTML cujo o valor do atributo 'name' � 'text'
    //Caixa de texto para escrever um coment�rio
    WebElement textarea = driver.findElement(By.tagName("textarea"));
    textarea.click();
    //Limpa a caixa de texto
    textarea.clear();
    //Escreve 'amazing!' na caixa de texto
    textarea.sendKeys("amazing!");
    //Envia (salva) o coment�rio
    driver.findElement(By.cssSelector("button.save")).click();
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
