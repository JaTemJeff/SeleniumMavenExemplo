package pages_metodo_professor;

import core.AppSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage2 extends BasePage {
    
    public LoginPage2(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\'login\']/div/div/form/div[1]/input")
    WebElement input_login;
    
    @FindBy(xpath = "//*[@id=\'login\']/div/div/form/div[2]/input")
    WebElement input_senha;
    
    @FindBy(xpath = "//*[@id=\'login\']/div/div/form/div[4]/button")
    WebElement btn_entrar;
    
    @FindBy(xpath = "//*[@id=\"page-header\"]/div/a[2]")
    WebElement link_login;
    
    public LoginPage2 setLogin(String login) {
        input_login.clear();
        input_login.sendKeys(login);
        return this;
    }
    
    public LoginPage2 setSenha(String senha) {
        input_senha.clear();
        input_senha.sendKeys(senha);
        return this;
    }
    
    public String getLogin() {
        return input_login.getAttribute("value");
    }
    
    public String getSenha() {
        return input_senha.getAttribute("value");
    }
    
    public LoginPage2 clicaEntrar() {
        btn_entrar.click();
        return this;
    } 
    
    public LoginPage2 clicaLogin(){
        link_login.click();
        return this;
    }

    void goToHomePage() {
        driver.get(AppSettings.URL_SITE);
    }
    
    public String getURL(){
        return driver.getCurrentUrl();
    }
    
    void waitFriendPage(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\'friends\']/div/div[1]/div/button")));
    }
}
