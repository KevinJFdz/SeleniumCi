package pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void visitLoginPage(){
        visit("https://www.saucedemo.com/");
    }
    public void enterUserName(String userName){
        enter(userNameInput, userName);
    }

    public void enterPassword(String password){
        enter(passwordInput, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }
}
