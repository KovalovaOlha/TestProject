package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.App;


public class WebTableTest extends TestBase{

    @Test()
    public void ElementsTabel(){
       App.WebTable().clickElements();
       App.WebTable().clickWebTable();
       App.WebTable().printTableData();
    }

    @Test
    public void testTableIsNotEmpty() {
        App.WebTable().clickElements();
        App.WebTable().clickWebTable();
        Assert.assertTrue(App.WebTable().isTableNotEmpty(), "Таблиця повинна містити дані");
    }
    @Test()
    public void ElementsTabel2(){
        App.WebTable().clickElements();
        App.WebTable().clickWebTable();
        App.WebTable().printTableData2();
    }

    @Test()
    public void ElementsTabel3(){
        App.WebTable().clickElements();
        App.WebTable().clickWebTable();
        App.WebTable().printTableData3();
    }

    @Test()
    public void ElementsTabel4(){
        App.WebTable().clickElements();
        App.WebTable().clickWebTable();
        App.WebTable().printTableData4();
    }

    @Test()
    public void ElementsTabel5(){
        App.WebTable().clickElements();
        App.WebTable().clickWebTable();
        App.WebTable().printTableData5();
    }

    //

}
