package com.wyl.mall.dto;/**
 * @Auther:calf
 * @Date:2021/8/21
 * @Description:mall411
 * @version:1.0
 */

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 收藏商品
 **/
@Data
public class LikeProductDto {

    @NotNull(message = "参数不合法")
    private Long memberId;

    @NotNull(message = "参数不合法")
    private Long productId;
}
