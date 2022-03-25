package com.ruoyi.kooklen.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * UserSerarchRecorddd对象 user_serarch_recorddd
 * 
 * @author kooklen
 * @date 2021-12-03
 */
public class UserSerarchRecorddd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private String userid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date starttime;

    /** 搜索功能 */
    @Excel(name = "搜索功能")
    private Long searchfunction;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endtime;

    /** 监控功能 */
    @Excel(name = "监控功能")
    private Long monitorf;

    /** $column.columnComment */
    private Long id;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

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
    public void setStarttime(Date starttime) 
    {
        this.starttime = starttime;
    }

    public Date getStarttime() 
    {
        return starttime;
    }
    public void setSearchfunction(Long searchfunction) 
    {
        this.searchfunction = searchfunction;
    }

    public Long getSearchfunction() 
    {
        return searchfunction;
    }
    public void setEndtime(Date endtime) 
    {
        this.endtime = endtime;
    }

    public Date getEndtime() 
    {
        return endtime;
    }
    public void setMonitorf(Long monitorf) 
    {
        this.monitorf = monitorf;
    }

    public Long getMonitorf() 
    {
        return monitorf;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userid", getUserid())
            .append("username", getUsername())
            .append("starttime", getStarttime())
            .append("searchfunction", getSearchfunction())
            .append("endtime", getEndtime())
            .append("monitorf", getMonitorf())
            .append("id", getId())
            .append("password", getPassword())
            .toString();
    }
}
