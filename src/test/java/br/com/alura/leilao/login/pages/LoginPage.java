package br.com.alura.leilao.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.page.AuctionPage;

public class LoginPage extends PageObject {

	private static final String LOGIN_URL = "http://localhost:8080/login";
	private static final String LOGIN_ERROR_URL = "http://localhost:8080/login?error";

	public LoginPage() {
 		super(null);
		this.browser.navigate().to(LOGIN_URL);
	}

	public LoginPage fillLoginForm(String login, String password) {
		this.browser.findElement(By.id("username")).sendKeys(login);
		this.browser.findElement(By.id("password")).sendKeys(password);
		return this;
	}

	public AuctionPage submit() {
		this.browser.findElement(By.id("login-form")).submit();
		return new AuctionPage(browser);
	}

	public WebElement findElement(String elementId) {
		return this.browser.findElement(By.id(elementId));
	}

	public void navigateToAuctionsView() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean containText(String text) {
		return this.browser.getPageSource().contains(text);
	}

	public boolean isLoginUrl() {
		return browser.getCurrentUrl().equals(LOGIN_URL);
	}
	
	public boolean isLoginErrorUrl() {
		return browser.getCurrentUrl().equals(LOGIN_ERROR_URL);
	}
}