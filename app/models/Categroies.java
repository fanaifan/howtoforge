package models;

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
	public String categroy_parent;
	
	public Model.Finder<Long, Categroies> find = new Model.Finder<Long, Categroies>(Long.class, Categroies.class);

	public void save(Categroies category){
		category.save();
	}
	
	
	
}
