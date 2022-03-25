package com.ruoyi.kooklen.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * WorkOrderManagement对象 work_order_management
 * 
 * @author kooklen
 * @date 2021-12-02
 */
public class WorkOrderManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 系统号 */
    private Long id;

    public WorkOrderManagement() {
    }

    public WorkOrderManagement(Long id) {
        this.id = id;
    }

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 公司名 */
    @Excel(name = "公司名")
    private String companyname;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;



    /** 法人名 */
    @Excel(name = "法人名")
    private String legalpeople;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private Long code;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactphone;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 工单号 */
    @Excel(name = "工单号")
    private Long orderid;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd-hh-mm-ss")
    private Date finaltime;

    public WorkOrderManagement(Date createtime) {
        this.createtime = createtime;
    }

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd-hh-mm-ss")
    private Date createtime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setCompanyname(String companyname) 
    {
        this.companyname = companyname;
    }

    public String getCompanyname() 
    {
        return companyname;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setLegalpeople(String legalpeople) 
    {
        this.legalpeople = legalpeople;
    }

    public String getLegalpeople() 
    {
        return legalpeople;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCode(Long code) 
    {
        this.code = code;
    }

    public Long getCode() 
    {
        return code;
    }
    public void setContactphone(String contactphone) 
    {
        this.contactphone = contactphone;
    }

    public String getContactphone() 
    {
        return contactphone;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setOrderid(Long orderid) 
    {
        this.orderid = orderid;
    }

    public Long getOrderid() 
    {
        return orderid;
    }
    public void setFinaltime(Date finaltime) 
    {
        this.finaltime = finaltime;
    }

    public Date getFinaltime() 
    {
        return finaltime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userid", getUserid())
            .append("username", getUsername())
            .append("companyname", getCompanyname())
            .append("createtime", getCreatetime())
            .append("state", getState())
            .append("legalpeople", getLegalpeople())
            .append("province", getProvince())
            .append("city", getCity())
            .append("code", getCode())
            .append("contactphone", getContactphone())
            .append("note", getNote())
            .append("orderid", getOrderid())
            .append("finaltime", getFinaltime())
            .toString();
    }
}
