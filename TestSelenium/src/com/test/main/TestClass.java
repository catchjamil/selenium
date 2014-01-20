package com.test.main;

import java.net.URL;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

// downlod https://code.google.com/p/selenium/wiki/ChromeDriver and start
//284
public class TestClass {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:9515");
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
	
		System.out.println("starting selenium web driver");
		
		driver.get("google.com");
		System.out.println("2");
		for(int a=0; a<999;a++){
			System.out.println("counter: "+a);
			
		driver.findElement(By.xpath("//*[@id=\"ratingdiv\"]/div[1]/div/a[1]")).click();

		
		Thread.sleep(1000 * (new Random().nextInt(9)));
		System.out.println("start");
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getDomain() !=null && cookie.getDomain().contains("google.com"))
				driver.manage().deleteCookie(cookie);
		}
		Thread.sleep(5000);
		System.out.println("end");
		}
		try {  
			Thread.sleep(2000);
		} catch (Exception e) {
		}

	//	driver.close();
	//	driver.quit();
	}
}
