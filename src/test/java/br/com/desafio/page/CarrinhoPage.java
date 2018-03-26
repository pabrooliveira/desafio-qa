package br.com.desafio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarrinhoPage {
	private WebDriver driver;

	public CarrinhoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void removeProduto() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("clickLess")));
		WebElement removeItemCarrinho = driver.findElement(By.className("clickLess"));
		removeItemCarrinho.click();
	}
	
	public void limparCarrinho() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-remove-cart")));
		WebElement removeItemCarrinho = driver.findElement(By.className("btn-remove-cart"));
		removeItemCarrinho.click();
	}

	public String validarSemPedido() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div[1]/div[1]/div[2]/div/h2"))); 
		
		WebElement carrinhoVazio = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div[1]/div[1]/div[2]/div/h2"));
		
		return carrinhoVazio.getText();
	}
}
