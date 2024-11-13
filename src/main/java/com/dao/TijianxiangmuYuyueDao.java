package com.dao;

import com.entity.TijianxiangmuYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianxiangmuYuyueView;

/**
 * 体检项目预约 Dao 接口
 *
 * @author 
 */
public interface TijianxiangmuYuyueDao extends BaseMapper<TijianxiangmuYuyueEntity> {

   List<TijianxiangmuYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
