package com.wyl.mall.service.impl;

import com.wyl.mall.dto.ReceiverDto;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.Query;
import com.wyl.mall.utils.R;
import com.wyl.mall.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.mall.dao.ReceiverDao;
import com.wyl.mall.entity.ReceiverEntity;
import com.wyl.mall.service.ReceiverService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Service("receiverService")
public class ReceiverServiceImpl extends ServiceImpl<ReceiverDao, ReceiverEntity> implements ReceiverService {

    @Resource
    private ReceiverDao receiverDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public PageUtils queryPage(Map<String, Object> params,HttpServletRequest request) {

        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return null;
        }

        IPage<ReceiverEntity> page = this.page(
                new Query<ReceiverEntity>().getPage(params),
                new QueryWrapper<ReceiverEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R addAddress(ReceiverDto receiverDto, HttpServletRequest request) {
        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return R.error(403,"权限错误");
        }

        ReceiverEntity receiverEntity = new ReceiverEntity();
        BeanUtils.copyProperties(receiverDto,receiverEntity);
        receiverEntity.setMemberId(Long.parseLong(userId));
        receiverEntity.setCreatedDate(new Date());
        receiverEntity.setLastModifiedDate(new Date());


        receiverDao.insert(receiverEntity);

        return R.ok();
    }

    @Override
    public R itemAddress(HttpServletRequest request) {
        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return R.error(403,"权限错误");
        }
        QueryWrapper<ReceiverEntity> wrapper = new QueryWrapper<ReceiverEntity>().eq("member_id", userId);
        List<ReceiverEntity> receiverEntities = receiverDao.selectList(wrapper);
        return R.ok().put("data",receiverEntities);
    }

    @Override
    public R updateAddress(ReceiverDto receiverDto, HttpServletRequest request) {
        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return R.error(403,"权限错误");
        }
        QueryWrapper<ReceiverEntity> wrapper = new QueryWrapper<ReceiverEntity>().eq("id",receiverDto.getId());
        ReceiverEntity receiverEntity = receiverDao.selectOne(wrapper);

        if (receiverEntity == null) {
            return R.error(401,"当前地址不存在");
        }
        BeanUtils.copyProperties(receiverDto,receiverEntity);

        receiverEntity.setLastModifiedDate(new Date());

        receiverDao.updateById(receiverEntity);
        return R.ok();
    }

    @Override
    public R deleteAddress(Long id, HttpServletRequest request) {
        String userId = tokenUtils.getToken(request.getHeader("token"));

        if (userId.equals("error")) {

            return R.error(403,"权限错误");
        }
        QueryWrapper<ReceiverEntity> wrapper = new QueryWrapper<ReceiverEntity>().eq("id",id);
        ReceiverEntity receiverEntity = receiverDao.selectOne(wrapper);

        if (receiverEntity == null) {
            return R.error(401,"当前地址不存在");
        }

        receiverDao.deleteById(id);
        return R.ok();
    }

}