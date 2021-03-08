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
public class HeadLineShopCategoryCombineServiceImpl2 implements HeadLineShopCategoryCombineService {

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        return null;
    }
}
