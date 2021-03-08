package club.singlelucky.service.combine;

import club.singlelucky.entity.dto.MainPageInfoDTO;
import club.singlelucky.entity.dto.Result;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}
