package com.ruoyi.test.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * userMonitorCompany对象 user_monitor_company
 * 
 * @author kooklen
 * @date 2021-12-28
 */
public class userMonitorCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 公司id */
    @Excel(name = "公司id")
    private Long companyid;

    /** 记录号 */
    private Long recordnumber;

    /** 公司名 */
    @Excel(name = "公司名")
    private String companyname;

    /** 监控时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "监控时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date monitortime;

    /** 公司状态 */
    @Excel(name = "公司状态")
    private Long state;

    /** 是否正在监控 */
    @Excel(name = "是否正在监控")
    private Long ismonitor;

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
    public void setRecordnumber(Long recordnumber) 
    {
        this.recordnumber = recordnumber;
    }

    public Long getRecordnumber() 
    {
        return recordnumber;
    }
    public void setCompanyname(String companyname) 
    {
        this.companyname = companyname;
    }

    public String getCompanyname() 
    {
        return companyname;
    }
    public void setMonitortime(Date monitortime) 
    {
        this.monitortime = monitortime;
    }

    public Date getMonitortime() 
    {
        return monitortime;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setIsmonitor(Long ismonitor) 
    {
        this.ismonitor = ismonitor;
    }

    public Long getIsmonitor() 
    {
        return ismonitor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userid", getUserid())
            .append("username", getUsername())
            .append("companyid", getCompanyid())
            .append("recordnumber", getRecordnumber())
            .append("companyname", getCompanyname())
            .append("monitortime", getMonitortime())
            .append("state", getState())
            .append("ismonitor", getIsmonitor())
            .toString();
    }
}
