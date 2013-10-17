package jp.co.sample.dao;

import java.util.List;

import jp.co.sample.model.User;
import jp.co.sample.model.mapper.UserMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao {
	private SqlSessionFactory sessionFactory;

	public UserDao() {
		sessionFactory = DaoUtil.getSqlSessionFactory();
	}

	public List<User> all() {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectAll();
		session.close();

		return list;
	}
}
