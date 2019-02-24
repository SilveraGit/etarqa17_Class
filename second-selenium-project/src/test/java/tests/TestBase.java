package tests;

import com.google.common.io.Files;
import manager.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class TestBase {

  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

  public  static  class  MyListener extends AbstractWebDriverEventListener{
    public MyListener() {
      super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println("search " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println("!!!------------------------------------------------------------------!!!");
      System.out.println("---------------------------------ERRORRR!!!------------------------");
      System.out.println(throwable);

      File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File screenshot = new File("screenshot-" + System.currentTimeMillis() + ".png");

      try {
        Files.copy(tmp, screenshot);
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("screenshot: "+screenshot);
         System.out.println("_____________________________________________________________");
    }
  }

  @BeforeSuite
  public void setUp() {
    app.start();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
