package StepDefsLogin;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartPrintPrice {
	WebDriver driver = null;
	WebElement element = null;

	@SuppressWarnings("deprecation")
	@Given("user launch browser")
	public void user_launch_browser() {
		//setup chrome webdriver and navigate to flipkart homepage
		String projectpath = System.getProperty("user.dir");
		System.out.println("This is the project path" + projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@When("user navigates to flipkart homepage")
	public void user_navigates_to_flipkart_homepage() {
		driver.manage().deleteAllCookies();
		driver.navigate().to(
				"https://www.flipkart.com/");
		//	Thread.sleep(4000);
	}
	@And("searches for a mobile device")
	public void searches_for_a_mobile_device() {
		//closes login alert and enters name of mobile device in search bar
		driver.findElement(By.xpath("//*[@class=\"_2KpZ6l _2doB4z\"]")).click();
		driver.findElement(By.xpath("//*[@class=\"_3704LK\"]")).sendKeys("Realme" + Keys.ENTER);
		driver.findElement(By.xpath("//*[@class=\"_4rR01T\"]")).click();
	}

	@And("adds mobile to cart increasing the quantity by one")
	public void adds_mobile_to_cart_increasing_the_quantity_by_one() {
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles); //get all windows handles in current instance
		Iterator<String> iterator = windowhandles.iterator(); //iterator on a set of tabs
		String parentwindow = iterator.next();
		//System.out.println(parentwindow);
		String childwindow = iterator.next();
		driver.switchTo().window(childwindow);
		String phoneprice = driver.findElement(By.xpath("//*[@class=\"_30jeq3 _16Jk6d\"]")).getText();
		System.out.println("Price of 1 Realme phone is " + phoneprice);

	}

	@Then("user can see updated price of two smartphones")
	public void user_can_see_updated_price_of_two_smartphones() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver; //Javascript executor to scroll into view 
		//Thread.sleep(4000);
		WebElement additems = driver.findElement(By.xpath("//*[@class=\"_3dsJAO\"]"));
		executor.executeScript("arguments[0].scrollIntoView(true);", additems);
		driver.findElement(By.xpath("//*[text()='+']")).click();
		Thread.sleep(1000);
		String newphoneprice = driver.findElement(By.xpath("//div[@id='container']//div//div//div//div//div//div//div//div//div//div//div//div//div//span")).getText();
		System.out.println("Price of 2 phones is " + newphoneprice);
		//driver.close();
		//driver.quit();
	}

}


