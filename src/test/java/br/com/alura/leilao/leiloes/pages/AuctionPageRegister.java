package br.com.alura.leilao.leiloes.pages;

import org.openqa.selenium.WebDriver;

public class AuctionPageRegister {

	private WebDriver browser;
	
	public AuctionPageRegister(WebDriver browser) {
		this.browser = browser;
	}
	
	public void close() {
		this.browser.quit();
	}
}
