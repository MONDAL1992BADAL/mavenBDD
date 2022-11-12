 package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	
	WebDriver driver = null;
	@Given("browser is open")
	public void browser_is_open() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		
		driver.navigate().to("https://google.com");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("https://www.skyvill.in/");
		
		Thread.sleep(2);
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException {
		driver.getPageSource().contains("SkyVill: Home");
		Thread.sleep(2);
		driver.close();
	}


}
