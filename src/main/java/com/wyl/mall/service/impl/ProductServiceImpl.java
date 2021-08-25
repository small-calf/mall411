package com.wyl.mall.service.impl;

import com.wyl.mall.entity.ProductCategoryEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.ProductDao;
import com.wyl.mall.entity.ProductEntity;
import com.wyl.mall.service.ProductService;

import javax.annotation.Resource;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductEntity> page = this.page(
                new Query<ProductEntity>().getPage(params),
                new QueryWrapper<ProductEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R searchaProduct(String searchCondition) {
        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();
        wrapper.like("caption",searchCondition).or().like("name",searchCondition);
        List<ProductEntity> productEntities = productDao.selectList(wrapper);
        return R.ok().put("data",productEntities);
    }

    @Override
    public R categorySearchProduct(Long id) {
        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_category_id",id);
        List<ProductEntity> productEntities = productDao.selectList(wrapper);
        return R.ok().put("data",productEntities);
    }

    @Override
    public R categorySearchProductBySort(Long id,int sort) {
        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_category_id",id);
        if (sort == 1) {
            //降序
            wrapper.orderByDesc("market_price");
        }else {
            //升序
            wrapper.orderByAsc("market_price");
        }
        List<ProductEntity> productEntities = productDao.selectList(wrapper);
        return R.ok().put("data",productEntities);
    }

    @Override
    public R searchaProductBySort(String sortName, int sort) {
        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();
        wrapper.like("caption",sortName).or().like("name",sortName);
        if (sort == 1) {
            //降序
            wrapper.orderByDesc("market_price");
        }else {
            //升序
            wrapper.orderByAsc("market_price");
        }
        List<ProductEntity> productEntities = productDao.selectList(wrapper);
        return R.ok().put("data",productEntities);
    }

    @Override
    public R getProductInfo(Long id) {
        ProductEntity productEntity = productDao.selectById(id);
        return R.ok().put("data",productEntity);
    }

}