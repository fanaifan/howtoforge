package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="articles")
public class Articles extends Model{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	public long id;
	@Column
	public String article_code;
	@Column
	public String article_href;
	@Column
	public String article_title;
	@Column
	public String categroy_name;
	@Column
	public String categroy_code;
	@Lob  
    @Basic(fetch=FetchType.EAGER)  
	public String article_content;
	@Lob  
    @Basic(fetch=FetchType.EAGER)  
	public String article_content_cn;
	
	public static Model.Finder<Long, Articles> find = new Model.Finder<Long, Articles>(Long.class, Articles.class);
	
	public static void save(Articles article){
		article.save();
	}
	
	public static Articles getArticlesByhref(String href){
		return find.where().eq("article_href", href).findUnique();
	}
	
}
