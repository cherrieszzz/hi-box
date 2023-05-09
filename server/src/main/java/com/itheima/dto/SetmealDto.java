package com.itheima.dto;

import com.itheima.entity.Setmeal;
import lombok.Data;

import java.util.List;

/**
 * @author WangFK
 * @version 1.0
 * @since 2023/5/7 16:33
 */
@Data
public class SetmealDto extends Setmeal {
    String categoryName;
    List<String> goodsList;
    List<String>imgList;
}
