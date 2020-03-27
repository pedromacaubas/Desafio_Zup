package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public HomePage preencherCampoBusca(String produto) {
        navegador.findElement(By.xpath("//INPUT[@id='search-input']")).click();
        navegador.findElement(By.xpath("//INPUT[@id='search-input']")).sendKeys(produto);

        return this;
    }
   //btnHeaderSearch
   public HomePage clicarBotaoBusca() {
//
       navegador.findElement(By.xpath("//BUTTON[@type='submit'][text()='Buscar']")).click();;

       return this;
   }
    public HomePage clicarProduto() {
        navegador.findElement(By.xpath("//div/div/div/a/img")).click();
        return this;
    }

    //(//BUTTON[@type='submit'])[3]
    public CarrinhoPage clicarBotaoComprar() {
        navegador.findElement(By.xpath("//BUTTON[@id='buy-button-now']")).click();
        return new CarrinhoPage(navegador) ;
    }
    public String capturarTexto(){
        return navegador.findElement(By.xpath("//*[@id=\"content\"]/section/section[2]/h1")).getText ();
    }
    public String capturarProdutoInexistente(){
        return navegador.findElement(By.xpath("//H2[text()='Não foi possível encontrar resultados para o termo procurado']")).getText ();
    }
////A[@href='/servicos/cartao-presente?mi=hm_ger__mntop__R-cartao-presente&psn=Menu_Top'][text()='Cartão Presente']

    public HomePage clicarLinkCEP() {
        navegador.findElement(By.xpath("//P[@class='zipcode-content__block--text'][text()='Informe seu CEP']")).click();
        return this ;
    }
    public HomePage prrencherCampoCEP(String cep) {
        navegador.findElement(By.xpath("//INPUT[@class='zip__code ns-zipcode']")).sendKeys(cep);
        return this ;
    }
    public HomePage clicarBotaoConsultar() {


        navegador.findElement(By.xpath("//BUTTON[@class='zip__code--calculate']")).click();
        return this ;
    }
    public String capturarTextoCEP(){
        return navegador.findElement(By.xpath("//P[@class='text__sucess']")).getText ();
    }


}