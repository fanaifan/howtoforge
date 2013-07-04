package controllers;

import java.util.List;

import models.ArticleList;
import models.Categroies;
import play.mvc.Controller;
import play.mvc.Result;
import services.ArticleListService;
import services.CategroyService;
import views.html.index;

public class Application extends Controller {
  
  public static Result index() {
	  CategroyService.getCategroy();
	  ArticleListService.fetchArticleList();
	  
	  //Category
	  List<Categroies> categroies_parent = Categroies.getCategroiesParent();
	  List<Categroies> categroies_child = Categroies.getCategroiesChild();
	  //Article
	  List<ArticleList> article_list = ArticleList.getArticlePage(0, 10,"CentOS");
	  
    return ok(index.render(categroies_parent,categroies_child,article_list));
  }
  
//  public static Result page(int page, int size, String categroy_name){
//	  List<ArticleList> article_list = ArticleList.getArticlePage(page,size,categroy_name);
//	  return ok();
//  }
  
}