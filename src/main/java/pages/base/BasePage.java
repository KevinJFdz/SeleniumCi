package pages.base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private static WebDriver driver;

    public BasePage(){
        PageFactory.initElements(driver,this);
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected void visit(String url){
        driver.get(url);
    }

    protected void enter(WebElement element, String textToEnter){
        element.sendKeys(textToEnter);
    }

    protected void click(WebElement element){
        element.click();
    }

    protected boolean isDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (NoSuchElementException exception){
            return false;
        }
    }
}
