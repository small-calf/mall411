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

import com.wyl.mall.entity.ProductCategoryStoreEntity;
import com.wyl.mall.service.ProductCategoryStoreService;


/**
 * 商品分类店铺绑定
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/productcategorystore")
public class ProductCategoryStoreController {
    @Autowired
    private ProductCategoryStoreService productCategoryStoreService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:productcategorystore:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productCategoryStoreService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{storesId}")
    //@RequiresPermissions("mall:productcategorystore:info")
    public R info(@PathVariable("storesId") Long storesId){
		ProductCategoryStoreEntity productCategoryStore = productCategoryStoreService.getById(storesId);

        return R.ok().put("productCategoryStore", productCategoryStore);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:productcategorystore:save")
    public R save(@RequestBody ProductCategoryStoreEntity productCategoryStore){
		productCategoryStoreService.save(productCategoryStore);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:productcategorystore:update")
    public R update(@RequestBody ProductCategoryStoreEntity productCategoryStore){
		productCategoryStoreService.updateById(productCategoryStore);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:productcategorystore:delete")
    public R delete(@RequestBody Long[] storesIds){
		productCategoryStoreService.removeByIds(Arrays.asList(storesIds));

        return R.ok();
    }

}
