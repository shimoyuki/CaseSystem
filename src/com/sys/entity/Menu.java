package com.sys.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Menu  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String iconcls;
	private String url;
	private int pid;
	private Set<Menu> children;
    private Menu parent;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIconcls() {
		return iconcls;
	}
	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public Set<Menu> getChildren() {
		return children;
	}
	public void setChildren(Set<Menu> children) {
		this.children = children;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", iconcls=" + iconcls + ", url=" + url + ", pid=" + pid
				+ ", children=" + children + ", parent=" + parent + "]";
	}

	

}
