
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
 * 体检项目
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tijianxiangmu")
public class TijianxiangmuController {
    private static final Logger logger = LoggerFactory.getLogger(TijianxiangmuController.class);

    private static final String TABLE_NAME = "tijianxiangmu";

    @Autowired
    private TijianxiangmuService tijianxiangmuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private TijianxiangmuYuyueService tijianxiangmuYuyueService;//体检项目预约
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
        params.put("tijianxiangmuDeleteStart",1);params.put("tijianxiangmuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = tijianxiangmuService.queryPage(params);

        //字典表数据转换
        List<TijianxiangmuView> list =(List<TijianxiangmuView>)page.getList();
        for(TijianxiangmuView c:list){
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
        TijianxiangmuEntity tijianxiangmu = tijianxiangmuService.selectById(id);
        if(tijianxiangmu !=null){
            //entity转view
            TijianxiangmuView view = new TijianxiangmuView();
            BeanUtils.copyProperties( tijianxiangmu , view );//把实体数据重构到view中
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
    public R save(@RequestBody TijianxiangmuEntity tijianxiangmu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tijianxiangmu:{}",this.getClass().getName(),tijianxiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<TijianxiangmuEntity> queryWrapper = new EntityWrapper<TijianxiangmuEntity>()
            .eq("tijianxiangmu_name", tijianxiangmu.getTijianxiangmuName())
            .eq("tijianxiangmu_types", tijianxiangmu.getTijianxiangmuTypes())
            .eq("tijianxiangmu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianxiangmuEntity tijianxiangmuEntity = tijianxiangmuService.selectOne(queryWrapper);
        if(tijianxiangmuEntity==null){
            tijianxiangmu.setTijianxiangmuDelete(1);
            tijianxiangmu.setInsertTime(new Date());
            tijianxiangmu.setCreateTime(new Date());
            tijianxiangmuService.insert(tijianxiangmu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TijianxiangmuEntity tijianxiangmu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tijianxiangmu:{}",this.getClass().getName(),tijianxiangmu.toString());
        TijianxiangmuEntity oldTijianxiangmuEntity = tijianxiangmuService.selectById(tijianxiangmu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(tijianxiangmu.getTijianxiangmuContent()) || "null".equals(tijianxiangmu.getTijianxiangmuContent())){
                tijianxiangmu.setTijianxiangmuContent(null);
        }

            tijianxiangmuService.updateById(tijianxiangmu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TijianxiangmuEntity> oldTijianxiangmuList =tijianxiangmuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<TijianxiangmuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TijianxiangmuEntity tijianxiangmuEntity = new TijianxiangmuEntity();
            tijianxiangmuEntity.setId(id);
            tijianxiangmuEntity.setTijianxiangmuDelete(2);
            list.add(tijianxiangmuEntity);
        }
        if(list != null && list.size() >0){
            tijianxiangmuService.updateBatchById(list);
        }

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
            List<TijianxiangmuEntity> tijianxiangmuList = new ArrayList<>();//上传的东西
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
                            TijianxiangmuEntity tijianxiangmuEntity = new TijianxiangmuEntity();
//                            tijianxiangmuEntity.setTijianxiangmuUuidNumber(data.get(0));                    //项目编号 要改的
//                            tijianxiangmuEntity.setTijianxiangmuName(data.get(0));                    //项目名称 要改的
//                            tijianxiangmuEntity.setTijianxiangmuTypes(Integer.valueOf(data.get(0)));   //项目类型 要改的
//                            tijianxiangmuEntity.setTijianxiangmuJingfei(data.get(0));                    //体检费用 要改的
//                            tijianxiangmuEntity.setTijianxiangmuContent("");//详情和图片
//                            tijianxiangmuEntity.setTijianxiangmuDelete(1);//逻辑删除字段
//                            tijianxiangmuEntity.setInsertTime(date);//时间
//                            tijianxiangmuEntity.setCreateTime(date);//时间
                            tijianxiangmuList.add(tijianxiangmuEntity);


                            //把要查询是否重复的字段放入map中
                                //项目编号
                                if(seachFields.containsKey("tijianxiangmuUuidNumber")){
                                    List<String> tijianxiangmuUuidNumber = seachFields.get("tijianxiangmuUuidNumber");
                                    tijianxiangmuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tijianxiangmuUuidNumber = new ArrayList<>();
                                    tijianxiangmuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tijianxiangmuUuidNumber",tijianxiangmuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //项目编号
                        List<TijianxiangmuEntity> tijianxiangmuEntities_tijianxiangmuUuidNumber = tijianxiangmuService.selectList(new EntityWrapper<TijianxiangmuEntity>().in("tijianxiangmu_uuid_number", seachFields.get("tijianxiangmuUuidNumber")).eq("tijianxiangmu_delete", 1));
                        if(tijianxiangmuEntities_tijianxiangmuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TijianxiangmuEntity s:tijianxiangmuEntities_tijianxiangmuUuidNumber){
                                repeatFields.add(s.getTijianxiangmuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [项目编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tijianxiangmuService.insertBatch(tijianxiangmuList);
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

