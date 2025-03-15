package Lesson3;

import org.testng.annotations.Test;
import tests.TestBase;
import utils.App;

public class Lesson3Test extends TestBase {

    @Test()
    public void collectionListTest(){
        App.Collections().elements();
        App.Collections().clickCheckBox1();
    }

    @Test()
    public void collectionLinkedListTest(){

        App.Collections().clickWidgets();
        App.Collections().SelectMenu();
        App.Collections().oldSelectMenu();
        App.Collections().workWithOldSelectMenu();
    }
    @Test()
    public void collectionSetTest(){
        App.Collections().clickWidgets();
        App.Collections().SelectMenu();
        App.Collections().oldSelectMenu();
        App.Collections().workWithOldSelectMenu2();
    }
    @Test()
    public void collectionMapTest(){
        App.Collections().clickWidgets();
        App.Collections().SelectMenu();
        App.Collections().oldSelectMenu();
        App.Collections().workWithOldSelectMenu3();
    }
}
