package com.reddit.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Operations {
	
	private static String user = "testsw";
	private static String passwd = "testsw";
	
	public final String baseUrl ="https://www.reddit.com";

	public void login(WebDriver driver){
		//encontra a caixa de texto para informar o nome do usuário
	    WebElement login_user = driver.findElement(By.name("user"));
	    login_user.click();
	    //escreve o usuário 'testsw' no campo
	    login_user.sendKeys(user);
	    //encontra a caixa de texto para informar a senha do usuário
	    WebElement login_passwd = driver.findElement(By.name("passwd"));
	    login_passwd.click();
	    //escreve a senha 'testsw' no campo
	    login_passwd.sendKeys(passwd);
	    //clicar no botão de login
	    driver.findElement(By.tagName("button")).click();
	}
	
}
