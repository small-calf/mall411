package com.wyl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.mall.dao.ReceiverDao;
import com.wyl.mall.dto.ReceiverDto;
import com.wyl.mall.entity.ReceiverEntity;
import com.wyl.mall.utils.PageUtils;
import com.wyl.mall.utils.R;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 收货地址
 *
 * @author calf
 * @email ${email}
 * @date 2021-08-04 00:18:48
 */
public interface ReceiverService extends IService<ReceiverEntity> {

    PageUtils queryPage(Map<String, Object> params,HttpServletRequest request);

    R addAddress(ReceiverDto receiverDto, HttpServletRequest request);

    R itemAddress(HttpServletRequest request);

    R updateAddress(ReceiverDto receiverDto, HttpServletRequest request);

    R deleteAddress(Long id, HttpServletRequest request);
}

