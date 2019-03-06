package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HelperBase {
  WebDriver wd;
  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void type(By locator, String text) {
    if(text!=null){
      waitForElementAndClick(locator, 15);
     // wd.findElement(locator).click();
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void waitForElementAndClick(By locator, long timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(wd, timeoutInSeconds);
    wd.findElement(locator).click();
  }


  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
