package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CompraPage {
	
	WebDriver driver;
	
	public CompraPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void buscaProdutos(String produto) throws InterruptedException {
		driver.findElement(By.className("nav-search-input")).sendKeys(produto);
	}
	
	public void clicaBuscar() {
		driver.findElement(By.className("nav-icon-search")).click();
	}
	
	public void clicarItem() {
		driver.findElements(By.className("item__info-title")).get(0).click();
	}
	
	public void adicionarCarrinho() throws InterruptedException {
		int qtdClasse;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,250)", "");
		qtdClasse = driver.findElements(By.className("andes-button__content")).size();
	    for(int i = 0; i < qtdClasse;i++) {
	    	if(driver.findElements(By.className("andes-button__content")).get(i).getText().equals("Adicionar ao carrinho")) {
	    		driver.findElements(By.className("andes-button__content")).get(i).click();
	    		break;
	    	}
	    }
	}
	
	public void clicaJaTenhoConta() {
		int qtdClasse;
		qtdClasse = driver.findElements(By.className("andes-button__content")).size();
	    for(int i = 0; i < qtdClasse;i++) {
	    	if(driver.findElements(By.className("andes-button__content")).get(i).getText().equals("Já tenho conta")) {
	    		driver.findElements(By.className("andes-button__content")).get(i).click();
	    		break;
	    	}
	    }
	}
	
	public void clicaContinuarLogin() {
		int qtdClasse;
		qtdClasse = driver.findElements(By.className("andes-button__content")).size();
	    for(int i = 0; i < qtdClasse;i++) {
	    	if(driver.findElements(By.className("andes-button__content")).get(i).getText().equals("Continuar")) {
	    		driver.findElements(By.className("andes-button__content")).get(i).click();
	    		break;
	    	}
	    }
	}
	
	public void clicaEntrarLogin() {
		int qtdClasse;
		qtdClasse = driver.findElements(By.className("andes-button__content")).size();
	    for(int i = 0; i < qtdClasse;i++) {
	    	if(driver.findElements(By.className("andes-button__content")).get(i).getText().equals("Entrar")) {
	    		driver.findElements(By.className("andes-button__content")).get(i).click();
	    		break;
	    	}
	    }
	}
	
}
