package jp.co.sample.model.mapper;

import java.util.List;
import jp.co.sample.model.User;

public interface UserMapper {
	List<User> selectAll();
}
