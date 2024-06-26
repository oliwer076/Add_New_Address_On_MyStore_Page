import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewAddressStepdefs {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I logged in and click on ADD FIRST ADDRESS")
    public void iLoggedInAndClickOnADDFIRSTADDRESS() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        WebElement element = driver.findElement(By.cssSelector("input[type=email]"));
        element.sendKeys("oo@wp.pl");
        WebElement element1 = driver.findElement(By.cssSelector("input[type=password]"));
        element1.sendKeys("12345");
        WebElement element2 = driver.findElement(By.cssSelector("button[type=submit]"));
        element2.click();
        WebElement element3 = driver.findElement(By.cssSelector("[id=\"addresses-link\"]"));
        element3.click();
        WebElement element4 = driver.findElement(By.cssSelector("[data-link-action=\"add-address\"]"));
        element4.click();
    }

    @When("I enter {string} as alias")
    public void iEnterAsAlias(String alias) {
        WebElement element = driver.findElement(By.cssSelector("input[name=alias]"));
        element.click();
        element.sendKeys(alias);
    }

    @And("I enter {string} as address")
    public void iEnterAsAddress(String address) {
        WebElement element = driver.findElement(By.cssSelector("input[name=address1]"));
        element.sendKeys(address);
    }

    @And("I enter {string} as city")
    public void iEnterAsCity(String city) {
        WebElement element = driver.findElement(By.cssSelector("input[name=city]"));
        element.click();
        element.sendKeys(city);
    }

    @And("I enter {string} as zip")
    public void iEnterAsZip(String zip) {
        WebElement element = driver.findElement(By.cssSelector("input[name=postcode]"));
        element.click();
        element.sendKeys(zip);
    }

    @And("I enter {string} as country")
    public void iEnterAsCountry(String country) {
        WebElement element = driver.findElement(By.cssSelector("select[name=id_country]"));
        element.click();
        WebElement element1 = driver.findElement(By.cssSelector("option[value=\"17\"]"));
        element1.click();
    }

    @And("I enter {string} as phone")
    public void iEnterAsPhone(String phone) {
        WebElement element = driver.findElement(By.cssSelector("input[name=phone]"));
        element.click();
        element.sendKeys(phone);
    }

    @And("I check all of typed data are correct {string}, {string}, {string}, {string}, {string}, {string}")
    public void iCheckAllOfTypedDataAreCorrect(String alias, String address, String city, String zip, String country, String phone) {

        WebElement aliasField = driver.findElement(By.id("field-alias"));
        aliasField.click();
        Assert.assertEquals(alias, aliasField.getAttribute("value"));

        WebElement addressField = driver.findElement(By.id("field-address1"));
        addressField.click();
        Assert.assertEquals(address, addressField.getAttribute("value"));

        WebElement cityField = driver.findElement(By.id("field-city"));
        cityField.click();
        Assert.assertEquals(city, cityField.getAttribute("value"));

        WebElement zipField = driver.findElement(By.id("field-postcode"));
        zipField.click();
        Assert.assertEquals(zip, zipField.getAttribute("value"));

        WebElement countryField = driver.findElement(By.id("field-id_country"));
        countryField.click();
        Assert.assertEquals(country, countryField.getAttribute("value"));

        WebElement phoneField = driver.findElement(By.id("field-phone"));
        phoneField.click();
        Assert.assertEquals(phone, phoneField.getAttribute("value"));
    }

    @And("I click SAVE button")
    public void iClickSAVEButton() {
        WebElement element = driver.findElement(By.cssSelector("button[type=submit]"));
        element.click();
    }

    @Then("New address is added")
    public void newAddressIsAdded() {
        wait.until(ExpectedConditions.urlContains("https://mystore-testlab.coderslab.pl/index.php?controller=addresses"));
    }
}
