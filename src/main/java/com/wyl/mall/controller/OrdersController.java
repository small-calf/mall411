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

import com.wyl.mall.entity.OrdersEntity;
import com.wyl.mall.service.OrdersService;




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
