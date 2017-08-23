package com.family.sweety.common.utils.Log;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by joseph on 2017/8/23.
 */
public class LogEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    private String userId;

    private String userIpAddress;
    private String userHostName;

    private Date createDateTime;
private String relatedTableName;
    private String isFlag; //1删 0:未删
    private String opType; //3:增 4:修 5:删

    public String getRelatedTableName() {
        return relatedTableName;
    }

    public void setRelatedTableName(String relatedTableName) {
        this.relatedTableName = relatedTableName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserIpAddress() {
        return userIpAddress;
    }

    public void setUserIpAddress(String userIpAddress) {
        this.userIpAddress = userIpAddress;
    }

    public String getUserHostName() {
        return userHostName;
    }

    public void setUserHostName(String userHostName) {
        this.userHostName = userHostName;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }
}
