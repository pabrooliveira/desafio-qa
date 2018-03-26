package br.com.desafio.testcases;

import static org.junit.Assert.*;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.desafio.page.CarrinhoPage;
import br.com.desafio.page.HomePage;
import br.com.desafio.page.LoginPage;
import br.com.desafio.page.MeusPedidosPage;
import br.com.desafio.page.ProdutoPage;

public class DesafioQaTest {

	private FirefoxDriver driver;
	private HomePage home;

	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.home = new HomePage(this.driver);
	}

	@Test
	public void teste1() { //Validar se o carrinho de compras está vazio
		home.visitar("https://www.saraiva.com.br/");
		LoginPage loginPage = home.entrar();
		home = loginPage.fazerLogin("cliente@teste.com.br", "Desafio123");

		assertTrue(home.validarBotaoCarrinho());

		CarrinhoPage carrinhoPage = home.entrarCarrinho();
		carrinhoPage.validarSemPedido();
	}
	
	@Test
	public void teste2() { //Consultar um produto que esteja disponível no estoque
		home.visitar("https://www.saraiva.com.br/");
		
		String produtoBusca = "iphone 7 32gb Preto Matte";
		
		ProdutoPage produtoPage = home.selecionarProduto(produtoBusca);
		produtoPage.validarSelecionado();
	}
	
	@Test
	public void teste3(){ //Iniciar a compra do produto
		home.visitar("https://www.saraiva.com.br/");
		LoginPage loginPage = home.entrar();
		home = loginPage.fazerLogin("cliente@teste.com.br", "Desafio123");
		
		ProdutoPage produtoPage = new ProdutoPage(driver);
		produtoPage.visitar("https://www.saraiva.com.br/iphone-7-32gb-preto-matte-9721086.html?p=iphone%207%2032gb%20Preto%20Matte&ranking=1&typeclick=3&ac_pos=header");
		produtoPage.comprar();
		produtoPage.validarBtnContinuar();
	}
	
	@Test
	public void teste4(){ //Definir uma quantidade para o produto e continuar a compra
		this.teste3();
		
		String qtdProduto = "1";
		
		MeusPedidosPage meusPedidosPage = new MeusPedidosPage(driver);
		meusPedidosPage.selecionarQtd(qtdProduto);
		meusPedidosPage.continuar();
		meusPedidosPage.validarSelecaoQtd();
	}
	
	@Test
	public void teste5(){ //Finalizar a compra de um produto passando dados de um cartão ficticio
		this.teste3();
	
		String qtdProduto = "1";
		
		MeusPedidosPage meusPedidosPage = new MeusPedidosPage(driver);
		meusPedidosPage.selecionarQtd(qtdProduto);
		meusPedidosPage.continuar();
		meusPedidosPage.escolherEndereco();
		meusPedidosPage.finalizarCompra();
		
		Assert.assertEquals(qtdProduto + " item", meusPedidosPage.validarQtd());
	}
	
	@Test
	public void teste6(){ //Remover um produto do carrinho do usuário
		home.visitar("https://www.saraiva.com.br/checkout/cart/");
		LoginPage loginPage = home.entrar();
		home = loginPage.fazerLogin("cliente@teste.com.br", "Desafio123");
		
		CarrinhoPage carrinhoPage = new CarrinhoPage(driver);
		carrinhoPage.removeProduto();
	}
	
	@Test
	public void teste7(){ //Finalizar a compra de dois produtos passando dados de um cartão ficticio
		this.teste3();
		String qtdProduto = "2";
		MeusPedidosPage meusPedidosPage = new MeusPedidosPage(driver);
		meusPedidosPage.selecionarQtd(qtdProduto);
		meusPedidosPage.continuar();
		meusPedidosPage.escolherEndereco();
		meusPedidosPage.finalizarCompra();
		
		Assert.assertEquals(qtdProduto + " itens", meusPedidosPage.validarQtd());
	}
	
	@Test
	public void teste8(){ //Remover todos os produtos do carrinho do usuário
		home.visitar("https://www.saraiva.com.br/checkout/cart/");
		LoginPage loginPage = home.entrar();
		home = loginPage.fazerLogin("cliente@teste.com.br", "Desafio123");
		
		CarrinhoPage carrinhoPage = new CarrinhoPage(driver);
		carrinhoPage.limparCarrinho();

		Assert.assertEquals("Seu carrinho está vazio!", carrinhoPage.validarSemPedido());
	}
}
