package com.test.main;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

// downlod https://code.google.com/p/selenium/wiki/ChromeDriver and start

public class TestClass {

	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:9515");
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
	
		System.out.println("starting selenium web driver");
		
		System.out.println("1");
		driver.get("http://aajtak.intoday.in/story/sri-sri-ravishanker-praises-modi-1-752376.html");
		System.out.println("2");
		for(int a=0; a<9;a++){
			System.out.println("3");
			
		driver.findElement(By.xpath("//*[@id=\"comment_1055646\"]/li/div[7]/div/a[2]")).click();
		System.out.println("4");
		Thread.sleep(20000);
		System.out.println("start");
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getDomain() !=null && cookie.getDomain().contains("aajtak.intoday.in"))
				driver.manage().deleteCookie(cookie);
		}
		Thread.sleep(10000);
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
