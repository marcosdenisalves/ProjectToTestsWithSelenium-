package br.com.alura.leilao.login;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.pages.LoginPage;

public class LoginTest {

	private LoginPage loginPage;

	@BeforeEach
	public void beforeEach() {
		this.loginPage = new LoginPage();
	}
	
	@AfterEach
	public void quitView() {
		loginPage.close();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		this.loginPage.fillLoginForm("fulano", "pass").submit();
		
		assertFalse(this.loginPage.isLoginUrl());
		assertTrue(this.loginPage.containText("fulano"));
	}

	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
		this.loginPage.fillLoginForm("invalido", "123123").submit();

		assertTrue(this.loginPage.isLoginErrorUrl());
		assertTrue(this.loginPage.containText("Usuário e senha inválidos."));
		assertFalse(this.loginPage.containText("fulano"));
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRetristaSemEstarLogado() {
		this.loginPage.navigateToAuctionsView();
		
		assertTrue(this.loginPage.isLoginUrl());
		assertFalse(this.loginPage.containText("Leilões cadastrados"));
	}
}
