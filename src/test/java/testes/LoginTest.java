package testes;

import core.AppSettings;
import core.BaseTest;
import core.DSL;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    DSL dsl;
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        dsl = new DSL(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginCorretoTest() {
        loginPage.logar(AppSettings.LOGIN, AppSettings.SENHA);//Loga com login e senha corretos

        dsl.esperaPorXpath("//*[@id=\'friends\']/div/div[1]/div/button");//Espera carregar botões da tela friends

        //Verifica se está na página de "friends"
        Assert.assertEquals("https://ration.io/friends", driver.getCurrentUrl());
    }

    @Test
    public void loginIncorretoTest() {
        loginPage.logar("email_fake@emaiil.com.br", "123456");//Tenta logar com login incorreto

        dsl.esperaPorXpath("//*[@id=\'login\']/div/div/form/p/small");//Espera aparecer mensagem de erro
        String msgErro = dsl.retornaTextoLabel("//*[@id=\'login\']/div/div/form/p/small");//Pega mensagem de erro

        //Verifica se exibe a mensagem de erro
        Assert.assertEquals("The credentials you entered are not associated with an account. Please check your email and/or password and try again.", msgErro);
    }
    
    @Test
    public void loginEmBrancoTest(){
        loginPage.logar(" ", " ");
        //Verifica se exibem as mensagem de campo obrigatório
        Assert.assertTrue(dsl.retornaSeTextoExisteNaPagina("Please provide a valid email address."));
        Assert.assertTrue(dsl.retornaSeTextoExisteNaPagina("Please enter your password."));
    }
}
