package com.entity.model;

import com.entity.TijianxiangmuYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 体检项目预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TijianxiangmuYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 体检项目
     */
    private Integer tijianxiangmuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date tijianxiangmuYuyueTime;


    /**
     * 预约备注
     */
    private String tijianxiangmuYuyueText;


    /**
     * 审核状态
     */
    private Integer tijianxiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String tijianxiangmuYuyueYesnoText;


    /**
     * 预约状态
     */
    private Integer tijianxiangmuYuyueTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：体检项目
	 */
    public Integer getTijianxiangmuId() {
        return tijianxiangmuId;
    }


    /**
	 * 设置：体检项目
	 */
    public void setTijianxiangmuId(Integer tijianxiangmuId) {
        this.tijianxiangmuId = tijianxiangmuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约日期
	 */
    public Date getTijianxiangmuYuyueTime() {
        return tijianxiangmuYuyueTime;
    }


    /**
	 * 设置：预约日期
	 */
    public void setTijianxiangmuYuyueTime(Date tijianxiangmuYuyueTime) {
        this.tijianxiangmuYuyueTime = tijianxiangmuYuyueTime;
    }
    /**
	 * 获取：预约备注
	 */
    public String getTijianxiangmuYuyueText() {
        return tijianxiangmuYuyueText;
    }


    /**
	 * 设置：预约备注
	 */
    public void setTijianxiangmuYuyueText(String tijianxiangmuYuyueText) {
        this.tijianxiangmuYuyueText = tijianxiangmuYuyueText;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getTijianxiangmuYuyueYesnoTypes() {
        return tijianxiangmuYuyueYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setTijianxiangmuYuyueYesnoTypes(Integer tijianxiangmuYuyueYesnoTypes) {
        this.tijianxiangmuYuyueYesnoTypes = tijianxiangmuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getTijianxiangmuYuyueYesnoText() {
        return tijianxiangmuYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setTijianxiangmuYuyueYesnoText(String tijianxiangmuYuyueYesnoText) {
        this.tijianxiangmuYuyueYesnoText = tijianxiangmuYuyueYesnoText;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getTijianxiangmuYuyueTypes() {
        return tijianxiangmuYuyueTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setTijianxiangmuYuyueTypes(Integer tijianxiangmuYuyueTypes) {
        this.tijianxiangmuYuyueTypes = tijianxiangmuYuyueTypes;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
