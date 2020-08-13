package test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompraSteps {
	WebDriver driver;
	
	@Given("que acesso o mercado livre")
	public void que_acesso_no_mercado_livre()throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/Inmetrics2/Downloads/chromedriver");
		driver = new ChromeDriver();
		
	}

	@When("buscar pelo produto {string}")
	public void preencho_meu_usuario(String produto)throws InterruptedException {
		CompraPage compra = new CompraPage(driver);
		compra.buscaProdutos(produto);
		compra.clicaBuscar();
	}
	
	@When("adiocionar no carrinho o {string} logando no {string} {string}")
	public void adiocionar_no_carrinho_o_logando_no(String produto, String usuario, String senha) throws InterruptedException {
	  CompraPage compra = new CompraPage(driver);
	  compra.buscaProdutos(produto);
	  compra.clicaBuscar();
	  Thread.sleep(3000);
	  compra.clicarItem();
	  Thread.sleep(3000);
	  compra.adicionarCarrinho();
	  Thread.sleep(3000);
	  compra.clicaJaTenhoConta();
	  Thread.sleep(3000);
	  driver.findElement(By.id("user_id")).sendKeys(usuario);
	  compra.clicaContinuarLogin();
	  Thread.sleep(3000);
	  driver.findElement(By.id("password")).sendKeys(senha);
	  compra.clicaEntrarLogin();
	  Thread.sleep(3000);
	  driver.findElement(By.className("nav-icon-cart")).click();
	}

	@Then("visualizar o produto no catalogo {string}")
	public void valido_o_login(String produto)throws InterruptedException {
	   Thread.sleep(3000);
	   Assert.assertTrue("Não foi possível encontrar o produto no catálogo "+produto, driver.findElements(By.className("item__info-title")).get(0).getText().equals(produto));
	   driver.close();
	}
	
	@Then("visualizar o produto no carrinho {string}")
	public void visualizarProdutoCarrinho(String produtoCarrinho)throws InterruptedException{
		Thread.sleep(3000);
		Assert.assertTrue("Não foi possível encontrar o produto no carrinho "+produtoCarrinho, driver.findElements(By.className("item__title--link")).get(0).getText().toLowerCase().equals(produtoCarrinho.toLowerCase()));
		driver.close();
	}
}
