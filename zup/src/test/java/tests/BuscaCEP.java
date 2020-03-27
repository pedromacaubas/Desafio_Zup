package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;
import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class) // com essa anotation estou dizendo para usar a biblioteca DataDrivenTestRunner
@DataLoader(filePaths = "C:\\zup\\src\\main\\resources\\ConsultaCEP.csv") // filePaths são os arquivos que queremos utilizar, coloquei

public class BuscaCEP {
    // variavel do tipo webdriver
    private WebDriver navegador;
    @Rule
    public TestName test = new TestName();
  @Before
    public void setUp(){

      //chamando direto a página
      navegador = Web.createChrome ();

  }
@Test
    public void testInformarCEP(
            @Param( name="cep")String cep,
            @Param( name="mensagem")String mensagemEsperada
    ){
      String texto = new HomePage( navegador )
               .clicarLinkCEP()
               .prrencherCampoCEP(cep)
               .clicarBotaoConsultar()
               .capturarTextoCEP();
       assertEquals ( mensagemEsperada,texto);
       String screenshotArquivo = "C:\\Evidencias\\Evidencias\\BuscaCEP" + Generator.dataHoraParaArquivo () + test.getMethodName() + ".png";
       Screenshot.tirar ( navegador, screenshotArquivo);
  }
@After
    public void tearDown() {
        navegador.quit();
  }

}
