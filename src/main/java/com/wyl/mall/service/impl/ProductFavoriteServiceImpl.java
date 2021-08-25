package com.wyl.mall.service.impl;

import com.wyl.mall.dao.ProductDao;
import com.wyl.mall.dto.LikeProductDto;
import com.wyl.mall.entity.ProductEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.wyl.mall.dao.ProductFavoriteDao;
import com.wyl.mall.entity.ProductFavoriteEntity;
import com.wyl.mall.service.ProductFavoriteService;


@Service("productFavoriteService")
public class ProductFavoriteServiceImpl extends ServiceImpl<ProductFavoriteDao, ProductFavoriteEntity> implements ProductFavoriteService {

    @Autowired
    private ProductFavoriteDao productFavoriteDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductFavoriteEntity> page = this.page(
                new Query<ProductFavoriteEntity>().getPage(params),
                new QueryWrapper<ProductFavoriteEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R likeProduct(LikeProductDto likeProductDto) {
        ProductFavoriteEntity productFavoriteEntity = new ProductFavoriteEntity();
        BeanUtils.copyProperties(likeProductDto,productFavoriteEntity);

        productFavoriteDao.insert(productFavoriteEntity);
        return R.ok();
    }

    @Override
    public R seeLikeProduct(Long id) {
        QueryWrapper<ProductFavoriteEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id",id);
        List<ProductFavoriteEntity> favoriteEntities = productFavoriteDao.selectList(wrapper);
        ArrayList<ProductEntity> list = new ArrayList<>();
        for (ProductFavoriteEntity p:favoriteEntities) {
            ProductEntity productEntity = productDao.selectById(p.getProductId());
            list.add(productEntity);
        }
        return R.ok().put("data",list);
    }

}