package com.entity.model;

import com.entity.TijianxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 体检项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TijianxiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目编号
     */
    private String tijianxiangmuUuidNumber;


    /**
     * 项目名称
     */
    private String tijianxiangmuName;


    /**
     * 项目类型
     */
    private Integer tijianxiangmuTypes;


    /**
     * 体检费用
     */
    private Double tijianxiangmuJingfei;


    /**
     * 体检详情
     */
    private String tijianxiangmuContent;


    /**
     * 逻辑删除
     */
    private Integer tijianxiangmuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：项目编号
	 */
    public String getTijianxiangmuUuidNumber() {
        return tijianxiangmuUuidNumber;
    }


    /**
	 * 设置：项目编号
	 */
    public void setTijianxiangmuUuidNumber(String tijianxiangmuUuidNumber) {
        this.tijianxiangmuUuidNumber = tijianxiangmuUuidNumber;
    }
    /**
	 * 获取：项目名称
	 */
    public String getTijianxiangmuName() {
        return tijianxiangmuName;
    }


    /**
	 * 设置：项目名称
	 */
    public void setTijianxiangmuName(String tijianxiangmuName) {
        this.tijianxiangmuName = tijianxiangmuName;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getTijianxiangmuTypes() {
        return tijianxiangmuTypes;
    }


    /**
	 * 设置：项目类型
	 */
    public void setTijianxiangmuTypes(Integer tijianxiangmuTypes) {
        this.tijianxiangmuTypes = tijianxiangmuTypes;
    }
    /**
	 * 获取：体检费用
	 */
    public Double getTijianxiangmuJingfei() {
        return tijianxiangmuJingfei;
    }


    /**
	 * 设置：体检费用
	 */
    public void setTijianxiangmuJingfei(Double tijianxiangmuJingfei) {
        this.tijianxiangmuJingfei = tijianxiangmuJingfei;
    }
    /**
	 * 获取：体检详情
	 */
    public String getTijianxiangmuContent() {
        return tijianxiangmuContent;
    }


    /**
	 * 设置：体检详情
	 */
    public void setTijianxiangmuContent(String tijianxiangmuContent) {
        this.tijianxiangmuContent = tijianxiangmuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getTijianxiangmuDelete() {
        return tijianxiangmuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setTijianxiangmuDelete(Integer tijianxiangmuDelete) {
        this.tijianxiangmuDelete = tijianxiangmuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
