package jp.co.sample.dao;

import java.util.List;

import jp.co.sample.model.PointHistory;
import jp.co.sample.model.mapper.PointHistoryMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PointHistoryDao {
    private SqlSessionFactory sessionFactory;

    public PointHistoryDao() {
        sessionFactory = DaoUtil.getSqlSessionFactory();
    }

    
    public List<PointHistory> all() {
        SqlSession session = sessionFactory.openSession();
        PointHistoryMapper mapper = session.getMapper(PointHistoryMapper.class);
        List<PointHistory> list = mapper.selectAll();
        session.close();

        return list;
    }
    
    public void insert(PointHistory pointHistory) {
        SqlSession session = sessionFactory.openSession();
        PointHistoryMapper mapper = session.getMapper(PointHistoryMapper.class);
        mapper.insertPoint(pointHistory);
        session.commit();
        session.close();
    }
    
    
    
    
}
