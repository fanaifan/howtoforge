package controllers;

import models.ArticleList;
import models.Categroies;
import play.mvc.Controller;
import play.mvc.Result;
import services.ArticleListService;
import services.CategroyService;
import views.html.index;

public class Application extends Controller {
  
  public static Result index() {
	
	/**
	 * init fetch  
	 */
	//CategroyService.getCategroy();
	//ArticleListService.fetchArticleList();

	return ok(index.render(Categroies.getCategroiesParent(),
    					   Categroies.getCategroiesChild(),
    					   ArticleList.getArticlePage(0, 10,"CentOS"),
    					   0,
    					   ArticleList.getArticleTotal(10, "CentOS")));
  }
  
  public static Result page(int page, int size, String categroy_name, String categroy_parentc){
	  return ok(index.render(Categroies.getCategroiesParent(),
			   Categroies.getCategroiesChild(),
			   ArticleList.getArticlePage(page, size,categroy_name),
			   page,
			   ArticleList.getArticleTotal(10, "CentOS")));
  }
  
}