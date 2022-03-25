package com.ruoyi.test.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * userTriggerRecord对象 trigger_record
 * 
 * @author kooklen
 * @date 2021-12-03
 */
public class TriggerRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录号 */
    @Excel(name = "记录号")
    private Long recordnumber;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 公司id */
    @Excel(name = "公司id")
    private Long companyid;

    /** 公司名 */
    @Excel(name = "公司名")
    private String companyname;

    /** 推送方式 */
    @Excel(name = "推送方式")
    private String pushway;

    /** 触发时间 */
    @JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
    @Excel(name = "触发时间", width = 30, dateFormat = "yyyy-MM-dd-hh-mm-ss")
    private Date triggertime;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    public void setRecordnumber(Long recordnumber) 
    {
        this.recordnumber = recordnumber;
    }

    public Long getRecordnumber() 
    {
        return recordnumber;
    }
    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setCompanyid(Long companyid) 
    {
        this.companyid = companyid;
    }

    public Long getCompanyid() 
    {
        return companyid;
    }
    public void setCompanyname(String companyname) 
    {
        this.companyname = companyname;
    }

    public String getCompanyname() 
    {
        return companyname;
    }
    public void setPushway(String pushway) 
    {
        this.pushway = pushway;
    }

    public String getPushway() 
    {
        return pushway;
    }
    public void setTriggertime(Date triggertime) 
    {
        this.triggertime = triggertime;
    }

    public Date getTriggertime() 
    {
        return triggertime;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordnumber", getRecordnumber())
            .append("userid", getUserid())
            .append("username", getUsername())
            .append("companyid", getCompanyid())
            .append("companyname", getCompanyname())
            .append("pushway", getPushway())
            .append("triggertime", getTriggertime())
            .append("address", getAddress())
            .toString();
    }
}
