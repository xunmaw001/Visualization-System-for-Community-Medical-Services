package com.entity.vo;

import com.entity.TijianxiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 体检项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tijianxiangmu")
public class TijianxiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 项目编号
     */

    @TableField(value = "tijianxiangmu_uuid_number")
    private String tijianxiangmuUuidNumber;


    /**
     * 项目名称
     */

    @TableField(value = "tijianxiangmu_name")
    private String tijianxiangmuName;


    /**
     * 项目类型
     */

    @TableField(value = "tijianxiangmu_types")
    private Integer tijianxiangmuTypes;


    /**
     * 体检费用
     */

    @TableField(value = "tijianxiangmu_jingfei")
    private Double tijianxiangmuJingfei;


    /**
     * 体检详情
     */

    @TableField(value = "tijianxiangmu_content")
    private String tijianxiangmuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "tijianxiangmu_delete")
    private Integer tijianxiangmuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：项目编号
	 */
    public String getTijianxiangmuUuidNumber() {
        return tijianxiangmuUuidNumber;
    }


    /**
	 * 获取：项目编号
	 */

    public void setTijianxiangmuUuidNumber(String tijianxiangmuUuidNumber) {
        this.tijianxiangmuUuidNumber = tijianxiangmuUuidNumber;
    }
    /**
	 * 设置：项目名称
	 */
    public String getTijianxiangmuName() {
        return tijianxiangmuName;
    }


    /**
	 * 获取：项目名称
	 */

    public void setTijianxiangmuName(String tijianxiangmuName) {
        this.tijianxiangmuName = tijianxiangmuName;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getTijianxiangmuTypes() {
        return tijianxiangmuTypes;
    }


    /**
	 * 获取：项目类型
	 */

    public void setTijianxiangmuTypes(Integer tijianxiangmuTypes) {
        this.tijianxiangmuTypes = tijianxiangmuTypes;
    }
    /**
	 * 设置：体检费用
	 */
    public Double getTijianxiangmuJingfei() {
        return tijianxiangmuJingfei;
    }


    /**
	 * 获取：体检费用
	 */

    public void setTijianxiangmuJingfei(Double tijianxiangmuJingfei) {
        this.tijianxiangmuJingfei = tijianxiangmuJingfei;
    }
    /**
	 * 设置：体检详情
	 */
    public String getTijianxiangmuContent() {
        return tijianxiangmuContent;
    }


    /**
	 * 获取：体检详情
	 */

    public void setTijianxiangmuContent(String tijianxiangmuContent) {
        this.tijianxiangmuContent = tijianxiangmuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getTijianxiangmuDelete() {
        return tijianxiangmuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setTijianxiangmuDelete(Integer tijianxiangmuDelete) {
        this.tijianxiangmuDelete = tijianxiangmuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
