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

import com.wyl.mall.entity.StoreRankEntity;
import com.wyl.mall.service.StoreRankService;



/**
 * 店铺等级
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/storerank")
public class StoreRankController {
    @Autowired
    private StoreRankService storeRankService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:storerank:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storeRankService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:storerank:info")
    public R info(@PathVariable("id") Long id){
		StoreRankEntity storeRank = storeRankService.getById(id);

        return R.ok().put("storeRank", storeRank);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:storerank:save")
    public R save(@RequestBody StoreRankEntity storeRank){
		storeRankService.save(storeRank);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:storerank:update")
    public R update(@RequestBody StoreRankEntity storeRank){
		storeRankService.updateById(storeRank);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:storerank:delete")
    public R delete(@RequestBody Long[] ids){
		storeRankService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
