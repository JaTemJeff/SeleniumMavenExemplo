package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

    WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    //-------------------------------------------------------------- METODOS ESCREVER (SENDKEYS) -------------------------------------------------------------- 
    public void escrevePorXpath(String xpath, String texto) {
        WebElement input = driver.findElement(By.xpath(xpath));
        input.clear();
        input.sendKeys(texto);
    }

    //-------------------------------------------------------------- METODOS CLICAR (CLICK) ------------------------------------------------------------------
    public void clicaPorXpath(String xpath) {
        WebElement elemento = driver.findElement(By.xpath(xpath));
        elemento.click();
    }

    //-------------------------------------------------------------- METODOS DE ESPERA ------------------------------------------------------------------------
    public void esperaPorXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    //-------------------------------------------------------------- Retornar valor ------------------------------------------------------------------------
    public String retornaTextoLabel(String xpath) {
        String texto = driver.findElement(By.xpath(xpath)).getText();
        return texto;
    }

    public boolean retornaSeTextoExisteNaPagina(String texto) {
        boolean verifica = driver.getPageSource().contains(texto);
        return verifica;
    }

    // ------------------------------------------------------------- Navegação ------------------------------------------------------------
    public void vaiParaAPaginaInicial() {
        driver.get(AppSettings.URL_SITE);
    }
}
