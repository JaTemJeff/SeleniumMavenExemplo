package testes;

import core.BaseTest;
import core.DSL;
import core.GeneratorUtils;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CadastroPage;

public class CadastroTest extends BaseTest {

    DSL dsl;
    WebDriver driver;
    CadastroPage cadastroPage;
    GeneratorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        dsl = new DSL(driver);
        cadastroPage = new CadastroPage(driver);
        gerador = new GeneratorUtils();
    }

    @Test
    public void cadastroCorretoTest() {
        String nome = gerador.stringAleatoria(10);
        String email = nome+"@hotmail.com";
        String senha = "123456";
        
        cadastroPage.cadastra(nome, email, senha);

        dsl.esperaPorXpath("//*[@id=\'friends\']/div/div[1]/div/button");//Espera aparecer botão para convidar amigos

        //Verifica se está na página de "friends"
        Assert.assertEquals("https://ration.io/friends", driver.getCurrentUrl());
    }
    
    @Test
    public void cadastroComNomeEmBrancoTest(){
        String email = gerador.stringAleatoria(10)+"@hotmail.com";
        String senha = "123456";
        
        cadastroPage.cadastra("", email, senha);
        
        //Verifica se exibe mensagem de campo obrigatório
        Assert.assertTrue(dsl.retornaSeTextoExisteNaPagina("Please enter your full name."));
    }
    
    @Test
    public void cadastroComEmailEmBrancoTest(){
        String nome = gerador.stringAleatoria(10);
        String senha = "123456";
        
        cadastroPage.cadastra(nome, " ", senha);
        
        //Verifica se exibe mensagem de campo obrigatório
        Assert.assertTrue(dsl.retornaSeTextoExisteNaPagina("Please enter a valid email address."));
    }
    
    @Test
    public void cadastroComSenhaEmBrancoTest(){
        String nome = gerador.stringAleatoria(10);
        String email = nome+"@hotmail.com";
        
        cadastroPage.
                cadastra(nome, email, " ");
        
        //Verifica se exibe mensagem de campo obrigatório
        Assert.assertTrue(dsl.retornaSeTextoExisteNaPagina("Please enter a password."));
    }
}
