package br.com.desafio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutoPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public ProdutoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visitar(String site) {
		driver.get(site);
	}

	public void validarSelecionado() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-cart")));	
	}

	public void comprar() {
		WebElement btnComprar = driver.findElement(By.id("btn-cart"));
		btnComprar.click();
	}

	public String getprecoTotal() {
		WebElement preco = driver.findElement(By.className("price-val"));
		return preco.getText();
	}
	
	public void validarBtnContinuar() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("buy-service-button")));
		
		WebElement btnGarantia = driver.findElement(By.id("buy-service-button"));
		btnGarantia.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-checkout")));
	}
}
