package sampleTestCases;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class NavigateToUrl
{

	public static void main(String[] args) throws MalformedURLException, IOException
	{
		CharSequence[] charSequencesAsString = new String[] { "test" };
		boolean isLinkExists = true;
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new HtmlUnitDriver();
		driver.get(FinalVariables.baseUrl);
		List<WebElement> listOfmenu =  driver.findElements(By.xpath(".//*[@id='topnavMenu']/ul/li/a"));
		for (int i=0; i < listOfmenu.size(); i++)
		{
			HttpURLConnection.setFollowRedirects(false);
	        HttpURLConnection con = (HttpURLConnection) new URL(listOfmenu.get(i).getAttribute("href")).openConnection();
	        con.setRequestMethod("HEAD");
	        if (404 == con.getResponseCode())
	        {
	        	System.out.println(listOfmenu.get(i).getText()+ " page is showing 404");
	        	isLinkExists = false;
	        }
		}
		if (isLinkExists) {
	        System.out.println("No page is showing 404");
		}
	}
}
