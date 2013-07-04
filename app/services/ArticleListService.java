package services;

import java.io.IOException;

import models.ArticleList;
import models.Categroies;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import play.Logger;

import utils.StringUtils;
import utils.YouDaoTranslate;

public class ArticleListService {

	public static void fetchArticleList() {

//		for (Categroies categroy : Categroies.getCategroiesChild()) {
//			parseArticleList(categroy.categroy_href);
//		}
		Categroies categroy = new Categroies();
		categroy.categroy_code = "09303509707349963930052561407759";
		categroy.categroy_name = "CentOS";
		categroy.categroy_href = "howtos/linux/centos";
		parseArticleList(categroy);
	}

	public static void parseArticleList(Categroies categroy) {
		
		try {
			Document doc = Jsoup.connect("http://www.howtoforge.com/" + categroy.categroy_href).get();
			saveArticleList(doc,categroy);
			parseArtilcePage(doc,categroy);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveArticleList(Document doc,Categroies categroy){
		ArticleList articleList = null;
		Elements content = doc.select("#content");
		for(Element node : content.select(".node")){
			articleList = new ArticleList();
			articleList.article_code = StringUtils.getMengCode();
			articleList.categroy_code = categroy.categroy_code;
			articleList.categroy_name = categroy.categroy_name;
			Element a = node.select("a").first();
			articleList.article_href = a.attr("href");
			articleList.article_title = a.text();
			articleList.article_title_cn = YouDaoTranslate.translateSentence(a.text());
			Element p = node.select(".content p").last();
			articleList.article_content = p.html();
			articleList.article_content_cn = YouDaoTranslate.translateSentence(p.html());
			ArticleList.save(articleList);
		}
	}
	
	public static void parseArtilcePage(Document doc,Categroies categroy){
		Elements content = doc.select("#content");
		Element pager = content.select("#pager").first();
		Element a = pager.select(".pager-last a").first();
		String href = a.attr("href");
		Logger.info(href);
		String[] links = href.split("=");
		int max_page = Integer.parseInt(links[1]);
		for(int i=10 ; i<=max_page; i= i+10){
			String link = links[0]+"="+ i;
			try {
				Document page = Jsoup.connect("http://www.howtoforge.com/" + link).get();
				saveArticleList(page, categroy);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		fetchArticleList();
	}

}
