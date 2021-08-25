package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.wyl.mall.service.ProductCategoryService;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.ProductEntity;
import com.wyl.mall.service.ProductService;



/**
 * 商品
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 首页
     * 搜索商品
     */
    @GetMapping("/searchProduct")
    public R searchProduct(@RequestParam(value = "searchCondition") String searchCondition) {
        R r = productService.searchaProduct(searchCondition);
        return r;
    }
    /**
     * 根据分类检索商品
     */
    @GetMapping("/categorySearchProduct")
    public R categorySearchProduct(@RequestParam("categoryName") String categoryName) {
        Long id = productCategoryService.searchIdByName(categoryName);
        R r = productService.categorySearchProduct(id);
        return r;
    }
    /**
     * 通过分类查询或者通过检索名称或副标题查询的分类排序
     * 1,根据分类检索商品排序
     * 2、搜索商品排序
     */
    @GetMapping("/categoryOrSearchSort")//
    public R categoryOrSearchSort(@RequestParam("sortName") String sortName,
                                  @RequestParam("type") int type,   //1:名称或副标题 2：分类
                                  @RequestParam("sort") int sort) {//1:降序 2：升序
        if (type == 2) {
            Long id = productCategoryService.searchIdByName(sortName);
            R r =productService.categorySearchProductBySort(id,sort);
            return r;
        }

        if (type == 1) {
            R r = productService.searchaProductBySort(sortName,sort);
            return r;
        }

        return R.error(401,"信息不存在");
    }

    /**
     * 查询某一商品具体信息
     */
    @GetMapping("/getProductInfo")
    public R getProductInfo(@RequestParam("id") Long id) {
        R r = productService.getProductInfo(id);
        return r;
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:product:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:product:info")
    public R info(@PathVariable("id") Long id){
		ProductEntity product = productService.getById(id);

        return R.ok().put("product", product);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:product:save")
    public R save(@RequestBody ProductEntity product){
		productService.save(product);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:product:update")
    public R update(@RequestBody ProductEntity product){
		productService.updateById(product);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:product:delete")
    public R delete(@RequestBody Long[] ids){
		productService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
