package com.wyl.mall.utils;/**
 * @Auther:calf
 * @Date:2021/8/14
 * @Description:mall411
 * @version:1.0
 */

import com.wyl.mall.exception.MyException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 **/
public class UploadAvatar {
    public static void uploadPhoto(String path, MultipartFile file) {
        String filename = file.getOriginalFilename();
        File dest = new File(path + filename);

        try {
            file.transferTo(dest);
            Log4jUtil.info("上传文件成功...");
        }catch (IOException e) {
            throw new MyException("上传文件异常");
        }
    }
}
