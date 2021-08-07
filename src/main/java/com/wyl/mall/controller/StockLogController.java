package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wyl.mall.entity.StockLogEntity;
import com.wyl.mall.service.StockLogService;




/**
 * 库存记录
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/stocklog")
public class StockLogController {
    @Autowired
    private StockLogService stockLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:stocklog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:stocklog:info")
    public R info(@PathVariable("id") Long id){
		StockLogEntity stockLog = stockLogService.getById(id);

        return R.ok().put("stockLog", stockLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:stocklog:save")
    public R save(@RequestBody StockLogEntity stockLog){
		stockLogService.save(stockLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:stocklog:update")
    public R update(@RequestBody StockLogEntity stockLog){
		stockLogService.updateById(stockLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:stocklog:delete")
    public R delete(@RequestBody Long[] ids){
		stockLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
