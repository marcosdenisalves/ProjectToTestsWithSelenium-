package br.com.alura.leilao.login.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	private static final String URL_LOGIN = "http://localhost:8080/login";
	private static final String URL_LOGIN_ERROR = "http://localhost:8080/login?error";

	private WebDriver browser;

	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		this.browser = new ChromeDriver();
		this.browser.navigate().to(URL_LOGIN);
	}

	public void close() {
		this.browser.quit();
	}

	public LoginPage fillLoginForm(String login, String password) {
		this.browser.findElement(By.id("username")).sendKeys(login);
		this.browser.findElement(By.id("password")).sendKeys(password);
		return this;
	}

	public void submit() {
		this.browser.findElement(By.id("login-form")).submit();
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
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	
	public boolean isLoginErrorUrl() {
		return browser.getCurrentUrl().equals(URL_LOGIN_ERROR);
	}
}