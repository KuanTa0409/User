package com.example.demo.entity;

public class EducationData {
	private String id;   //傳至後端資料庫的
	private String name; //下拉選單，給使用者看的
	
	public EducationData() {}

	public EducationData(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EducationData [id=" + id + ", name=" + name + "]";
	}		
}