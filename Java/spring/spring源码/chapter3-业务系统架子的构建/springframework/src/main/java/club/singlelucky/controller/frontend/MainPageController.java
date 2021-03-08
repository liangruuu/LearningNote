package club.singlelucky.controller.frontend;

import club.singlelucky.entity.dto.MainPageInfoDTO;
import club.singlelucky.entity.dto.Result;
import club.singlelucky.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public class MainPageController {
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
