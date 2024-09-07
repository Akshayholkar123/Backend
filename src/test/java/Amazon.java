    import java.time.Duration;
    import java.util.List;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.interactions.Actions;

    import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;
import groovyjarjarasm.asm.commons.ModuleTargetAttribute;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
public static void main(String[] args) {
	
	/*WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	

	
	
ChromeOptions ops=new ChromeOptions();
ops.addArguments("--remote-allow-origins=*");//ops.addArguments("--remote-allow-origins=*");

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//driver.get("http://www.amazon.in");
	driver.get("https://in.search.yahoo.com/?fr2=inr");
	List <WebElement> ele=driver.findElements(By.xpath("//span[@class='D(ib) Td(u):h Ell']"));
for(WebElement s:ele)
{
	System.out.println(s.getText());
}
	
	
     /*driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone15");
     driver.findElement(By.id("nav-search-submit-button")).click();
     driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
     */
//     String wh=driver.getWindowHandle();
//  // System.out.println(driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText());
//   driver.switchTo().window(wh);
//     List<WebElement> colorList = driver.findElements(By.xpath("//img[@class='imgSwatch']"));
//    for(WebElement color:colorList)
//    {
//    	System.out.println(color.getAttribute("alt"));
//    }
//    
//    
//    // Close the browser
//   // driver.quit();*/
//    
    
    
    

      
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);

            try {
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driver.get("https://www.flipkart.com/");

                WebElement fashionElement = driver.findElement(By.xpath("//span[text()='Fashion']"));
                Actions actions = new Actions(driver);
                actions.moveToElement(fashionElement).perform();

                List<WebElement> fashionList = driver.findElements(By.xpath("//div[@class='_3490ry']"));
                for (WebElement item : fashionList) {
                    System.out.println(item.getText());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
    
}