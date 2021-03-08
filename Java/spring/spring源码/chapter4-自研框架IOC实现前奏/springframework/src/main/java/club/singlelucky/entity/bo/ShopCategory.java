package club.singlelucky.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
