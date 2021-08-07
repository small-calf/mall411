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
