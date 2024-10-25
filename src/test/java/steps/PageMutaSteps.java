package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PrincipalPageMuta;

public class PageMutaSteps {

    PrincipalPageMuta landingPage = new PrincipalPageMuta();

    @Given("The user navigate to mutaworld.com")
    public void iNavigateToMutaPrincipal() {
        landingPage.navigateToMuta();
    }

    @When("The user navigates to the Contactanos subpage")
    public void iNavigateToContactUsPage() {
        landingPage.navigateToContactUsPage();
    }

    @When("The user fills out the form with valid information")
    public void iFillOutTheFormWithValidInformation() {
        landingPage.fillContactForm("Jose", "Camilo", "MUTA Inc.", "jose.camilo@muta.com", "123456789", "Bosconia", "www.mutacompany.com");
    }

    @Then("The user successfully simulates sending the form")
    public void iSimulateSuccessfulFormSubmission() {
        landingPage.simulateFormSubmission();
    }
    @When("The user fills out the form with invalid information")
    public void iFillOutTheFormWithInvalidInformation() {
        landingPage.fillContactForm(".", ".", ".", "jose.camilo@muta.com", "123456789", ".", ".");
    }
    @When("The user does not fill in the form")
        public void iEmptyForm() {
            landingPage.emptyForm();
    }
    @When("User simulates form submission failure")
    public void iSimulateFailureFormSubmission() {
        landingPage.simulateFormFailureSubmission();
    }



    @Then("The form is cleared")
    public void iFormCleared(){
        landingPage.formCleared();

    }



}
