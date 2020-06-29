package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/compra.feature"})

public class CompraTest {

	@BeforeClass public static void cleanup() throws Exception {
		
		
	}
	
	@AfterClass public static void setup() throws Exception {
		
		
	}
}
