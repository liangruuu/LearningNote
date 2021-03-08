package club.singlelucky.service.solo;

import club.singlelucky.entity.bo.HeadLine;
import club.singlelucky.entity.dto.Result;

import java.util.List;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
public interface HeadLineService {
    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadline(int headLineId);

    Result<Boolean> modifyHeadline(HeadLine headLine);

    Result<HeadLine> queryHeadLineById(int headLineId);

    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);
}
