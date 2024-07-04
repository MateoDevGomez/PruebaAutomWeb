package com.nttdata.stepsdefinitions;
import com.nttdata.steps.MyStoreStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStoreStepDef {
    private MyStoreStep mystore;
    private WebDriver driver;
    private Scenario scenario;

    //################################################################
    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    //################################################################

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        mystore = new MyStoreStep(driver);
        mystore.navegarA("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String correo, String passw) throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.iniciarSesion(correo,passw);

        screenShot();

    }

    @Then("Autentifico que el logeo se realizo con exito")
    public void autentificoQueElLogeoSeRealizoConExito() throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.validarInicioSesion();
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.navegarCategorias();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cant) throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.agregarCantidadProducto(cant);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.validarPopUp();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.validarMonto();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() throws InterruptedException {
        mystore = new MyStoreStep(driver);
        mystore.validarCalculoCarrito();
        screenShot();
    }
}
