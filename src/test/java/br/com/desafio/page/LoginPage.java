package br.com.desafio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver webdriver){
		this.driver = webdriver;
	}

	public HomePage fazerLogin(String email, String senha) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("pass"));
		
		inputEmail.sendKeys(email);
		inputSenha.sendKeys(senha);
		
		WebElement btnContinuar = driver.findElement(By.id("send2"));
		btnContinuar.click();
		
		return new HomePage(driver);
	}
}
