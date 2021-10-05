package br.com.alura.leilao.leiloes.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.page.AuctionPage;

public class AuctionPageRegister extends PageObject {

	public AuctionPageRegister(WebDriver browser) {
 		super(browser);
	}

	public AuctionPage register(String name, String today, String value) {
		this.browser.findElement(By.id("nome")).sendKeys(name);
		this.browser.findElement(By.id("valorInicial")).sendKeys(value);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(today);
		this.browser.findElement(By.id("button-submit")).submit();
		
		return new AuctionPage(this.browser);
	}

	public boolean isRegisterPage() {
		return browser.getCurrentUrl().equals(AuctionPage.AUCTIONS_URL);
	}

	public boolean hasValidationMessages() {
		String pageSource = this.browser.getPageSource();
		return pageSource.contains("minimo 3 caracteres")
				&& pageSource.contains("não deve estar em branco")
					&& pageSource.contains("deve ser um valor maior de 0.1")
						&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}
}
