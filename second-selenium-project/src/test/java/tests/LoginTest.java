package tests;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

  Logger logger = LoggerFactory.getLogger(LoginTest.class);

@BeforeMethod
public void ensurePreconditions() {
  if (app.getSessionHelper().isUserLoggedIn()) {
    app.getSessionHelper().logout();
  }
}
  @Test
  public void testLogIn() {
  logger.info("Start test testLogIn");
    app.getSessionHelper().clickOnLoginButton();
    app.getSessionHelper().fillLoginForm("elena.telran@yahoo.com", "12345.com");
    app.getSessionHelper().confirmLogin();

    logger.info("Stop test testLogIn");
    }


}
