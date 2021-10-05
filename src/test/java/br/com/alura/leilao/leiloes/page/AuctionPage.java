package br.com.alura.leilao.leiloes.page;

import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.leiloes.pages.AuctionPageRegister;

public class AuctionPage {
	
	private static final String URL_AUCTION_FORM = "http://localhost:8080/leiloes/new";

	private WebDriver browser;
	
	public AuctionPage(WebDriver browser) {
		this.browser = browser;
	}

	public void close() {
		this.browser.quit();
	}

	public AuctionPageRegister navigateToAuctionForm() {
		this.browser.navigate().to(URL_AUCTION_FORM);
		return new AuctionPageRegister(this.browser);
	}
}
