package models;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="article_list")
public class ArticleList extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id
	public long id;
	@Column
	public String article_title;
	@Column
	public String article_title_cn;
	@Column
	public String article_code;
	@Column
	public String article_href;
	@Lob
	@Basic(fetch=FetchType.EAGER)
	public String article_content;
	@Lob
	@Basic(fetch=FetchType.EAGER)
	public String article_content_cn;
	@Column
	public String categroy_name;
	@Column
	public String categroy_code;
	
	public static Model.Finder<Long, ArticleList> find = new Model.Finder<Long, ArticleList>(Long.class, ArticleList.class);
	
	public static void save(ArticleList articleList){
		articleList.save();
	}
	
	public static List<ArticleList> getArticlePage(int page, int size, String categroy_name){
		return find.where().eq("categroy_name", categroy_name).findPagingList(size).getPage(page).getList();
	}
	
	public static int getArticleTotal(int size, String category_name){
		return find.where().eq("categroy_name", category_name).findPagingList(size).getTotalPageCount();
	}
	
	public static List<ArticleList> getArticles_100(int p){
		return find.findPagingList(100).getPage(p).getList();
	}
	
	public static int getArticleTotal100(){
		return find.findPagingList(100).getTotalPageCount();
	}
	

}
