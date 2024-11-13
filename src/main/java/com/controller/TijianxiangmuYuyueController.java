
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 体检项目预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tijianxiangmuYuyue")
public class TijianxiangmuYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(TijianxiangmuYuyueController.class);

    private static final String TABLE_NAME = "tijianxiangmuYuyue";

    @Autowired
    private TijianxiangmuYuyueService tijianxiangmuYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private TijianxiangmuService tijianxiangmuService;//体检项目
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = tijianxiangmuYuyueService.queryPage(params);

        //字典表数据转换
        List<TijianxiangmuYuyueView> list =(List<TijianxiangmuYuyueView>)page.getList();
        for(TijianxiangmuYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TijianxiangmuYuyueEntity tijianxiangmuYuyue = tijianxiangmuYuyueService.selectById(id);
        if(tijianxiangmuYuyue !=null){
            //entity转view
            TijianxiangmuYuyueView view = new TijianxiangmuYuyueView();
            BeanUtils.copyProperties( tijianxiangmuYuyue , view );//把实体数据重构到view中
            //级联表 体检项目
            //级联表
            TijianxiangmuEntity tijianxiangmu = tijianxiangmuService.selectById(tijianxiangmuYuyue.getTijianxiangmuId());
            if(tijianxiangmu != null){
            BeanUtils.copyProperties( tijianxiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setTijianxiangmuId(tijianxiangmu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(tijianxiangmuYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TijianxiangmuYuyueEntity tijianxiangmuYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tijianxiangmuYuyue:{}",this.getClass().getName(),tijianxiangmuYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            tijianxiangmuYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<TijianxiangmuYuyueEntity> queryWrapper = new EntityWrapper<TijianxiangmuYuyueEntity>()
            .eq("tijianxiangmu_id", tijianxiangmuYuyue.getTijianxiangmuId())
            .eq("yonghu_id", tijianxiangmuYuyue.getYonghuId())
            .in("tijianxiangmu_yuyue_yesno_types", new Integer[]{1,2})
            .eq("tijianxiangmu_yuyue_types", tijianxiangmuYuyue.getTijianxiangmuYuyueTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianxiangmuYuyueEntity tijianxiangmuYuyueEntity = tijianxiangmuYuyueService.selectOne(queryWrapper);
        if(tijianxiangmuYuyueEntity==null){
            tijianxiangmuYuyue.setTijianxiangmuYuyueYesnoTypes(1);
            tijianxiangmuYuyue.setInsertTime(new Date());
            tijianxiangmuYuyue.setCreateTime(new Date());
            tijianxiangmuYuyueService.insert(tijianxiangmuYuyue);
            return R.ok();
        }else {
            if(tijianxiangmuYuyueEntity.getTijianxiangmuYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(tijianxiangmuYuyueEntity.getTijianxiangmuYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TijianxiangmuYuyueEntity tijianxiangmuYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tijianxiangmuYuyue:{}",this.getClass().getName(),tijianxiangmuYuyue.toString());
        TijianxiangmuYuyueEntity oldTijianxiangmuYuyueEntity = tijianxiangmuYuyueService.selectById(tijianxiangmuYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            tijianxiangmuYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(tijianxiangmuYuyue.getTijianxiangmuYuyueText()) || "null".equals(tijianxiangmuYuyue.getTijianxiangmuYuyueText())){
                tijianxiangmuYuyue.setTijianxiangmuYuyueText(null);
        }
        if("".equals(tijianxiangmuYuyue.getTijianxiangmuYuyueYesnoText()) || "null".equals(tijianxiangmuYuyue.getTijianxiangmuYuyueYesnoText())){
                tijianxiangmuYuyue.setTijianxiangmuYuyueYesnoText(null);
        }

            tijianxiangmuYuyueService.updateById(tijianxiangmuYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody TijianxiangmuYuyueEntity tijianxiangmuYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,tijianxiangmuYuyueEntity:{}",this.getClass().getName(),tijianxiangmuYuyueEntity.toString());

        TijianxiangmuYuyueEntity oldTijianxiangmuYuyue = tijianxiangmuYuyueService.selectById(tijianxiangmuYuyueEntity.getId());//查询原先数据

        if(tijianxiangmuYuyueEntity.getTijianxiangmuYuyueYesnoTypes() == 2){//通过
            tijianxiangmuYuyueEntity.setTijianxiangmuYuyueTypes(101);
        }else if(tijianxiangmuYuyueEntity.getTijianxiangmuYuyueYesnoTypes() == 3){//拒绝
            tijianxiangmuYuyueEntity.setTijianxiangmuYuyueTypes(100);
        }
        tijianxiangmuYuyueService.updateById(tijianxiangmuYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TijianxiangmuYuyueEntity> oldTijianxiangmuYuyueList =tijianxiangmuYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        tijianxiangmuYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<TijianxiangmuYuyueEntity> tijianxiangmuYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            TijianxiangmuYuyueEntity tijianxiangmuYuyueEntity = new TijianxiangmuYuyueEntity();
//                            tijianxiangmuYuyueEntity.setTijianxiangmuId(Integer.valueOf(data.get(0)));   //体检项目 要改的
//                            tijianxiangmuYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            tijianxiangmuYuyueEntity.setTijianxiangmuYuyueTime(sdf.parse(data.get(0)));          //预约日期 要改的
//                            tijianxiangmuYuyueEntity.setTijianxiangmuYuyueText(data.get(0));                    //预约备注 要改的
//                            tijianxiangmuYuyueEntity.setTijianxiangmuYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            tijianxiangmuYuyueEntity.setTijianxiangmuYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            tijianxiangmuYuyueEntity.setTijianxiangmuYuyueTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            tijianxiangmuYuyueEntity.setInsertTime(date);//时间
//                            tijianxiangmuYuyueEntity.setCreateTime(date);//时间
                            tijianxiangmuYuyueList.add(tijianxiangmuYuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tijianxiangmuYuyueService.insertBatch(tijianxiangmuYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

