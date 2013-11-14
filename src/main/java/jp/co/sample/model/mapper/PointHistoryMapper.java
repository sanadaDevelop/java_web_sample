package jp.co.sample.model.mapper;

import java.util.List;

import jp.co.sample.model.Point;
import jp.co.sample.model.PointHistory;

public interface PointHistoryMapper {
    List<PointHistory> selectAll();
    void insertPoint(PointHistory pointHistory);
}
