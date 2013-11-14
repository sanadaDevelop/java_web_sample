package jp.co.sample.dao;

import java.util.List;

import jp.co.sample.model.Point;
import jp.co.sample.model.User;
import jp.co.sample.model.mapper.PointMapper;
import jp.co.sample.model.mapper.UserMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PointDao {

    private SqlSessionFactory sessionFactory;

    public PointDao() {
        sessionFactory = DaoUtil.getSqlSessionFactory();
    }

    
    
    public List<Point> all() {
        SqlSession session = sessionFactory.openSession();
        PointMapper mapper = session.getMapper(PointMapper.class);
        List<Point> list = mapper.selectAll();
        session.close();

        return list;
    }
    
    public List<Point> allAtId(int id) {
        SqlSession session = sessionFactory.openSession();
        PointMapper mapper = session.getMapper(PointMapper.class);
        Point point = new Point();
        point.setUser_id(id);
        List<Point> list = mapper.selectAtId(point);
        session.close();

        return list;
    }

    public void insert(Point point) {
        SqlSession session = sessionFactory.openSession();
        PointMapper mapper = session.getMapper(PointMapper.class);
        mapper.insertPoint(point);
        session.commit();
        session.close();
    }
    
    public void update(Point point) {
        SqlSession session = sessionFactory.openSession();
        PointMapper mapper = session.getMapper(PointMapper.class);
        List<Point> points = mapper.selectAtId(point);
        point.setPoint(point.getPoint()+points.get(0).getPoint());
        mapper.updatePoint(point);
        session.commit();
        session.close();
    }
    
    
}
