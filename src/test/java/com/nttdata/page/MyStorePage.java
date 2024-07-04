package com.nttdata.page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MyStorePage {
    private  WebDriver driver;
    private  By textInciarSesion =  By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[3]/div/a/span");
    private  By inputCorreo =  By.xpath("//input[@id='field-email']");
    private  By inputPassw =  By.xpath("//input[@id='field-password']");
    private  By btnIniciarSesion =  By.xpath("//button[@id='submit-login']");
    private  By textCerrarSesion =  By.xpath("//a[contains(@class, 'logout')]");
    private  By textClothes =  By.xpath("//a[contains(@href, 'clothes')]");
    private  By textMen =  By.xpath("/html/body/main/section/div/div/div[1]/div[1]/ul/li[2]/ul/li[1]/a");
    private  By elementMen =  By.xpath("//h2[@class='h3 product-title']");
    private  By inputCantidad =  By.xpath("//input[@class='input-group form-control']");
    private  By btnAgregarCarrito =  By.xpath("//button[@class='btn btn-primary add-to-cart']");
    private  By textPopUp =  By.xpath("//h4[@id='myModalLabel']");
    private  By textPopUp2 =  By.xpath("//p[@class='cart-products-count']");
    private  By textMonto =  By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    private  By btnFinCompra =  By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a");
    private  By titleCarrito =  By.xpath("//h1[@class='h1']");
    private  By textMontoCarrito =  By.xpath("/html/body/main/section/div/div/div/section/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");

    public MyStorePage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickIniciarSesion() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(textInciarSesion));
        WebElement textIni = driver.findElement(textInciarSesion);
        textIni.click();
    }

    public void ingresarCorreo(String correo) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCorreo));
        WebElement inpt = driver.findElement(inputCorreo);
        inpt.sendKeys(correo);
    }

    public void ingresarPassw(String passw) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassw));
        WebElement inpt = driver.findElement(inputPassw);
        inpt.sendKeys(passw);
    }

    public void clickIniciaSesionCuenta() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(btnIniciarSesion));
        WebElement btn = driver.findElement(btnIniciarSesion);
        btn.click();
    }

    public String getCerrarSesion() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textCerrarSesion));
        WebElement text= driver.findElement(textCerrarSesion);
        String textclean = text.getText();
        return textclean.substring(1).trim();
    }

    public void clickClothes() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(textClothes));
        WebElement text = driver.findElement(textClothes);
        text.click();
    }
    public void clickMen() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textMen));
        WebElement text = driver.findElement(textMen);
        text.click();
    }
    public void clickPrimerElemento() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementMen));
        WebElement elm = driver.findElement(elementMen);
        elm.click();
    }
    public void ingresarCantidad(int cant) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCantidad));
        WebElement inpt = driver.findElement(inputCantidad);
        // Métodos para borrar input previo
        inpt.clear();
        Thread.sleep(500);
        inpt.sendKeys(Keys.CONTROL + "a");
        inpt.sendKeys(Keys.DELETE);
        inpt.sendKeys(String.valueOf(cant));
    }
    public void clickAgregarCarrito() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(btnAgregarCarrito));
        WebElement btn = driver.findElement(btnAgregarCarrito);
        btn.click();
    }

    public String getTextoPopUp() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(textPopUp));
        String popupText = text.getText();

        // Eliminar el primer carácter no visible (si es necesario)
        if (!popupText.isEmpty() && !Character.isWhitespace(popupText.charAt(0))) {
            popupText = popupText.substring(1); // Elimina el primer carácter
        }
        return popupText;
    }
    public String getTextoPopUp2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textPopUp2));
        WebElement text= driver.findElement(textPopUp2);
        return text.getText();
    }

    public String getMonto() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textMonto));
        WebElement text= driver.findElement(textMonto);
        return text.getText();
    }
    public void clickFinalizarCompra() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(btnFinCompra));
        WebElement btn = driver.findElement(btnFinCompra);
        btn.click();
    }
    public String getTituloCarrito() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleCarrito));
        WebElement text= driver.findElement(titleCarrito);
        return text.getText();
    }
    public String getMontoCarrito() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textMontoCarrito));
        WebElement text= driver.findElement(textMontoCarrito);
        return text.getText();
    }





}
