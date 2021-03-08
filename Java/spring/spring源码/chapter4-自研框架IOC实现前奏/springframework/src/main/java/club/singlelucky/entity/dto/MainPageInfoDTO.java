package club.singlelucky.entity.dto;

import club.singlelucky.entity.bo.HeadLine;
import club.singlelucky.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
