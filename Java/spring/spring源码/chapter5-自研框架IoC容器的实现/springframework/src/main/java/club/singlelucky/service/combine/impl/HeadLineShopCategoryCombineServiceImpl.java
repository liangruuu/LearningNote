package club.singlelucky.service.combine.impl;

import club.singlelucky.entity.bo.HeadLine;
import club.singlelucky.entity.bo.ShopCategory;
import club.singlelucky.entity.dto.MainPageInfoDTO;
import club.singlelucky.entity.dto.Result;
import club.singlelucky.service.combine.HeadLineShopCategoryCombineService;
import club.singlelucky.service.solo.HeadLineService;
import club.singlelucky.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.inject.annotation.AutoWired;

import java.util.List;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {
    @AutoWired
    private HeadLineService headLineService;
    @AutoWired
    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        // 1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLineCondition, 1, 4);
        // 2.获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        // 3.合并两者并返回
//        Result<MainPageInfoDTO> result =  mergeMainPageInfoResult(headLineResult, shopCategoryResult);

        return null;
    }
}
