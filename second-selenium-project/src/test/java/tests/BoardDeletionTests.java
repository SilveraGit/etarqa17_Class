package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase {
  @Test(enabled = false)
  public  void testBoardDeletion(){
    int before= app.getBoardHelper().PersonalBoardsCount();;
//    app.getBoardHelper().selectPersonalBoard();
//    app.getBoardHelper().clickMoreButton();
//    app.getBoardHelper().clickCloseBoard();
//    app.getBoardHelper().confirmCloseBoard();
int after= app.getBoardHelper().PersonalBoardsCount();;
    Assert.assertEquals(after, before-1);


  }
}
