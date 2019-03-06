package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnBoardButtonOnLeftNavMenu(){
  //  click(By.);
  }

  public void  clickOnHomeButtonOnHeader(){
    click(By.cssSelector(".icon-house"));
  }

  public void returnToPreviousPage() {
    wd.navigate().back();
  }
}
