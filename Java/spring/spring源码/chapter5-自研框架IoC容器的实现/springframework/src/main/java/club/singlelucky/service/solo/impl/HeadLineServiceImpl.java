package club.singlelucky.service.solo.impl;

import club.singlelucky.entity.bo.HeadLine;
import club.singlelucky.entity.dto.Result;
import club.singlelucky.service.solo.HeadLineService;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadline(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadline(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
