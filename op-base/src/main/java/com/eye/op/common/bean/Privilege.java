package com.eye.op.common.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="privilege")
public class Privilege implements Serializable{
	
	private static final long serialVersionUID = -2247190533465421920L;
	
	private Integer id;
	private Integer menuid;
	private String menuname;
	private String icon;
	private String url;
//	private Privilege parent;
//	private List<Privilege> children;
	
	@Id
	@GeneratedValue 
	@Column
	public Integer getId() {
		return id;
	}
	
	@Column
	public Integer getMenuid() {
		return menuid;
	}
	@Column
	public String getMenuname() {
		return menuname;
	}
	@Column
	public String getIcon() {
		return icon;
	}
	@Column
	public String getUrl() {
		return url;
	}
//	@ManyToOne
//	@JoinColumn(name="parentid")
//	public Privilege getParent() {
//		return parent;
//	}
//	@OneToMany(mappedBy="parent")
//	@Fetch(FetchMode.SUBSELECT)  
//	public List<Privilege> getChildren() {
//		return children;
//	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setUrl(String url) {
		this.url = url;
	}
//	public void setParent(Privilege parent) {
//		this.parent = parent;
//	}
//	public void setChildren(List<Privilege> children) {
//		this.children = children;
//	}
	
}
