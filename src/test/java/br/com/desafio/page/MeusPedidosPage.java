package br.com.desafio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeusPedidosPage {

	private WebDriver driver;
	
	public MeusPedidosPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void selecionarQtd(String qtdProduto) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inputItemCart")));
		
		WebElement defineQTD = driver.findElement(By.className("inputItemCart"));
		defineQTD.clear();
		defineQTD.sendKeys(qtdProduto);
	}

	public boolean validarProduto() {
		return driver.getPageSource().contains("iphone 7 32gb Preto Matte") && driver.getPageSource().contains("R$ 2.879,00");
	}
	
	public void continuar() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-checkout")));
		WebElement btnContinuar = driver.findElement(By.id("proceed-checkout"));
		btnContinuar.click();
	}
	
	public void escolherEndereco() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("please-wait")));
		WebElement btnContinuar = driver.findElement(By.className("co_bt_continue"));
		btnContinuar.click();
	}
	
	public String validarQtd(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/article/section[6]/div[1]/p[3]/a"))); 
		
		WebElement qtdSelecionada = driver.findElement(By.xpath("/html/body/article/section[6]/div[1]/p[3]/a"));
		
		return qtdSelecionada.getText();
	}

	public void finalizarCompra() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement numCartao = driver.findElement(By.xpath("/html/body/article/section[5]/div/ul/li[1]/div[2]/div/form/fieldset[1]/input"));
		numCartao.sendKeys("5453010000066167");
		numCartao.sendKeys(Keys.chord(Keys.TAB));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("please-wait")));
		WebElement cvvCartao = driver.findElement(By.xpath("/html/body/article/section[5]/div/ul/li[1]/div[2]/div/form/fieldset[2]/input"));
		cvvCartao.clear();
		cvvCartao.sendKeys("123");
		
		Select mesCartao = new Select(driver.findElement(By.className("month")));
		mesCartao.selectByValue("3");
		
		Select anoCartao = new Select(driver.findElement(By.className("year")));
		anoCartao.selectByValue("2020");
		
		Select parcelaCartao = new Select(driver.findElement(By.className("creditcard_installments")));
		parcelaCartao.selectByValue("1");
				
		WebElement nomeCartao = driver.findElement(By.xpath("/html/body/article/section[5]/div/ul/li[1]/div[2]/div/form/fieldset[5]/input"));
		nomeCartao.sendKeys("CLIENTE UM TESTE");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("co_bt_send_payment")));
	}
	
	public void validarSelecaoQtd(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/article/section[4]/button")));
	}
}
