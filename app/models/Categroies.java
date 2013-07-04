package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name="categroies")
public class Categroies extends Model{
	
	private static final long serialVersionUID = 1L;
	@Id
	public long id;
	@Column
	public String categroy_code;
	@Column
	public String categroy_name;
	@Column
	public String categroy_href;
	@Column
	public String categroy_parent;
	
	public static Model.Finder<Long, Categroies> finder = new Model.Finder<Long, Categroies>(Long.class, Categroies.class);

	public static void save(Categroies categroy){
		categroy.save();
	}
	
	public static List<Categroies> getCategroiesParent(){
		return finder.where().eq("categroy_parent", "parent").findList();
	}
	
	public static List<Categroies> getCategroiesChild(){
		return finder.all();
	}
	
	
	
}
