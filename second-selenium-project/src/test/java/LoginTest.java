import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
@BeforeMethod
public void ensurePreconditions() {
  if (app.isUserLoggedIn()) {
    app.logout();
  }
}
  @Test
  public void testLogIn() {
    app.clickOnLoginButton();
    app.fillLoginForm();
    app.confirmLogin();
  }


}
