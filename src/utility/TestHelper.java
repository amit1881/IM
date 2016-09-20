package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestHelper {
	private static WebElement element;
    private static String topMenuBarId;
	private static String exitButtonXpath;
	private static String sliderId;
	private static String searchId;
	private static String loaderId;
	private static String searchListXpath;
	private static String priceListId;
	private static String sectionPriceXpath;
	private static String backButtonXpath;
	private static String twentySevenXpath;
	private static String benefitId;
	private static String benefitListId;
	private static String paginatorXpath;
	private static String closeButtonId;
	private static String premiumViewsId;
	private static String view1Id;
	private static String view2Id;
	private static String view3Id;
	private static String mvpViewsId;
	private static String clubPageId;
	private static String viewBackButtonId;
	private static String viewsBackButtonId;
	public static void getPageElements(){
		Properties prop = new Properties();
		InputStream input= null;

		try {

			input = new FileInputStream("C://Users//amit//workspace-mars//IM//src//properties//locator.properties");

			// load a properties file
			prop.load(input);
			topMenuBarId=prop.getProperty("top-menu-bar-id");
			exitButtonXpath=prop.getProperty("exit-button-xpath");
			sliderId=prop.getProperty("slider-id");
			searchId=prop.getProperty("search-id");
			loaderId=prop.getProperty("loader-id");
			searchListXpath=prop.getProperty("search-list-xpath");
			priceListId=prop.getProperty("price-list-id");
			sectionPriceXpath=prop.getProperty("section-price-xpath");
			backButtonXpath=prop.getProperty("back-button-xpath");
			twentySevenXpath=prop.getProperty("twenty-seven-xpath");
			benefitId=prop.getProperty("benefit-id");
			benefitListId=prop.getProperty("benefit-list-id");
			paginatorXpath=prop.getProperty("paginator-xpath");
			closeButtonId=prop.getProperty("close-button-id");
			premiumViewsId=prop.getProperty("premium-views-id");
			view1Id=prop.getProperty("view1-id");
			view2Id=prop.getProperty("view2-id");
			view3Id=prop.getProperty("view3-id");
			mvpViewsId=prop.getProperty("mvp-views-id");
			clubPageId=prop.getProperty("club-page-id");
			viewBackButtonId=prop.getProperty("view-back-button-id");
			viewsBackButtonId=prop.getProperty("views-back-button-id");
			} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	static {
	    getPageElements();
	  }


	   /*
	    * Top menu bar
	    */
	   
	  public static WebElement TopMenu(WebDriver driver){
	   
		   element=driver.findElement(By.id(topMenuBarId));
		   return element;
	   }
	  public static WebElement ExitButton(WebDriver driver){
		   element=driver.findElement(By.xpath(exitButtonXpath));
		   return element;
	  }
	  public static WebElement Slider(WebDriver driver){
		   element=driver.findElement(By.id(sliderId));
		   return element;
	  }
	  public static WebElement Search(WebDriver driver){
		   element=driver.findElement(By.id(searchId));
		   return element;
	  }
	  public static WebElement Loader(WebDriver driver){
		   element=driver.findElement(By.id(loaderId));
		   return element;
	  }
	  public static WebElement SearchList(WebDriver driver){
		   element=driver.findElement(By.xpath(searchListXpath));
		   return element;
	  }
	  public static WebElement PriceList(WebDriver driver){
		   element=driver.findElement(By.id(priceListId));
		   return element;
	  }
	  public static WebElement SectionPrice(WebDriver driver){
		   element=driver.findElement(By.xpath(sectionPriceXpath));
		   return element;
	  }
	  public static WebElement BackButton(WebDriver driver){
		   element=driver.findElement(By.xpath(backButtonXpath));
		   return element;
	  }
	  public static WebElement TwentySeven(WebDriver driver){
		   element=driver.findElement(By.xpath(twentySevenXpath));
		   return element;
	  }
	  public static WebElement Benefit(WebDriver driver){
		   element=driver.findElement(By.id(benefitId));
		   return element;
	  }
	  public static WebElement BenefitList(WebDriver driver){
		   element=driver.findElement(By.id(benefitListId));
		   return element;
	  }
	  public static WebElement Paginator(WebDriver driver){
		   element=driver.findElement(By.xpath(paginatorXpath));
		   return element;
	  }
	  public static WebElement CloseButton(WebDriver driver){
		   element=driver.findElement(By.id(closeButtonId));
		   return element;
	  }
	  public static WebElement PremiumViews(WebDriver driver){
		   element=driver.findElement(By.id(premiumViewsId));
		   return element;
	  }
	  public static WebElement View1(WebDriver driver){
		   element=driver.findElement(By.id(view1Id));
		   return element;
	  }
	  public static WebElement View2(WebDriver driver){
		   element=driver.findElement(By.id(view2Id));
		   return element;
	  }
	  public static WebElement View3(WebDriver driver){
		   element=driver.findElement(By.id(view3Id));
		   return element;
	  }
	  public static WebElement MvpViews(WebDriver driver){
		   element=driver.findElement(By.id(mvpViewsId));
		   return element;
	  }
	  public static WebElement ClubPage(WebDriver driver){
		   element=driver.findElement(By.id(clubPageId));
		   return element;
	  }
	  public static WebElement ViewBackButton(WebDriver driver){
		   element=driver.findElement(By.id(viewBackButtonId));
		   return element;
	  }
	  public static WebElement ViewsBackButton(WebDriver driver){
		   element=driver.findElement(By.id(viewsBackButtonId));
		   return element;
	  }
}
