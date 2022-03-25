package com.ruoyi.kooklen.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户搜索记录对象 user_search_record
 * 
 * @author kooklen
 * @date 2021-12-03
 */
public class UserSearchRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private String userid;

    /** 记录号 */
    @Excel(name = "记录号")
    private Long recordnumber;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 公司id */
    @Excel(name = "公司id")
    private Long companyid;

    /** 公司名 */
    @Excel(name = "公司名")
    private String companyname;

    /** 搜索时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "搜索时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date searchtime;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    public void setUserid(String userid) 
    {
        this.userid = userid;
    }

    public String getUserid() 
    {
        return userid;
    }
    public void setRecordnumber(Long recordnumber) 
    {
        this.recordnumber = recordnumber;
    }

    public Long getRecordnumber() 
    {
        return recordnumber;
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
    public void setSearchtime(Date searchtime) 
    {
        this.searchtime = searchtime;
    }

    public Date getSearchtime() 
    {
        return searchtime;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userid", getUserid())
            .append("recordnumber", getRecordnumber())
            .append("username", getUsername())
            .append("companyid", getCompanyid())
            .append("companyname", getCompanyname())
            .append("searchtime", getSearchtime())
            .append("state", getState())
            .toString();
    }
}
