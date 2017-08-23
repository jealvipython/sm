package com.family.sweety.modules.programmer_url.entity;

import java.io.Serializable;
import java.util.Date;

public class SummerizeCategoryEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer summarizeId;
	private String summarizeName;
	public Integer getSummarizeId() {
		return summarizeId;
	}
	public void setSummarizeId(Integer summarizeId) {
		this.summarizeId = summarizeId;
	}
	public String getSummarizeName() {
		return summarizeName;
	}
	public void setSummarizeName(String summarizeName) {
		this.summarizeName = summarizeName;
	}
	private Date createDate;
	private String deleteFlag;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
