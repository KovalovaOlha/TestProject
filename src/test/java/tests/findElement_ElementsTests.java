package tests;

import org.testng.annotations.Test;
import utils.App;

public class findElement_ElementsTests extends TestBase{

    @Test()
    public void findElement_Elements(){
        App.findElement_Elements().elements();
        App.findElement_Elements().button();
        App.findElement_Elements().buttons1();
        App.findElement_Elements().buttons();
    }
    @Test()
    public void findElement_Elements2(){
        App.findElement_Elements().elements();
        App.findElement_Elements().buttonClick();
    }
}
