package tests;

import model.Team;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TeamCreationTest extends TestBase {
  @DataProvider
  public Iterator<Object[]>validTeam(){
    List<Object[]>list = new ArrayList<>();
    list.add(new Object[]{"test1","description"});
    list.add(new Object[]{"test2","description- description"});
    list.add(new Object[]{"test-test2","description- description2;"});

    return list.iterator();
  }

//  @DataProvider
//  public Iterator<Object[]>validTeam() throws IOException {
//    List<Object[]>list = new ArrayList<>();
//    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/teams.csv")));
//    String line = reader.readLine();
//    while (line!=null){
//      String[] split = line.split(";");
//      list.add(new Object[] {new Team().withTeamName(split[0]).withDescription(split[1])});
//
//      line = reader.readLine();
//    }


    //return list.iterator();
  //}

  @BeforeMethod
  public void ensurePreconditions() {
    if (!app.getSessionHelper().isUserLoggedIn()) {
      app.getSessionHelper().login();
    }
  }

  @Test(dataProvider = "validTeam")
  public  void teamCreationFromLeftNavMenu(String teamName, String description){
    app.getTeamHelper().clickOnCreateTeamButtonOnNavMenu();
    app.getTeamHelper().fillTeamCreationForm(new Team()
            .withTeamName(teamName)
            .withDescription(description));
    app.getTeamHelper().submitTeamCreationForm();
  }

  @AfterMethod
  public  void postAction(){
  //app.getNavigationHelper().clickOnHomeButtonOnHeader();
    app.getNavigationHelper().returnToPreviousPage();
  }



}
