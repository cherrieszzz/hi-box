package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.CommentMapper;
import com.itheima.service.GoodsService;
import com.itheima.dao.GoodsMapper;
import com.itheima.entity.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品信息(Goods)表服务实现类
 *
 * @author WangFK
 * @since 2023-05-05 14:35:22
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private CommentMapper commentMapper;
    @Override
    public boolean updateStatus(Integer status,Long id) {
        return  goodsMapper.updateStatus(status,id);

    }

    @Override
    public boolean removeComment(List<String> idList) {
        boolean flag=false;
        if (commentMapper.deleteBatchIds(idList)>0){
            flag=true;
        }
        return flag&&commentMapper.removeComment(idList);

    }

    @Override
    public List<Long> getSetmealId(List<String> idList) {
        return goodsMapper.getSetmealId(idList);
    }
}

