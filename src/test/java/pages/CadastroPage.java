package pages;

import core.DSL;
import core.GeneratorUtils;
import org.openqa.selenium.WebDriver;

public class CadastroPage {

    WebDriver driver;
    DSL dsl;
    GeneratorUtils gerador;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cadastra(String nome, String email, String senha) {
        dsl = new DSL(driver);
        gerador = new GeneratorUtils();

        dsl.vaiParaAPaginaInicial();//Vai para a página inicial 
        dsl.clicaPorXpath("//*[@id=\'page-header\']/div/div/a");//Clica em singup 
        dsl.escrevePorXpath("//*[@id=\'full-name\']", nome);//Preenche campo nome 
        dsl.escrevePorXpath("//*[@id=\'email-address\']", email);//Preenche campo email
        dsl.escrevePorXpath("//*[@id=\'password\']", senha);//Preenche campo senha
        dsl.escrevePorXpath("//*[@id=\'confirm-password\']", senha);//Confirma a senha
        dsl.clicaPorXpath("//*[@id=\'terms-agreement\']");//Marca aceito os termos 
        dsl.clicaPorXpath("//*[@id=\'signup\']/div/div/form/div[6]/button");//CLica no botão criar conta
    }
}
