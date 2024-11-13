package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TijianxiangmuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 体检项目预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tijianxiangmu_yuyue")
public class TijianxiangmuYuyueView extends TijianxiangmuYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String tijianxiangmuYuyueYesnoValue;
	/**
	* 预约状态的值
	*/
	@ColumnInfo(comment="预约状态的字典表值",type="varchar(200)")
	private String tijianxiangmuYuyueValue;

	//级联表 体检项目
		/**
		* 项目编号
		*/

		@ColumnInfo(comment="项目编号",type="varchar(200)")
		private String tijianxiangmuUuidNumber;
		/**
		* 项目名称
		*/

		@ColumnInfo(comment="项目名称",type="varchar(200)")
		private String tijianxiangmuName;
		/**
		* 项目类型
		*/
		@ColumnInfo(comment="项目类型",type="int(11)")
		private Integer tijianxiangmuTypes;
			/**
			* 项目类型的值
			*/
			@ColumnInfo(comment="项目类型的字典表值",type="varchar(200)")
			private String tijianxiangmuValue;
		/**
		* 体检费用
		*/
		@ColumnInfo(comment="体检费用",type="decimal(10,2)")
		private Double tijianxiangmuJingfei;
		/**
		* 体检详情
		*/

		@ColumnInfo(comment="体检详情",type="longtext")
		private String tijianxiangmuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer tijianxiangmuDelete;
	//级联表 用户
		/**
		* 学号
		*/

		@ColumnInfo(comment="学号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 住址
		*/

		@ColumnInfo(comment="住址",type="varchar(200)")
		private String yonghuAddress;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public TijianxiangmuYuyueView() {

	}

	public TijianxiangmuYuyueView(TijianxiangmuYuyueEntity tijianxiangmuYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, tijianxiangmuYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getTijianxiangmuYuyueYesnoValue() {
		return tijianxiangmuYuyueYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setTijianxiangmuYuyueYesnoValue(String tijianxiangmuYuyueYesnoValue) {
		this.tijianxiangmuYuyueYesnoValue = tijianxiangmuYuyueYesnoValue;
	}
	//当前表的
	/**
	* 获取： 预约状态的值
	*/
	public String getTijianxiangmuYuyueValue() {
		return tijianxiangmuYuyueValue;
	}
	/**
	* 设置： 预约状态的值
	*/
	public void setTijianxiangmuYuyueValue(String tijianxiangmuYuyueValue) {
		this.tijianxiangmuYuyueValue = tijianxiangmuYuyueValue;
	}


	//级联表的get和set 体检项目

		/**
		* 获取： 项目编号
		*/
		public String getTijianxiangmuUuidNumber() {
			return tijianxiangmuUuidNumber;
		}
		/**
		* 设置： 项目编号
		*/
		public void setTijianxiangmuUuidNumber(String tijianxiangmuUuidNumber) {
			this.tijianxiangmuUuidNumber = tijianxiangmuUuidNumber;
		}

		/**
		* 获取： 项目名称
		*/
		public String getTijianxiangmuName() {
			return tijianxiangmuName;
		}
		/**
		* 设置： 项目名称
		*/
		public void setTijianxiangmuName(String tijianxiangmuName) {
			this.tijianxiangmuName = tijianxiangmuName;
		}
		/**
		* 获取： 项目类型
		*/
		public Integer getTijianxiangmuTypes() {
			return tijianxiangmuTypes;
		}
		/**
		* 设置： 项目类型
		*/
		public void setTijianxiangmuTypes(Integer tijianxiangmuTypes) {
			this.tijianxiangmuTypes = tijianxiangmuTypes;
		}


			/**
			* 获取： 项目类型的值
			*/
			public String getTijianxiangmuValue() {
				return tijianxiangmuValue;
			}
			/**
			* 设置： 项目类型的值
			*/
			public void setTijianxiangmuValue(String tijianxiangmuValue) {
				this.tijianxiangmuValue = tijianxiangmuValue;
			}

		/**
		* 获取： 体检费用
		*/
		public Double getTijianxiangmuJingfei() {
			return tijianxiangmuJingfei;
		}
		/**
		* 设置： 体检费用
		*/
		public void setTijianxiangmuJingfei(Double tijianxiangmuJingfei) {
			this.tijianxiangmuJingfei = tijianxiangmuJingfei;
		}

		/**
		* 获取： 体检详情
		*/
		public String getTijianxiangmuContent() {
			return tijianxiangmuContent;
		}
		/**
		* 设置： 体检详情
		*/
		public void setTijianxiangmuContent(String tijianxiangmuContent) {
			this.tijianxiangmuContent = tijianxiangmuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getTijianxiangmuDelete() {
			return tijianxiangmuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setTijianxiangmuDelete(Integer tijianxiangmuDelete) {
			this.tijianxiangmuDelete = tijianxiangmuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 学号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 学号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 住址
		*/
		public String getYonghuAddress() {
			return yonghuAddress;
		}
		/**
		* 设置： 住址
		*/
		public void setYonghuAddress(String yonghuAddress) {
			this.yonghuAddress = yonghuAddress;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "TijianxiangmuYuyueView{" +
			", tijianxiangmuYuyueYesnoValue=" + tijianxiangmuYuyueYesnoValue +
			", tijianxiangmuYuyueValue=" + tijianxiangmuYuyueValue +
			", tijianxiangmuUuidNumber=" + tijianxiangmuUuidNumber +
			", tijianxiangmuName=" + tijianxiangmuName +
			", tijianxiangmuJingfei=" + tijianxiangmuJingfei +
			", tijianxiangmuContent=" + tijianxiangmuContent +
			", tijianxiangmuDelete=" + tijianxiangmuDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuAddress=" + yonghuAddress +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
