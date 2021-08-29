package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.dao.ProductDao;
import com.wyl.mall.dto.OrdersDto;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import com.wyl.mall.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.OrdersEntity;
import com.wyl.mall.service.OrdersService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 订单
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 创建订单
     */
    @PostMapping("/createOrders")
    public R createOrders(@RequestBody OrdersDto ordersDto,
                          HttpServletRequest request) {
        R r = ordersService.createOrders(ordersDto,request);

        return r;
    }

    /**
     * 查看所有订单
     */
    @GetMapping("/listOrders")
    public R listOrders(HttpServletRequest request) {
        R r = ordersService.listOrders(request);

        return r;
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:orders:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ordersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:orders:info")
    public R info(@PathVariable("id") Long id){
		OrdersEntity orders = ordersService.getById(id);

        return R.ok().put("orders", orders);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:orders:save")
    public R save(@RequestBody OrdersEntity orders){
		ordersService.save(orders);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:orders:update")
    public R update(@RequestBody OrdersEntity orders){
		ordersService.updateById(orders);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:orders:delete")
    public R delete(@RequestBody Long[] ids){
		ordersService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
