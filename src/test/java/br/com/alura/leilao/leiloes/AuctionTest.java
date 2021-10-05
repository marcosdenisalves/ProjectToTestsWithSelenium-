package br.com.alura.leilao.leiloes;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.leiloes.page.AuctionPage;
import br.com.alura.leilao.leiloes.pages.AuctionPageRegister;
import br.com.alura.leilao.login.pages.LoginPage;

public class AuctionTest {

	private AuctionPage auctionsPage;

	@AfterEach
	public void quitView() {
		auctionsPage.close();
	}

	@Test
	public void deveriaCadastrarLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		this.auctionsPage = paginaDeLogin.fillLoginForm("fulano", "pass").submit();
		AuctionPageRegister pageRegister = this.auctionsPage.navigateToAuctionForm();
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
		String name = "Auction today " + today;
		String value = "500.00";
		
		this.auctionsPage = pageRegister.register(name, today, value);
		assertTrue(this.auctionsPage.isAuctionRegistered(name, today, value));
	}
}
