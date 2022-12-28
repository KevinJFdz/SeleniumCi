package steps.login;

import pages.login.LoginPage;

public class LoginFunctions {
    protected LoginPage loginPage = new LoginPage();

    public void visitLoginPage(){
        loginPage.visitLoginPage();
    }

    public void login(String userName, String password){
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}
