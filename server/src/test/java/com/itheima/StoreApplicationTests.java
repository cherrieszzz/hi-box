package com.itheima;

import cn.hutool.core.util.IdUtil;
import com.itheima.util.QiniuUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class StoreApplicationTests {
    @Resource
    private QiniuUtils qiniuUtils;
    @Test
    String contextLoads() {
        String filename = IdUtil.fastUUID()+".jpg";
        qiniuUtils.upload2Qiniu("D:\\hi-box\\server\\src\\main\\resources\\37bb8736-8fec-400e-8994-0c06a465976d.jpg",filename);
        return filename;
    }

}
