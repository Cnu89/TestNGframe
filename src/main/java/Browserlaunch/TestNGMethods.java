package Browserlaunch;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class TestNGMethods {
    WebDriver driver;
    public void Chromelaunch(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }
    public void Openurl(String url){
        driver.get(url);
    }
    public void Close(){
        driver.quit();
    }
    public boolean Verifyelement(By locator){
       return driver.findElement(locator).isDisplayed();
    }
    public void Clickoptions(By locator){
        driver.findElement(locator).click();
    }
    public void Entertext(By locator,String text){
        driver.findElement(locator).sendKeys(text);
    }
    public void Javascriptexecutorclickable(By locator){
        WebElement ele=driver.findElement(locator);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",locator);}

    public void Customxpath(String text){
        String xpath="//span[text()='"+text+"']/../div/label/input/following-sibling::i";
        Clickoptions(By.xpath(xpath));
    }
    public String Clickonresultitem(String text){
        String xpath="//div[@cel_widget_id='MAIN-SEARCH_RESULTS-"+text+"']//h2/a";
        String Actualtext=Gettext(By.xpath(xpath));
        Clickoptions(By.xpath(xpath));
        return Actualtext;
    }
    public String Gettext(By locator){
        String text=driver.findElement(locator).getText();
        return text;
    }
    public void Switchtowindow(){
        ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
    }
    public void Switchtowindowbytitle(String title){
        Set<String> allwindows=driver.getWindowHandles();
        for (String window:allwindows) {
            driver.switchTo().window(window);
            if (Gettitle().equals(title)) {
                break;
            }
        }
    }
    public String Gettitle(){
        String tilte= driver.getTitle();
        return tilte;
    }
    public void Waituntilclickable(By locator){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void Alerthandling(String alertmethod,String text){
        Alert alert=driver.switchTo().alert();
        switch (alertmethod){
            case "Accept":alert.accept();break;
            case "Dismiss":alert.dismiss();break;
            case "Gettext":String text1=alert.getText();System.out.println(text1);break;
            case "Sendkeys":alert.sendKeys(text);break;
            default:throw new RuntimeException("Methods are not available");
        }
    }
    public void Selectbytext(By locator,String text){
        WebElement ele=driver.findElement(locator);
        Select obj=new Select(ele);
        obj.selectByVisibleText("India");
    }
    public void Angulardropdown(By inputlocator,String text){
        Clickoptions(inputlocator);
        WebElement ele=driver.findElement(By.xpath("//div[@data-value='"+text+"']"));
        ele.click();
    }
    public void Switchtoframe(By locator){
        WebElement ele=driver.findElement(locator);
        driver.switchTo().frame(ele);
    }
    public void Usingactionclassesselectingitem(String menu,String submenu,String childmenu){
        WebElement mainmenu=driver.findElement(By.xpath("//a[@data-group='"+menu+"']"));
        Mousehoverhandling(mainmenu);
        WebElement submens=driver.findElement(By.xpath("//div[@data-group='"+menu+"']//a[text()='"+submenu+"']/../following-sibling::li/a[text()='"+childmenu+"']"));
        submens.click();
    }
    public void Mousehoverhandling(WebElement ele){
        Actions action=new Actions(driver);
        action.moveToElement(ele).build().perform();
    }
    public void Rightclick(WebElement ele){
        Actions action=new Actions(driver);
        action.contextClick(ele).build().perform();
    }
    public void Doubleclick(WebElement ele){
        Actions action=new Actions(driver);
        action.doubleClick(ele).build().perform();
    }
    public void Draganddropdown(WebElement source,WebElement target){
        Actions bulider=new Actions(driver);
        bulider.dragAndDrop(source,target).build().perform();
    }
}

