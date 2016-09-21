package test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import utility.WriteToExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.TestHelper;
import utility.TestViews;

public class TestMenuNG {
	private static String url="http://yankees.io-media.com";
	private static WebDriver driver;
	private static WebDriverWait wait;
	static String driverPath = "C:/Users/amit/workspace-mars/IM/lib/";
	@Parameters({ "browser" })
	@BeforeMethod
	  public void beforeMethod(String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	      driver.navigate().to(url);
	      driver.manage().window().maximize();
          wait=new WebDriverWait(driver,30);
	      wait.until(ExpectedConditions.elementToBeClickable(TestHelper.ExitButton(driver)));
		  TestHelper.ExitButton(driver).click();
		  
	  }
	@Test(enabled=false,priority=1)
	public void TicketPrice() throws IOException{
		for(int i=0;i<=4;i++){
			wait.until(ExpectedConditions.elementToBeClickable(TestHelper.Search(driver)));
			int j=116+i;
			String str=Integer.toString(j);
			TestHelper.Search(driver).sendKeys(str);
			WebElement searchlist=TestHelper.SearchList(driver);
			List<WebElement> listitems=searchlist.findElements(By.tagName("a"));
			System.out.println("ticket price="+listitems.size());
			String section=listitems.get(0).getText();
			listitems.get(0).click();
			wait.until(ExpectedConditions.elementToBeClickable(TestHelper.PriceList(driver)));
			String section_price=TestHelper.SectionPrice(driver).getText();
			System.out.println(section_price);
			String[] sp={section,section_price};
			WriteToExcel.writeExcel("C://Users//amit//workspace-mars//IM//TestData","section-price.xlsx","Sheet1",sp);
			driver.navigate().refresh();
			driver.navigate().back();
		}
	}
	@Test(enabled=false,priority=2)
	public void MapSection() throws IOException{
		
		String[] benefits = null;
		TestHelper.Slider(driver).click();
		driver.navigate().refresh();
		TestHelper.Slider(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(TestHelper.TwentySeven(driver)));
		//TestHelper.TwentySeven(driver).click();
		for(int m=16;m<31;m=m+14){
		driver.findElement(By.xpath(".//*[@id='Map']/area['"+m+"']")).click();	
		TestHelper.Benefit(driver).click();
		WebElement benefit_list=TestHelper.BenefitList(driver);
		List<WebElement> benefit_list_items=benefit_list.findElements(By.tagName("li"));
		int l=1;
		for(int k=0;k<benefit_list_items.size();k=k+2){
			
			benefit_list_items.get(k).click();
		    WebElement paginator=driver.findElement(By.xpath(".//*[@id='Benifits_Pages_Left_All_"+l+"_Container']/p[2]/ul"));
		    List<WebElement> paginator_items=paginator.findElements(By.tagName("li"));
		for(int i=0;i<paginator_items.size();i++){
			paginator_items.get(i).click();
			WebElement page1=driver.findElement(By.id("Benifits_Pages_Left_All_"+l+"_page"+i));
			List<WebElement> page1_benefits=page1.findElements(By.tagName("li"));
			for(int j=0;i<page1_benefits.size();j++)
				benefits[j]=page1_benefits.get(j).getText();
			WriteToExcel.writeExcel("C://Users//amit//workspace-mars//IM//TestData","section-map.xlsx","Sheet1",benefits);
		}
		l++;
	  }
	}
}
	@Test(enabled=false,priority=3)
	public void PremiumView(){
		TestHelper.PremiumViews(driver).click();
		TestViews.GetViews(driver, wait);
	}
	@Test(enabled=false,priority=4)
	public void MvpSuite(){
		TestHelper.MvpViews(driver).click();
		TestViews.GetViews(driver, wait);
	}
    @Test(priority=0)
    public void TopMenuBar() throws IOException {
		
    	String menuitem=null;
		String item_font_size=null;
		String item_font_family=null;
		String item_font_color=null;
		WebElement topmenu=TestHelper.TopMenu(driver);
        List<WebElement> menuitems=topmenu.findElements(By.tagName("a"));
        System.out.println(menuitems.size());
        for(int i=0;i<menuitems.size();i++){
        	menuitem=menuitems.get(i).getText();
        	item_font_size=menuitems.get(i).getCssValue("font-size");
        	item_font_family=menuitems.get(i).getCssValue("font-family");
        	item_font_color=menuitems.get(i).getCssValue("color");
        	String[] topmenubar={menuitem,item_font_size,item_font_family,item_font_color};
        	System.out.println(topmenubar[0]+" "+topmenubar[1]+" "+topmenubar[2]+" "+topmenubar[3]);
        	WriteToExcel.writeExcel("C://Users//amit//workspace-mars//IM//TestData","menu-items-attributes.xlsx","Sheet1",topmenubar);
        	
        }
    }
    @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }
}
