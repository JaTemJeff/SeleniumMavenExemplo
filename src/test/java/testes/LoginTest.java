package testes;

import core.DSL;
import core.WebDriverFactory;
import static java.time.Clock.system;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.quit();
    }
    
    @Test
    public void loginTest(){
        loginPage.logar();
        //
    }
}
