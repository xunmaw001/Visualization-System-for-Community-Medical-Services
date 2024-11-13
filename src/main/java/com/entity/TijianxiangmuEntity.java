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
 * 体检项目
 *
 * @author 
 * @email
 */
@TableName("tijianxiangmu")
public class TijianxiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TijianxiangmuEntity() {

	}

	public TijianxiangmuEntity(T t) {
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
     * 项目编号
     */
    @ColumnInfo(comment="项目编号",type="varchar(200)")
    @TableField(value = "tijianxiangmu_uuid_number")

    private String tijianxiangmuUuidNumber;


    /**
     * 项目名称
     */
    @ColumnInfo(comment="项目名称",type="varchar(200)")
    @TableField(value = "tijianxiangmu_name")

    private String tijianxiangmuName;


    /**
     * 项目类型
     */
    @ColumnInfo(comment="项目类型",type="int(11)")
    @TableField(value = "tijianxiangmu_types")

    private Integer tijianxiangmuTypes;


    /**
     * 体检费用
     */
    @ColumnInfo(comment="体检费用",type="decimal(10,2)")
    @TableField(value = "tijianxiangmu_jingfei")

    private Double tijianxiangmuJingfei;


    /**
     * 体检详情
     */
    @ColumnInfo(comment="体检详情",type="longtext")
    @TableField(value = "tijianxiangmu_content")

    private String tijianxiangmuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "tijianxiangmu_delete")

    private Integer tijianxiangmuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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

    @Override
    public String toString() {
        return "Tijianxiangmu{" +
            ", id=" + id +
            ", tijianxiangmuUuidNumber=" + tijianxiangmuUuidNumber +
            ", tijianxiangmuName=" + tijianxiangmuName +
            ", tijianxiangmuTypes=" + tijianxiangmuTypes +
            ", tijianxiangmuJingfei=" + tijianxiangmuJingfei +
            ", tijianxiangmuContent=" + tijianxiangmuContent +
            ", tijianxiangmuDelete=" + tijianxiangmuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
