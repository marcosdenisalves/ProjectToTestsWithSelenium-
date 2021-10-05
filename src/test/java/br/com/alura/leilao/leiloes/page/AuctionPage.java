package br.com.alura.leilao.leiloes.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.leiloes.pages.AuctionPageRegister;

public class AuctionPage {
	
	public static final String AUCTION_FORM_URL = "http://localhost:8080/leiloes/new";
	public static final String AUCTIONS_URL = "http://localhost:8080/leiloes";

	private WebDriver browser;
	
	public AuctionPage(WebDriver browser) {
		this.browser = browser;
	}

	public void close() {
		this.browser.quit();
	}

	public AuctionPageRegister navigateToAuctionForm() {
		this.browser.navigate().to(AUCTION_FORM_URL);
		return new AuctionPageRegister(this.browser);
	}

	public boolean isAuctionRegistered(String name, String today, String value) {
		WebElement lastLine = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement columnName = lastLine.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement columnDate = lastLine.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement columnValue = lastLine.findElement(By.cssSelector("td:nth-child(3)"));
		
		return columnName.getText().equals(name) 
				&& columnDate.getText().equals(today)
				&& columnValue.getText().equals(value);
	}
}
