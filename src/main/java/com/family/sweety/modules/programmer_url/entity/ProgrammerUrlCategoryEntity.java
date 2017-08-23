package com.family.sweety.modules.programmer_url.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProgrammerUrlCategoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer categoryId;//二级分类id
	private String categoryName;//二级分类名称
	private Integer categoryCount;//二级分类数目
	private Integer summerizeId;//关联一级分类id
	public Integer getSummerizeId() {
		return summerizeId;
	}
	public void setSummerizeId(Integer summerizeId) {
		this.summerizeId = summerizeId;
	}
	public Integer getCategoryCount() {
		return categoryCount;
	}
	public void setCategoryCount(Integer categoryCount) {
		this.categoryCount = categoryCount;
	}
	private Date createDate;
	private Integer deleteFlag;
	public List<ProgrammerUrlEntity> getIncludeUrl() {
		return includeUrl;
	}
	public void setIncludeUrl(List<ProgrammerUrlEntity> includeUrl) {
		this.includeUrl = includeUrl;
	}
	private List<ProgrammerUrlEntity> includeUrl;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
