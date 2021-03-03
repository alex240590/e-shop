package com.geekbrains.framework.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass {

    private WebDriver driver;

    @BeforeSuite
    public void init() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void testProductPageNull() {
//        driver.get("http://yandex.ru");
        driver.get("http://127.0.0.1:8080/e-shop/product");

//        WebElement webElement = driver.findElement(By.cssSelector(".input__control.input__input"));
//        Assert.assertEquals(webElement.isEnabled(), true);

//        WebElement webElement = driver.findElement(By.cssSelector(".input__control.input__input"));
//        webElement.click();
//        webElement.clear();
//        webElement.sendKeys("Java");
//        webElement.submit();
////
//        List<WebElement> answerBlocks = driver
//                .findElement(By.cssSelector(".content__left"))
//                .findElements(By.cssSelector(".serp-item"));

//        Assert.assertEquals(answerBlocks.size(), 16);
//////
        for (WebElement o: answerBlocks) {
            String txt = o.findElement(By.ClassName("table table-bordered my-2")).getText();
//            System.out.println(txt);
            Assert.assertTrue(txt.contains("Нет продуктов с заданными параметрами"));
        }
    }

    @AfterSuite
    public void shutdown() {
        this.driver.quit();
    }
}
