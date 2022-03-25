package com.ruoyi.kooklen.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * userAccountManagement对象 user_account_management
 * 
 * @author kooklen
 * @date 2021-12-01
 */
public class userAccountManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private String userid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 地区 */
    @Excel(name = "地区")
    private String region;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date starttime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endtime;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 搜索功能 */
    @Excel(name = "搜索功能")
    private Long searchfunction;

    /** 监控功能 */
    @Excel(name = "监控功能")
    private Long monitorfunction;

    /** 生成号 */
    @Excel(name = "生成号")
    private Long generateid;

    public void setUserid(String userid) 
    {
        this.userid = userid;
    }

    public String getUserid() 
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
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setStarttime(Date starttime) 
    {
        this.starttime = starttime;
    }

    public Date getStarttime() 
    {
        return starttime;
    }
    public void setEndtime(Date endtime) 
    {
        this.endtime = endtime;
    }

    public Date getEndtime() 
    {
        return endtime;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setSearchfunction(Long searchfunction) 
    {
        this.searchfunction = searchfunction;
    }

    public Long getSearchfunction() 
    {
        return searchfunction;
    }
    public void setMonitorfunction(Long monitorfunction) 
    {
        this.monitorfunction = monitorfunction;
    }

    public Long getMonitorfunction() 
    {
        return monitorfunction;
    }
    public void setGenerateid(Long generateid) 
    {
        this.generateid = generateid;
    }

    public Long getGenerateid() 
    {
        return generateid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userid", getUserid())
            .append("username", getUsername())
            .append("region", getRegion())
            .append("starttime", getStarttime())
            .append("endtime", getEndtime())
            .append("password", getPassword())
            .append("searchfunction", getSearchfunction())
            .append("monitorfunction", getMonitorfunction())
            .append("generateid", getGenerateid())
            .toString();
    }
}
