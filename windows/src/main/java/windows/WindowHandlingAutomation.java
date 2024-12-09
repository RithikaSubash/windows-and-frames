package windows;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import java.util.Set;

	public class WindowHandlingAutomation {
	    public static void main(String[] args) {
	        
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        WebDriver driver = new ChromeDriver();

	        try {
	           
	            driver.manage().window().maximize();

	            driver.get("https://the-internet.herokuapp.com/windows");

	            WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
	            clickHereButton.click();

	            
	            String originalWindow = driver.getWindowHandle();
	            Set<String> allWindows = driver.getWindowHandles();
	            for (String window : allWindows) {
	                if (!window.equals(originalWindow)) {
	                    driver.switchTo().window(window);
	                    break;
	                }
	            }

	            WebElement newWindowText = driver.findElement(By.tagName("h3"));
	            if (newWindowText.getText().equals("New Window")) {
	                System.out.println("Text 'New Window' is verified.");
	            } else {
	                System.out.println("Text verification failed.");
	            }

	            driver.close();

	            driver.switchTo().window(originalWindow);
	            if (driver.getTitle().equals("The Internet")) {
	                System.out.println("Original window is active.");
	            } else {
	                System.out.println("Original window verification failed.");
	            }

	            driver.quit();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           
	            if (driver != null) {
	                driver.quit();
	            }
	        }
	    }
	}



