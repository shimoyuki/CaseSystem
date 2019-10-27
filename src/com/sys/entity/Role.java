package com.sys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Set<Menu> menu;
	private Set<Privilage> privilage;

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

	public Set<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}

	public Set<Privilage> getPrivilage() {
		return privilage;
	}

	public void setPrivilage(Set<Privilage> privilage) {
		this.privilage = privilage;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", menu=" + menu + ", privilage=" + privilage + "]";
	}
	
	
	
}
