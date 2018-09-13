package core;

public class AppSettings {
    
    public static String URL_SITE = "https://ration.io/";
    
    public static String LOGIN = "renata_gizzi@hotmail.com";
    public static String SENHA = "12345";
    
    //Fechar browser ao fim de cada teste, ou executar tudo no mesmo browser
    public static boolean FECHAR_BROWSER = true;
    
    //Escolhe em qual browser rodar
    public static Browsers browser = Browsers.CHROME;
    
    public enum Browsers {
        CHROME,
        PHATOMJS,
        CHROME_HEADLESS
    }
}
