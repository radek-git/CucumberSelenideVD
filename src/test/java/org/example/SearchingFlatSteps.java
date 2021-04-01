package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.model.Flat;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.open;

public class SearchingFlatSteps extends BaseSteps{

    private HomePage homePage;
    private ResultPage resultPage;
    private List<Flat> flatDetails;

    @Given("User opens page={string}")
    public void user_opens_page(String url) {
        open(url);
    }

    @Given("User closes Cookie bar")
    public void user_closes_cookie_bar() {
        homePage = new HomePage();
        homePage.closeCookies();
    }

    @Given("User selects city={string}")
    public void user_selects_city(String city) {
        homePage.selectCity(city);
    }

    @Given("User clicks property={string}")
    public void user_clicks_property(String property) {
        homePage.clickPropertyName(property);
    }

//    @When("User clicks on every available flat")
//    public void user_clicks_on_every_available_flat() throws InterruptedException {
//        resultPage = new ResultPage();
//        resultPage.getFlatDetails();
//    }

    @When("User reads and saves all details of flats")
    public void user_reads_and_saves_all_details_of_flats() throws InterruptedException {
        resultPage = new ResultPage();
        flatDetails = resultPage.getFlatDetails();
    }

    @Then("All data is saved to file")
    public void all_data_is_saved_to_file() {
        List<Integer> flatNumbers = flatDetails.stream().map(flat -> flat.getFlatNumber()).collect(Collectors.toList());
    }
}
