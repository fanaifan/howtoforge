package services;

import java.io.IOException;
import java.util.List;

import models.ArticleList;
import models.Articles;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import play.Logger;

public class ArticlesService {
	
	
	public static void getArticleContent(){
		
		try {
			int total = ArticleList.getArticleTotal100();
			for(int i=0; i<=total; i++ ){
				List<ArticleList> alists = ArticleList.getArticles_100(i);
				for(ArticleList alist : alists){
					Document doc = Jsoup.connect("http://www.howtoforge.com/"+alist.article_href).get();
					saveArticle(doc,alist);
				}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveArticle(Document doc, ArticleList alist){
		Articles articles = new Articles();
		Elements content = doc.select("#content");
		Elements h2 = content.select(".content h2");
		articles.article_title = h2.text();
		Elements pcontent = content.select(".node .content ");
		Elements p = pcontent.after("h2");
		Logger.info(pcontent.html());
		
	}
	
	public static void main(String[] args) throws IOException{
		ArticleList alist = new ArticleList();
		alist.article_href = "installing-the-galera-iworx-cluster";
		alist.categroy_code="09303509707349963930052561407759";
		alist.categroy_name="CentOS";
		Document doc = Jsoup.connect("http://www.howtoforge.com/"+alist.article_href).get();
		saveArticle(doc,alist);

	}

}
