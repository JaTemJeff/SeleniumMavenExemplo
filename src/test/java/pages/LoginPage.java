package pages;

import core.AppSettings;
import core.DSL;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    DSL dsl;
    
    public LoginPage(WebDriver driver){
        this.driver = driver; 
    }
  
    public void logar(String login, String senha){
        dsl = new DSL(driver);
        dsl.vaiParaAPaginaInicial();//Vai para a home page
        dsl.esperaPorXpath("//*[@id=\'page-header\']/div/a[2]");
        dsl.clicaPorXpath("//*[@id=\'page-header\']/div/a[2]");//Clica em login na home page
        dsl.escrevePorXpath("//*[@id=\'login\']/div/div/form/div[1]/input", login);//Escreve o login
        dsl.escrevePorXpath("//*[@id=\'login\']/div/div/form/div[2]/input", senha);//Escreve a senha
        dsl.clicaPorXpath("//*[@id=\'login\']/div/div/form/div[4]/button");//Clica em entrar
    }
}
