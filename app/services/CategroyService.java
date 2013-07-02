package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import play.Logger;

public class CategroyService {
	
	public static void getCategroy(){
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> list = new ArrayList<String>();
		try {
			Document doc = Jsoup.connect("http://www.howtoforge.com").get();
			Elements menu = doc.select(".menu");
			Logger.info(menu.html());
			Elements howtoforge = menu.select("li .expanded");
			Logger.info(howtoforge.html());
			String expanded = howtoforge.select("li .expanded a").text();
			Logger.info(expanded);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		getCategroy();
	}

}
