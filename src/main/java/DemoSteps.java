import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Console;

public class DemoSteps {
    private WebDriver driver;


    @Given("I am on the Sauce Demo Login Page")
    public void iAmOnTheSauceDemoLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nayab\\Desktop\\Maven Automation\\CucumberDemo\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I fill the account information for account StandardUser into the Username field and the Password field")
    public void fillInformation() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @When("I fill the account information for account LockedOutUser into the Username field and the Password field")
    public void lockedOutUserFillInformation() {
        driver.findElement(By.name("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }


    @And("I click the Login Button")
    public void clickLogin() {
        driver.findElement(By.name("login-button")).submit();
    }

    @Then("I am redirected to the Sauce Demo Main Page")
    public void Redirected (){
      driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).isDisplayed();
    }


    @Then("I verify the Error Message contains the text \"Sorry, this user has been banned.\"")
    public void errorMessage (){
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).isDisplayed();
    }

    @And("I verify the App Logo exists")
    public void appLogoExist() {
        driver.findElement(By.className("app_logo")).isDisplayed();
    }
}

