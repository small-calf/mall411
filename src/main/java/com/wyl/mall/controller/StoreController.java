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

import com.wyl.mall.entity.StoreEntity;
import com.wyl.mall.service.StoreService;


/**
 * 店铺
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:store:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:store:info")
    public R info(@PathVariable("id") Long id){
		StoreEntity store = storeService.getById(id);

        return R.ok().put("store", store);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:store:save")
    public R save(@RequestBody StoreEntity store){
		storeService.save(store);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:store:update")
    public R update(@RequestBody StoreEntity store){
		storeService.updateById(store);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:store:delete")
    public R delete(@RequestBody Long[] ids){
		storeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
