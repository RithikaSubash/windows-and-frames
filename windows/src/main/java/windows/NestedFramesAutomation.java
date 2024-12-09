package windows;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class NestedFramesAutomation {
	    public static void main(String[] args) {
	        
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        WebDriver driver = new ChromeDriver();

	        try {
	            
	            driver.manage().window().maximize();
	            driver.get("http://the-internet.herokuapp.com/nested_frames");

	           
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

	         
	            int frameCount = driver.findElements(By.tagName("frame")).size();
	            if (frameCount == 3) {
	                System.out.println("Verified: Top frame contains 3 sub-frames.");
	            } else {
	                System.out.println("Verification failed: Top frame does not contain 3 sub-frames.");
	            }

	           
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));
	            String leftFrameText = driver.findElement(By.xpath("//body")).getText();
	            if (leftFrameText.equals("LEFT")) {
	                System.out.println("Verified: Left frame contains text 'LEFT'.");
	            } else {
	                System.out.println("Verification failed: Left frame text mismatch.");
	            }

	           
	            driver.switchTo().parentFrame();

	           
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
	            String middleFrameText = driver.findElement(By.cssSelector("div")).getText();
	            if (middleFrameText.equals("MIDDLE")) {
	                System.out.println("Verified: Middle frame contains text 'MIDDLE'.");
	            } else {
	                System.out.println("Verification failed: Middle frame text mismatch.");
	            }

	           
	            driver.switchTo().parentFrame();

	           
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-right']")));
	            String rightFrameText = driver.findElement(By.xpath("//body")).getText();
	            if (rightFrameText.equals("RIGHT")) {
	                System.out.println("Verified: Right frame contains text 'RIGHT'.");
	            } else {
	                System.out.println("Verification failed: Right frame text mismatch.");
	            }

	           
	            driver.switchTo().parentFrame();

	 
	            driver.switchTo().defaultContent(); // Switch to the main page to access bottom frame
	            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));
	            String bottomFrameText = driver.findElement(By.xpath("//body")).getText();
	            if (bottomFrameText.equals("BOTTOM")) {
	                System.out.println("Verified: Bottom frame contains text 'BOTTOM'.");
	            } else {
	                System.out.println("Verification failed: Bottom frame text mismatch.");
	            }

	          
	            driver.switchTo().defaultContent();
	            System.out.println("Successfully switched back to the main content.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           
	            driver.quit();
	        }
	    }
	}



