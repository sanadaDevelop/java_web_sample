package jp.co.sample.model.mapper;

import java.util.List;

import jp.co.sample.model.Point;

public interface PointMapper {
    List<Point> selectAll();
    List<Point> selectAtId(Point point);
    void insertPoint(Point point);
    void updatePoint(Point point);
}
