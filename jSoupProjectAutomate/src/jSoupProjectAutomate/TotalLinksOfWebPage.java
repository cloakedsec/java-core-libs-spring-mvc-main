package jSoupProjectAutomate;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TotalLinksOfWebPage {

	public static void main(String [] args) throws IOException {
		
		Document doc = Jsoup.connect("https://facebook.com/").get();  
		Elements links = doc.select("a[href]");  
		for (Element link : links) {  
		    System.out.println("\nlink : " + link.attr("href"));  
		    System.out.println("text : " + link.text());  

	}
	}}