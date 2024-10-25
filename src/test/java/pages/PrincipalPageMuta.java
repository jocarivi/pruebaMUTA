package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class PrincipalPageMuta extends PageMuta {

    public PrincipalPageMuta() {
        super(driver);
    }


    public void navigateToMuta() {
        navigateTo("https://mutaworld.com");

    }
    public void navigateToContactUsPage() {
        driver.findElement(By.id("nav-menu-item-2800")).click();
    }

    public void fillContactForm(String firstName, String lastName, String companyName, String email, String phoneNumber, String city, String website ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hs_firstname.hs-firstname.hs-fieldtype-text.field.hs-form-field")));
        driver.findElement(By.id("firstname-77d7c92f-cc7f-4623-8408-98f9fdf8af74")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("0-2/name")).sendKeys(companyName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys(phoneNumber);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("0-2/domain")).sendKeys(website);
        //driver.findElement(By.id("contactreason-77d7c92f-cc7f-4623-8408-98f9fdf8af74")).click();
        //Select motivoContacto = new Select(driver.findElement(By.name("contactreason")));
        //motivoContacto.selectByValue(contactreason);
        // Obtener todas las opciones del combo box
        WebElement comboBox = driver.findElement(By.id("contactreason-77d7c92f-cc7f-4623-8408-98f9fdf8af74"));
        comboBox.click();
       List<WebElement> options = comboBox.findElements(By.tagName("option"));

        Random random = new Random();
        int randomIndex = random.nextInt(options.size());


        WebElement selectedOption = options.get(randomIndex);

        // Si la opción seleccionada es la deshabilitada "Motivo de contacto", elegimos otra opción
        while (selectedOption.isEnabled() == false || selectedOption.getAttribute("value").equals("Motivo de contacto")) {
            randomIndex = random.nextInt(options.size());
            selectedOption = options.get(randomIndex);
            }

        selectedOption.click();
        comboBox.click();


    }


    public void simulateFormSubmission() {

        ((JavascriptExecutor) driver).executeScript("alert('Formulario enviado exitosamente');");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No hay alerta presente en este momento.");
        }


    }

    public void simulateFormFailureSubmission(){
        ((JavascriptExecutor) driver).executeScript("alert('Formulario incorrecto, campos vacios');");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No hay alerta presente en este momento.");
        }

    }
    public void emptyForm(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.hs-button.primary.large")));
        driver.findElement(By.cssSelector("input.hs-button.primary.large")).click();
    }

    public void formCleared(){
        driver.findElement(By.id("firstname-77d7c92f-cc7f-4623-8408-98f9fdf8af74")).clear();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("0-2/name")).clear();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("0-2/domain")).clear();
    }


}