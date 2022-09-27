package TestNG;

import Browserlaunch.Readconfigproperties;
import Browserlaunch.TestNGMethods;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class TestNGMain {
    TestNGMethods obj=new TestNGMethods();
    @BeforeMethod
    public void Chromeopen(){
        obj.Chromelaunch();
    }

    @Test
    public void Amazonsearfirstchelement(){

        obj.Openurl("https://www.amazon.in");

        boolean flag=obj.Verifyelement(By.xpath("//a[text()='Mobiles']"));
        Assert.assertTrue(flag,"Homepage displayed and mobiles option is visible");
        obj.Clickoptions(By.xpath("//a[text()='Mobiles']"));
        //obj.Clickoptions(By.xpath("//span[text()='OnePlus']/../div/label/input/following-sibling::i"));
       // obj.Clickoptions(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-1']//h2/a"));
        obj.Customxpath("OnePlus");
      String Actual=obj.Clickonresultitem("1");
        obj.Switchtowindow();
        String expected=obj.Gettext(By.cssSelector("#productTitle"));
        Assert.assertEquals(Actual,expected,"selected product is not displaying");
        //obj.Clickoptions(By.xpath("//input[@id='add-to-cart-button']"));
        obj.Close();

    }

    @Test
    public void Handlealertpopups(){

        obj.Openurl("https://demo.guru99.com/test/delete_customer.php");
        obj.Waituntilclickable(By.xpath("//input[@name='cusid']"));
        obj.Entertext(By.xpath("//input[@name='cusid']"),"53920");
        obj.Clickoptions(By.xpath("//input[@name='submit']"));
        obj.Alerthandling("Gettext","");
        obj.Alerthandling("Dismiss","");
        obj.Close();
    }

    @Test
    public void Dropdownshandling() throws IOException {

        String Url= Readconfigproperties.Fetchproperties("ApplicationUrl");
        String Registerxpath=Readconfigproperties.Fetchproperties("Registerpath");

        obj.Openurl(Url);
        obj.Waituntilclickable(By.xpath(Registerxpath));
        obj.Clickoptions(By.xpath(Registerxpath));
        obj.Selectbytext(By.xpath("//select[@id='input-country']"), "India");
        obj.Close();
    }

    @Test
    public void Angulardropdownhandling(){

        obj.Openurl("https://api.freecrm.com/register/");
        obj.Entertext(By.xpath("//input[@name='email']"),"p.sri.rdy@gmail.com");
        obj.Angulardropdown(By.xpath("//input[@class='search']"),"in");
        obj.Entertext(By.xpath("//input[@name='phone']"),"9959640760");
        obj.Clickoptions(By.xpath("//input[@id='terms']"));
        obj.Close();
    }

    @Test
    public void Vehicleassment(){

        obj.Openurl("https://www.formsite.com/templates/registation-form-templates/vehicle-registration-form/");
        obj.Clickoptions(By.xpath("//img[@loading='lazy']"));
        obj.Switchtoframe(By.xpath("//iframe[@id='frame-one748593425']"));
        obj.Entertext(By.xpath("//input[@id='RESULT_TextField-2']"),"2000");
        obj.Close();
    }

    @Test
    public void Myntraapp(){

        obj.Openurl("https://www.myntra.com/");
        obj.Usingactionclassesselectingitem("kids","Boys Clothing","T-Shirts");
        obj.Close();
    }

}
