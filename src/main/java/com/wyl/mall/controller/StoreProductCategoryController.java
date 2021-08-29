package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.StoreProductCategoryEntity;
import com.wyl.mall.service.StoreProductCategoryService;


/**
 * 店铺商品分类
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/storeproductcategory")
public class StoreProductCategoryController {
    @Autowired
    private StoreProductCategoryService storeProductCategoryService;

    /**
     * 查询当前店铺的所有商品分类
     */
    @GetMapping("/allCategoryByStore")
    public R allCategoryByStore(@RequestParam("storeId") String storeId) {
        R r = storeProductCategoryService.allCategoryByStore(storeId);
        return r;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:storeproductcategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storeProductCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:storeproductcategory:info")
    public R info(@PathVariable("id") Long id){
		StoreProductCategoryEntity storeProductCategory = storeProductCategoryService.getById(id);

        return R.ok().put("storeProductCategory", storeProductCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:storeproductcategory:save")
    public R save(@RequestBody StoreProductCategoryEntity storeProductCategory){
		storeProductCategoryService.save(storeProductCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:storeproductcategory:update")
    public R update(@RequestBody StoreProductCategoryEntity storeProductCategory){
		storeProductCategoryService.updateById(storeProductCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:storeproductcategory:delete")
    public R delete(@RequestBody Long[] ids){
		storeProductCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
