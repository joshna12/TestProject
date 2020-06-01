package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyGarage;
import pageObjects.SearchPage;

import java.io.IOException;

public class WatchlistSteps {
    private WebDriver driver;
    public WatchlistSteps(){
        driver =Hooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        myGarage = new MyGarage(driver);
    }
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private MyGarage myGarage;
    @Given("User is on homepage")
    public void userIsOnHomepage() throws IOException {
       loginPage.userGetsTheUrl();
    }
    @When("^User login with correct credentials$")
    public void userLoginWithUserNameAndPassword() throws IOException, InterruptedException {
        loginPage.userClicksOnLoginButtonOnHomePage();
        loginPage.userEntersTheLoginCredentials();
    }
    @And("^User navigates to home page$")
    public void userNavigatesToHomePage(){
        loginPage.navigatesToHomePage();
    }
    @Then("^User verifies the title of the page as \"(.*)\"$")
    public void userVerifiesTheTitleOfThePage(String title){
        homePage.userVerifiesTheTitleOfHomepage(title);
    }
    @When("^User search for the car$")
    public void userSearchForTheCar(){
        homePage.userClicksOnSearchButton();
    }
    @And("^User verifies the 'Sort' filter and sort the result by \"(.*)\"$")
    public void userFiltersTheCarBySortOption(String option){
        homePage.verifyDefaultSortBy();
        homePage.sortBy(option);


    }
    @And("^User adds \"(.*)\" to watch list$")
    public void userAddsTheCarToWatchList(String carName){
        searchPage.userVerifiesTheTitle();
        searchPage.userAddsItemIntoWishList(carName);
    }
    @And("^User navigates to 'My Garage' pag$")
    public void userNavigateToTheMyGarageListPage(){
        homePage.navigateToMyGarage();
    }
    @And("^User verifies whether \"(.*)\" is added to the watchlist or not$")
    public void userVerifiesCarIsAddedToTheWatchListOrNot(String carName){
        myGarage.verifyCarIsAddedToTheWatchList(carName);
    }
    @And("^User removes the added cars from watchlist$")
    public void userRemovesTheAddedCars(){
        myGarage.remove1stCarFromWatchLit();
        myGarage.remove2ndCarFromWatchLit();
    }
    @And("^User verifies whether the cars are removed successfully or not$")
    public void userVerifiesWhetherCarsAreRemovedFromTheWatchList(){
        myGarage.verifyCarIsRemovedFromTheWatchList();
    }
    @And("^User Logs out$")
    public void userLogsOut(){
        homePage.userLogout();
    }


}
