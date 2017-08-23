package com.family.sweety.modules.programmer_url.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class ProgrammerUrlEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String urlName;
	private  String urlHref;
	public ProgrammerUrlCategoryEntity getCategoryEntity() {
		return categoryEntity;
	}
	public void setCategoryEntity(ProgrammerUrlCategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	private ProgrammerUrlCategoryEntity categoryEntity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	
	
	public String getUrlHref() {
		return urlHref;
	}
	public void setUrlHref(String urlHref) {
		this.urlHref = urlHref;
	}
	

}
