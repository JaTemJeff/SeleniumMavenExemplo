package pages_metodo_professor;

import core.AppSettings;
import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages_metodo_professor.LoginPage2;

public class LoginTest2 extends BaseTest{
    WebDriver driver;
    LoginPage2 loginPage2;
    
    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        loginPage2 = new LoginPage2(driver);
    }
    
    @Test
    public void loginCorretoTest(){
        loginPage2.goToHomePage();
        loginPage2.clicaLogin();
        loginPage2.setLogin(AppSettings.LOGIN);
        loginPage2.setSenha(AppSettings.SENHA);
        loginPage2.clicaEntrar();
        loginPage2.waitFriendPage();
     
        Assert.assertEquals("https://ration.io/friends", loginPage2.getURL());
    }
}
