package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.wyl.mall.entity.ProductEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.CartItemEntity;
import com.wyl.mall.service.CartItemService;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;


/**
 * 购物车项
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/cartitem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    /**
     * 查看购物车中的具体某一项
     */
    @GetMapping("/item")
    public R cartItem(@RequestParam("productId") Long productId,
                      HttpServletRequest request) {
        R r = cartItemService.cartItem(productId,request);
        return r;
    }
    /**
     * 加入购物车
     */
    @PostMapping("/add")
    public R cartItemAdd(@RequestParam("productId") Long productId,
                         HttpServletRequest request) {
        //查询购物车中是否存在该商品
        Map<String, Object> map = cartItemService.selectListProduct(productId,request);

        if (map == null) {
            return R.error(403,"权限错误");
        }

        Object productEntity = map.get("cartItemEntity");

        if (productEntity == null) {
            //购物车中没有，加入购物车
            R r = cartItemService.addCartItem(productId,Long.parseLong(map.get("userId").toString()));
            return r;
        }

        //修改购物车的数量
        R r = cartItemService.updateCartItem(productId, Long.parseLong(map.get("userId").toString()));

        return r;

    }
    /**
     * 购物车中的加减(+,-按钮)
     */
    @PostMapping("/addorreduce")
    public R buttonCartItem(@RequestParam("addorreduce") int addorreduce,//addorreduce: 0：加1：减
                            @RequestParam("productId") Long productId,
                            HttpServletRequest request) {

        R r = cartItemService.buttonCartItem(productId,addorreduce,request);

        return r;
    }

    /**
     * 批量删除购物车
     */
    @PostMapping("/select/delete")
    public R selectDelete(@RequestParam("productId") String productId,
                          HttpServletRequest request) {

        String[] split = productId.split(",");


        R r = cartItemService.selectDelete(split,request);



        return r;
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:cartitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cartItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:cartitem:info")
    public R info(@PathVariable("id") Long id){
		CartItemEntity cartItem = cartItemService.getById(id);

        return R.ok().put("cartItem", cartItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:cartitem:save")
    public R save(@RequestBody CartItemEntity cartItem){
		cartItemService.save(cartItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:cartitem:update")
    public R update(@RequestBody CartItemEntity cartItem){
		cartItemService.updateById(cartItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:cartitem:delete")
    public R delete(@RequestBody Long[] ids){
		cartItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
