package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.CartEntity;
import com.wyl.mall.service.CartService;

import javax.servlet.http.HttpServletRequest;


/**
 * 购物车
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/cart")
@Api(value = "mall/cart", tags = "购物车")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 需要权限才能查看
     * 查看当前购物车
     */
    @GetMapping("/cart")
    public R cart(HttpServletRequest request) {
        String token = request.getHeader("token");
        R r = cartService.cart(token);
        return r;
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    @ApiOperation(value = "获取购物车列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username",value = "123",required = true)
    })
    //@RequiresPermissions("mall:cart:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cartService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:cart:info")
    public R info(@PathVariable("id") Long id){
		CartEntity cart = cartService.getById(id);

        return R.ok().put("cart", cart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:cart:save")
    public R save(@RequestBody CartEntity cart){
		cartService.save(cart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:cart:update")
    public R update(@RequestBody CartEntity cart){
		cartService.updateById(cart);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:cart:delete")
    public R delete(@RequestBody Long[] ids){
		cartService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
