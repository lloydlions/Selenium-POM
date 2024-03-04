package pages.sauce_demo;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage extends BasePage {
    private final String URL = ConfigReader.getInstance().getProperty("sauceDemo");

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        navigateToUrl(URL);
    }

    public void setLoginThenSubmit(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();
        this.setTimeOut();
    }

}
