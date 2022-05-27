package StepDefsLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GmailCompose {
	WebDriver driver = null;
	WebElement element = null;

	@SuppressWarnings("deprecation")
	@Given("user visits gmail login page")
	public void user_visits_gmail_login_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		String projectpath = System.getProperty("user.dir");
		System.out.println("This is the project path" + projectpath);
		// Set Chrome Driver and open Gmail sign in Page
		System.setProperty("webdriver.chrome.driver", projectpath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to(
				"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		Thread.sleep(4000);
	}

	@And("user logins with valid username and valid password")
	public void user_logins_with_valid_username_and_valid_password() throws InterruptedException {
		// Login as test user
		driver.findElement(By.xpath("//input[@id=\"identifierId\"]")).sendKeys("testuser192748");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("testuser8282828");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

	}

	@When("user composes an email with subject and some body text")
	public void user_composes_an_email_with_subject_and_some_body_text() throws InterruptedException {
		// Click on compose, enter recipient enter subject and body text and hit send
		// mail
		driver.findElement(By.xpath("//*[@class=\"T-I T-I-KE L3\"]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@class=\"vO\"]")).sendKeys("testuser192748@gmail.com");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@name=\"subjectbox\"]")).sendKeys("Incubyte");
		Thread.sleep(500);
		element = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
		element.click();
		element.sendKeys("Hi user, \n" + "Automation QA test by Incubyte");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]")).click();
		Thread.sleep(500);
	}

	@Then("the email appears in the sent folder of gmail")
	public void the_email_appears_in_the_sent_folder_of_gmail() throws InterruptedException {
		// Check inbox for latest email
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[8]/div/div[1]/div[3]/div/table/tbody/tr[1]/td[4]/div[2]/span/span"))
				.click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}
}
