package pages;

import core.AppSettings;
import core.DSL;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    DSL dsl = new DSL(driver);
    
    public LoginPage(WebDriver driver){
        this.driver = driver; 
    }
  
    public void logar(){
        dsl.vaiParaAPaginaInicial();//Vai para a home page
        dsl.clicaPorXpath("//*[@id=\'page-header\']/div/a[2]");//Clica em login na home page
        dsl.escrevePorXpath("//*[@id=\'login\']/div/div/form/div[1]/input", AppSettings.LOGIN);//Escreve o login
        dsl.escrevePorXpath("//*[@id=\1login\1]/div/div/form/div[2]/input", AppSettings.SENHA);//Escreve a senha
        dsl.clicaPorXpath("//*[@id=\'login\']/div/div/form/div[4]/button");//Clica em entrar
    }
}
