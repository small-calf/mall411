package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.ProductCategoryEntity;
import com.wyl.mall.service.ProductCategoryService;




/**
 * 商品分类
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/productcategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;


    /**
     * 查询三级分类
     */
    @GetMapping("/threeProductCategory")
    public R threeProductCategory() {
        R r = productCategoryService.threeProductCategory();
        return r;
    }

    /**
     * 查询一级分类
     */
    @GetMapping("/oneProductCategory")
    public R onrProductCategory() {
        R r = productCategoryService.oneProductCategory();
        return r;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:productcategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:productcategory:info")
    public R info(@PathVariable("id") Long id){
		ProductCategoryEntity productCategory = productCategoryService.getById(id);

        return R.ok().put("productCategory", productCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:productcategory:save")
    public R save(@RequestBody ProductCategoryEntity productCategory){
		productCategoryService.save(productCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:productcategory:update")
    public R update(@RequestBody ProductCategoryEntity productCategory){
		productCategoryService.updateById(productCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:productcategory:delete")
    public R delete(@RequestBody Long[] ids){
		productCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
