package com.nttdata.steps;


import com.nttdata.page.MyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MyStoreStep {
    WebDriver driver;
    MyStorePage page;

    public MyStoreStep(WebDriver driver){
        this.driver = driver;
        page = new MyStorePage(driver);
    }

    public void navegarA(String url){
        driver.get(url);
    }
    public void iniciarSesion(String correo, String passw) throws InterruptedException {
        page.clickIniciarSesion();
        page.ingresarCorreo(correo);
        page.ingresarPassw(passw);
        page.clickIniciaSesionCuenta();
    }
    public void validarInicioSesion() throws InterruptedException {
        Assertions.assertEquals("Cerrar sesión", page.getCerrarSesion());
    }

    public void navegarCategorias() throws InterruptedException {
        page.clickClothes();
        page.clickMen();
    }
    public void agregarCantidadProducto(int cant) throws InterruptedException {
        page.clickPrimerElemento();
        page.ingresarCantidad(cant);
        page.clickAgregarCarrito();
    }
    public void validarPopUp() throws InterruptedException {
        Assertions.assertEquals("Producto añadido correctamente a su carrito de compra", page.getTextoPopUp());
        Assertions.assertEquals("Hay 2 artículos en su carrito.", page.getTextoPopUp2());
    }
    public void validarMonto() throws InterruptedException {
        Assertions.assertEquals("S/ 38.24", page.getMonto());
    }
    public void finalizarCompra() throws InterruptedException {
        page.clickFinalizarCompra();
    }
    public void validarTituloCarrito() throws InterruptedException {
        Assertions.assertEquals("CARRITO", page.getTituloCarrito());
    }
    public void validarCalculoCarrito() throws InterruptedException {
        Assertions.assertEquals("S/ 38.24", page.getMontoCarrito());
    }





}
