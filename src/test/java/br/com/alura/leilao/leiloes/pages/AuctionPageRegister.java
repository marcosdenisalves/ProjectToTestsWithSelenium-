package br.com.alura.leilao.leiloes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.leiloes.page.AuctionPage;

public class AuctionPageRegister {

	private WebDriver browser;

	public AuctionPageRegister(WebDriver browser) {
		this.browser = browser;
	}

	public void close() {
		this.browser.quit();
	}

	public AuctionPage register(String name, String today, String value) {
		this.browser.findElement(By.id("nome")).sendKeys(name);
		this.browser.findElement(By.id("valorInicial")).sendKeys(value);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(today);
		this.browser.findElement(By.id("button-submit")).submit();
		
		return new AuctionPage(this.browser);
	}
}
