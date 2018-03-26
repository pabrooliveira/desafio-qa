package br.com.desafio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void visitar(String site) {
		driver.get(site);
	}

	public LoginPage entrar() {
		WebElement abrirTelaLogin = driver.findElement(By.className("login-btn"));
		abrirTelaLogin.click();
		
		return new LoginPage(driver);
	}

	public boolean validarBotaoCarrinho() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("icon-cart")));
		return driver.findElement(By.className("icon-cart")).isDisplayed();
	}

	public CarrinhoPage entrarCarrinho() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("icon-cart")));
		WebElement carrinho = driver.findElement(By.className("icon-cart"));
		carrinho.click();
		
		return new CarrinhoPage(driver);
	}

	public ProdutoPage selecionarProduto(String produtoBusca) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
		
		WebElement txtBusca = driver.findElement(By.id("q"));
		txtBusca.click();
		txtBusca.sendKeys(produtoBusca);
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@term='" + produtoBusca + "']")));
		WebElement btnPesquisar = driver.findElement(By.xpath("//*[@term='" + produtoBusca + "']"));
		btnPesquisar.click();
		
		return new ProdutoPage(driver);
	}
}
