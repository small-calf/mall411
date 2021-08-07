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

import com.wyl.mall.entity.ReceiverEntity;
import com.wyl.mall.service.ReceiverService;



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
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:receiver:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = receiverService.queryPage(params);

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
