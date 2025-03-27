package Testes;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Componentes {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");
    }
    
    @Test //Nome
    public void nome() {
        WebElement caixaNome = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
        String nome = "Ivan";
        caixaNome.sendKeys(nome);
        Assert.assertEquals(nome, caixaNome.getAttribute("value"));
    }
    
    @Test //Sobrenome
    public void sobrenome() {
        WebElement caixaSobrenome = driver.findElement(By.xpath("//input[@ng-model='LastName']"));
        String sobrenome = "Nantes";
        caixaSobrenome.sendKeys(sobrenome);
        Assert.assertEquals(sobrenome, caixaSobrenome.getAttribute("value"));
    }
    
    @Test //Endereço
    public void endereco() {
        WebElement caixaEndereco = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        String endereco = "Rua Genérica, 1001, Centro, Londrina/PR";
        caixaEndereco.sendKeys(endereco);
        Assert.assertEquals(endereco, caixaEndereco.getAttribute("value"));
    }
    
    @Test //E-mail
    public void email() {
        WebElement caixaEmail = driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
        String email = "ivanemail@gmail.com";
        caixaEmail.sendKeys(email);
        Assert.assertEquals(email, caixaEmail.getAttribute("value"));
    }
    
    @Test //Telefone
    public void telfone() {
        WebElement caixaTelefone = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
        String telefone = "(43) 3304 9307";
        caixaTelefone.sendKeys(telefone);
        Assert.assertEquals(telefone, caixaTelefone.getAttribute("value"));
    }

    @Test //Seleciona Genero Masculino
    public void SelecionarGenero() {
        WebElement generoMasc = driver.findElement(By.xpath("//input[@ng-model='radiovalue'][@value='Male']"));
        generoMasc.click();
        Assert.assertTrue(generoMasc.isSelected());
    }
    
    @Test //Selecionar Filmes como hobbie
    public void hobbies() {
        WebElement hobbieFilmes = driver.findElement(By.id("checkbox2"));
        hobbieFilmes.click();
        Assert.assertTrue(hobbieFilmes.isSelected());
    }
    
    @Test //Selecionar Idioma Português
    public void selecionarIdioma() {
        WebElement caixaIdioma = driver.findElement(By.id("msdd"));
        Assert.assertNotNull(caixaIdioma);
        caixaIdioma.click();
        
        WebElement idiomaLink = driver.findElement(By.linkText("Portuguese"));
        Assert.assertNotNull(idiomaLink);
        idiomaLink.click();
    }
    
    @Test //Seleciona Java em Habilidades
    public void habilidades (){
        WebElement element = driver.findElement(By.id("Skills"));
        Select selectionOption = new Select(element);

        selectionOption.selectByValue("Java");
        Assert.assertEquals("Java", selectionOption.getFirstSelectedOption().getText());

    }
        
    @Test // Data de nascimento (ano, mês e dia)
    public void dataNascimento() {
        // Seleciona o ano
    	 WebElement selectAno = driver.findElement(By.id("yearbox"));
    	 Select anoSelect = new Select(selectAno);
    	 anoSelect.selectByVisibleText("2004");  
    	 Assert.assertEquals("2004", anoSelect.getFirstSelectedOption().getText());

        // Seleciona o mês
    	 WebElement selectMes = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
    	 Select mesSelect = new Select(selectMes);
    	 mesSelect.selectByVisibleText("March");
    	 Assert.assertEquals("March", mesSelect.getFirstSelectedOption().getText());

        // Seleciona o dia
        WebElement selectDia = driver.findElement(By.id("daybox"));
        Select diaSelect = new Select(selectDia);
        diaSelect.selectByVisibleText("2");  
        Assert.assertEquals("2", diaSelect.getFirstSelectedOption().getText());
    }
    
    
    @Test //senha
    public void senha() {
        WebElement caixaSenha = driver.findElement(By.id("firstpassword"));
        String senha = "senha123senha";
        caixaSenha.sendKeys(senha);        
        Assert.assertEquals(senha, caixaSenha.getAttribute("value"));
    }

    @Test // confirmação de senha
    public void confirmacaoSenha() {
        WebElement caixaConfirmacaoSenha = driver.findElement(By.id("secondpassword"));
        String confirmacaoSenha = "senha123senha";
        caixaConfirmacaoSenha.sendKeys(confirmacaoSenha);
        Assert.assertEquals(confirmacaoSenha, caixaConfirmacaoSenha.getAttribute("value"));
    }
    
}