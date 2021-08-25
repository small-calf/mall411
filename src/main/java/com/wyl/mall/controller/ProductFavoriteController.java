package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.dto.LikeProductDto;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.ProductFavoriteEntity;
import com.wyl.mall.service.ProductFavoriteService;

import javax.validation.Valid;


/**
 * 商品收藏
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-07 15:28:06
 */
@RestController
@RequestMapping("mall/productfavorite")
public class ProductFavoriteController {
    @Autowired
    private ProductFavoriteService productFavoriteService;

    /**
     * 收藏商品
     * 权限验证
     */
    @PostMapping("/likeProduct")
    public R likeProduct(@Valid @RequestBody LikeProductDto likeProductDto) {
        R r = productFavoriteService.likeProduct(likeProductDto);
        return r;
    }
    /**
     * 查看收藏的商品
     * 权限验证
     */
    @GetMapping("/seeLikeProduct")
//    @RequiresPermissions("item:test")
    public R seeLikeProduct(@RequestParam("id") Long id) {
        R r = productFavoriteService.seeLikeProduct(id);//根据用户id查看所收藏的商品
        return r;
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:productfavorite:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productFavoriteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:productfavorite:info")
    public R info(@PathVariable("id") Long id){
		ProductFavoriteEntity productFavorite = productFavoriteService.getById(id);

        return R.ok().put("productFavorite", productFavorite);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:productfavorite:save")
    public R save(@RequestBody ProductFavoriteEntity productFavorite){
		productFavoriteService.save(productFavorite);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:productfavorite:update")
    public R update(@RequestBody ProductFavoriteEntity productFavorite){
		productFavoriteService.updateById(productFavorite);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:productfavorite:delete")
    public R delete(@RequestBody Long[] ids){
		productFavoriteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
