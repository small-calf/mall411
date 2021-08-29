package com.wyl.mall.controller;

import java.util.Arrays;
import java.util.Map;

import com.wyl.mall.dao.ReceiverDao;
import com.wyl.mall.dto.ReceiverDto;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wyl.mall.entity.ReceiverEntity;
import com.wyl.mall.service.ReceiverService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * 收货地址
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/receiver")
public class ReceiverController {
    @Autowired
    private ReceiverService receiverService;


    /**
     * 添加地址
     */
    @PostMapping("/add")
    public R addAddress(@Valid @RequestBody ReceiverDto receiverDto,
                        HttpServletRequest request) {
        R r = receiverService.addAddress(receiverDto,request);
        return r;
    }

    /**
     * 查看所有收货地址
     */
    @GetMapping("/item")
    public R itemAddress(HttpServletRequest request) {
        R r = receiverService.itemAddress(request);
        return r;
    }

    /**
     * 修改地址
     */
    @PostMapping("/updateAddress")
    public R updateAddress(@Valid @RequestBody ReceiverDto receiverDto,
                           HttpServletRequest request){
        R r = receiverService.updateAddress(receiverDto,request);

        return r;
    }

    /**
     * 删除地址
     */
    @PostMapping("/deleteAddress")
    public R deleteAddress(@RequestParam("id") Long id,
                           HttpServletRequest request){
        R r = receiverService.deleteAddress(id,request);

        return r;
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:receiver:list")
    public R list(@RequestParam Map<String, Object> params,
                  HttpServletRequest request){

        PageUtils page = receiverService.queryPage(params,request);

        if (page == null) {
            return R.error(403,"权限错误");
        }

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:receiver:info")
    public R info(@PathVariable("id") Long id){
		ReceiverEntity receiver = receiverService.getById(id);

        return R.ok().put("receiver", receiver);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:receiver:save")
    public R save(@RequestBody ReceiverEntity receiver){
		receiverService.save(receiver);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:receiver:update")
    public R update(@RequestBody ReceiverEntity receiver){
		receiverService.updateById(receiver);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:receiver:delete")
    public R delete(@RequestBody Long[] ids){
		receiverService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
