package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 体检项目预约
 *
 * @author 
 * @email
 */
@TableName("tijianxiangmu_yuyue")
public class TijianxiangmuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TijianxiangmuYuyueEntity() {

	}

	public TijianxiangmuYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 体检项目
     */
    @ColumnInfo(comment="体检项目",type="int(11)")
    @TableField(value = "tijianxiangmu_id")

    private Integer tijianxiangmuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约日期",type="timestamp")
    @TableField(value = "tijianxiangmu_yuyue_time")

    private Date tijianxiangmuYuyueTime;


    /**
     * 预约备注
     */
    @ColumnInfo(comment="预约备注",type="longtext")
    @TableField(value = "tijianxiangmu_yuyue_text")

    private String tijianxiangmuYuyueText;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "tijianxiangmu_yuyue_yesno_types")

    private Integer tijianxiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "tijianxiangmu_yuyue_yesno_text")

    private String tijianxiangmuYuyueYesnoText;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "tijianxiangmu_yuyue_types")

    private Integer tijianxiangmuYuyueTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TijianxiangmuYuyue{" +
            ", id=" + id +
            ", tijianxiangmuId=" + tijianxiangmuId +
            ", yonghuId=" + yonghuId +
            ", tijianxiangmuYuyueTime=" + DateUtil.convertString(tijianxiangmuYuyueTime,"yyyy-MM-dd") +
            ", tijianxiangmuYuyueText=" + tijianxiangmuYuyueText +
            ", tijianxiangmuYuyueYesnoTypes=" + tijianxiangmuYuyueYesnoTypes +
            ", tijianxiangmuYuyueYesnoText=" + tijianxiangmuYuyueYesnoText +
            ", tijianxiangmuYuyueTypes=" + tijianxiangmuYuyueTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
