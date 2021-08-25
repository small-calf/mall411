package com.wyl.mall.service.impl;

import com.wyl.mall.entity.UsersEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wyl.mall.dao.ProductCategoryDao;
import com.wyl.mall.entity.ProductCategoryEntity;
import com.wyl.mall.service.ProductCategoryService;

import javax.annotation.Resource;


@Service("productCategoryService")
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategoryEntity> implements ProductCategoryService {

    @Resource
    private ProductCategoryDao productCategoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductCategoryEntity> page = this.page(
                new Query<ProductCategoryEntity>().getPage(params),
                new QueryWrapper<ProductCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R threeProductCategory() {

        List<ProductCategoryEntity> allProductCategoryEntities = productCategoryDao.selectList(null);
        List<ProductCategoryEntity> collect = allProductCategoryEntities.stream().filter(productCategoryEntity -> {
            return productCategoryEntity.getGrade() == 0;

        }).map(menu -> {
            menu.setChildren(getChildrens(menu,allProductCategoryEntities));
            return menu;
        }).collect(Collectors.toList());
        return R.ok().put("data",collect);
    }

    @Override
    public R oneProductCategory() {
        QueryWrapper<ProductCategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("grade",0);
        List<ProductCategoryEntity> productCategoryEntities = productCategoryDao.selectList(wrapper);
        return R.ok().put("data",productCategoryEntities);
    }

    @Override
    public Long searchIdByName(String categoryName) {
        ProductCategoryEntity categoryEntity = productCategoryDao.selectOne(new QueryWrapper<ProductCategoryEntity>().eq("name", categoryName));
        return categoryEntity.getId();
    }

    //递归查找所有菜单的子菜单
    private List<ProductCategoryEntity> getChildrens(ProductCategoryEntity root,List<ProductCategoryEntity> all){

        List<ProductCategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentId() == root.getId();
        }).map(categoryEntity -> {
            //1、找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).collect(Collectors.toList());

        return children;
    }

}