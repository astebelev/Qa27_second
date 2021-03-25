package com.telran.qa.second;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://www.google.com/");
    }

    @Test
    public void testGoogleSearch() {

        click(By.name("q"));
        wd.findElement(By.name("q")).clear();
        wd.findElement(By.name("q")).sendKeys("WebDriver" + Keys.ENTER);
        click(By.cssSelector("[href='https://www.selenium.dev/documentation/en/webdriver/'"));
        wd.navigate().back();
        /*Assert*/
    }

    @Test
    public void testSearchImg() {

        click(By.name("q"));

        // wd.findElement(By.name("q")).click();
        wd.findElement(By.name("q")).clear();
        wd.findElement(By.name("q")).sendKeys("Java" + Keys.ENTER);
        click(By.cssSelector("[data-hveid='CAEQAw']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public int mult(int a, int b) {
        return a * b;
    }
    public void type(By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    @Test(enabled = false)
    public void myMult() {
        int res = mult(2, 5);
        System.out.println(res);

    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }


}
