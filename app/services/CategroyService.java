package services;

import java.io.IOException;

import models.Categroies;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import utils.StringUtils;

public class CategroyService {
	
	public static void getCategroy(){
		Categroies categroy = null;
		try {
			Document doc = Jsoup.connect("http://www.howtoforge.com").get();
			Elements menu = doc.select(".menu");
			for(Element howtoforge : menu.select("ul li .expanded")){
			    categroy = new Categroies();
				Element a = howtoforge.select("a").first();
				categroy.categroy_code = StringUtils.getMengCode();
				categroy.categroy_name = a.text();
				categroy.categroy_href = a.attr("href");
				categroy.categroy_parent = "parent";
				Categroies.save(categroy);
				Elements howtos = howtoforge.select("ul");
				for(Element howto : howtos.select("li")){
					categroy = new Categroies();
					Element la = howto.select("a").first();
					categroy.categroy_code = StringUtils.getMengCode();
					categroy.categroy_name = la.text();
					categroy.categroy_href = la.attr("href");
					categroy.categroy_parent = a.text();
					Categroies.save(categroy);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		getCategroy();
	}	

}
