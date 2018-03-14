package com.neo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Periodical {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
	
	/**
	 * 稿件类型:科技,文史
	 */
    private String periodicalType;
    
    /**
     * 关联fileId
     */
    private long attachmentId;
    
    /**
     * 是否审批通过:true,false
     */
    private String isApproved;
    
    /**
     * 发布人
     */
    private long publishUserId;
    
    /**
     * 发布人名称
     */
    private String publishUserName;
    
    /**
     * 批准人ID
     */
    private long approvedUserId;
    
    /**
     * 批准人姓名
     */
    private String approvedUserName;
    
    private String attribute1;
    
    private String attribute2;
    
    private String attribute3;
    
    private String attribute4;
    
    private String attribute5;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getPeriodicalType() {
		return periodicalType;
	}


	public void setPeriodicalType(String periodicalType) {
		this.periodicalType = periodicalType;
	}


	public long getAttachmentId() {
		return attachmentId;
	}


	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}


	public String getIsApproved() {
		return isApproved;
	}


	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}


	public long getPublishUserId() {
		return publishUserId;
	}


	public void setPublishUserId(long publishUserId) {
		this.publishUserId = publishUserId;
	}


	public String getPublishUserName() {
		return publishUserName;
	}


	public void setPublishUserName(String publishUserName) {
		this.publishUserName = publishUserName;
	}


	public long getApprovedUserId() {
		return approvedUserId;
	}


	public void setApprovedUserId(long approvedUserId) {
		this.approvedUserId = approvedUserId;
	}


	public String getApprovedUserName() {
		return approvedUserName;
	}


	public void setApprovedUserName(String approvedUserName) {
		this.approvedUserName = approvedUserName;
	}


	public String getAttribute1() {
		return attribute1;
	}


	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}


	public String getAttribute2() {
		return attribute2;
	}


	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}


	public String getAttribute3() {
		return attribute3;
	}


	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}


	public String getAttribute4() {
		return attribute4;
	}


	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}


	public String getAttribute5() {
		return attribute5;
	}


	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}


	public Periodical() {
		super();
	}
}
