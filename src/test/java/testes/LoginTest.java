package testes;

import core.AppSettings;
import core.DSL;
import core.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginTest {
    DSL dsl;
    WebDriver driver;
    LoginPage loginPage;
    
    @Before
    public void inicializa(){
        driver = WebDriverFactory.getDriver();        
        dsl = new DSL(driver);
        loginPage = new LoginPage(driver);
    }
   
    @After
    public void finaliza(){
        //driver.quit();
    }
    
    @Test
    public void loginCorretoTest(){
        loginPage.logar(AppSettings.LOGIN, AppSettings.SENHA);
        //Verifica se está na página de "friends"
        Assert.assertEquals("https://ration.io/friends", driver.getCurrentUrl());
    }
}
