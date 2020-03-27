package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage extends BasePage {

    public CarrinhoPage(WebDriver navegador) {
        super(navegador);
    }

    public String capturarTextoProduto(){
        //return navegador.findElement(By.xpath("//H3[@data-v-e5c5a73c='']")).getText ();
        return navegador.findElement(By.cssSelector("\".product-details__info > .name\"")).getText ();
    }
}