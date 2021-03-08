package club.singlelucky.controller.superadmin;

import club.singlelucky.entity.bo.HeadLine;
import club.singlelucky.entity.dto.Result;
import club.singlelucky.service.solo.HeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public class HeadLineOperationController {
    private HeadLineService headLineService;

    public Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO:参数校验以及请求参数的转化
        return headLineService.addHeadLine(new HeadLine());
    }

    public Result<Boolean> removeHeadline(HttpServletRequest req, HttpServletResponse resp) {
        // TODO:参数校验以及请求参数的转化
        return headLineService.removeHeadline(1);
    }

    public Result<Boolean> modifyHeadline(HttpServletRequest req, HttpServletResponse resp) {
        // TODO:参数校验以及请求参数的转化
        return headLineService.modifyHeadline(new HeadLine());
    }

    public Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp) {
        // TODO:参数校验以及请求参数的转化
        return headLineService.queryHeadLineById(1);
    }

    public Result<List<HeadLine>> queryHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        // TODO:参数校验以及请求参数的转化
        return headLineService.queryHeadLine(null, 1, 100);
    }
}
