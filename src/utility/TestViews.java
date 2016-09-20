package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestViews {
	
	public static void GetViews(WebDriver driver,WebDriverWait wait){
		WebElement club_page=TestHelper.ClubPage(driver);
		List<WebElement> club_page_items=club_page.findElements(By.linkText("View 1"));
		System.out.println(club_page_items.size());
		for(int i=0;i<club_page_items.size();i++){
			club_page_items.get(i).click();
			wait.until(ExpectedConditions.elementToBeClickable(TestHelper.ViewBackButton(driver)));
			TestHelper.ViewBackButton(driver).click();
		}
		TestHelper.ViewsBackButton(driver).click();
	}

}
