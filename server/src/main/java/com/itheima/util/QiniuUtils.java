package com.itheima.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 七牛云工具类
 */
@Component
@Data
public class QiniuUtils {
    /**
     * 公钥
     */
    @Value("${QiNiuConfig.accessKey}")
    private String accessKey ;
    /**
     * 私钥
     */
    @Value("${QiNiuConfig.secretKey}")
    private String secretKey ;
    /**
     * 存储空间
     */
    @Value("${QiNiuConfig.bucket}")
    private String bucket ;
    /**
     * 存储区域
     */
    @Value("${QiNiuConfig.MemoryArea}")
    private String MemoryArea ;
    private  Configuration getConfiguration(String MemoryArea){
        //构造一个带指定Zone对象的配置类
        Configuration cfg;
        switch (MemoryArea) {
            case "z0":
                cfg = new Configuration(Zone.zone0());
                break;
            case "z1":
                cfg = new Configuration(Zone.zone1());
                break;
            case "z2":
                cfg = new Configuration(Zone.zone2());
                break;
            case "na0":
                cfg = new Configuration(Zone.zoneNa0());
                break;
            default:
                cfg = new Configuration(Zone.zoneAs0());
                break;
        }
        return cfg;
    }
    public  void upload2Qiniu(String filePath, String fileName) {
        Configuration cfg = getConfiguration(MemoryArea);
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    //上传文件
    public  void upload2Qiniu(byte[] bytes, String fileName) {
        Configuration cfg = getConfiguration(MemoryArea);
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    //删除文件
    public  void deleteFileFromQiniu(String fileName) {
        Configuration cfg = getConfiguration(MemoryArea);
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }
}
