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

import com.wyl.mall.entity.StoreFavoriteEntity;
import com.wyl.mall.service.StoreFavoriteService;



/**
 * 店铺收藏
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
@RestController
@RequestMapping("mall/storefavorite")
public class StoreFavoriteController {
    @Autowired
    private StoreFavoriteService storeFavoriteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("mall:storefavorite:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storeFavoriteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("mall:storefavorite:info")
    public R info(@PathVariable("id") Long id){
		StoreFavoriteEntity storeFavorite = storeFavoriteService.getById(id);

        return R.ok().put("storeFavorite", storeFavorite);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mall:storefavorite:save")
    public R save(@RequestBody StoreFavoriteEntity storeFavorite){
		storeFavoriteService.save(storeFavorite);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mall:storefavorite:update")
    public R update(@RequestBody StoreFavoriteEntity storeFavorite){
		storeFavoriteService.updateById(storeFavorite);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mall:storefavorite:delete")
    public R delete(@RequestBody Long[] ids){
		storeFavoriteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
