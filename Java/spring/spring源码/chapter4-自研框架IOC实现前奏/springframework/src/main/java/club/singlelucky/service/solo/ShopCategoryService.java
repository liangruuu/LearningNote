package club.singlelucky.service.solo;

import club.singlelucky.entity.bo.HeadLine;
import club.singlelucky.entity.bo.ShopCategory;
import club.singlelucky.entity.dto.Result;

import java.util.List;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public interface ShopCategoryService {
    Result<Boolean> addShopCategory(ShopCategory shopCategory);

    Result<Boolean> removeShopCategory(int shopCategoryId);

    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);

    Result<ShopCategory> queryShopCategoryById(int shopCategoryId);

    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
