package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.User;

public class userOperation {
	
	public boolean userAdd(model.User user) throws SQLException {
		dao.User daoUser = new User(user);
		if(daoUser.add()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean userIsExists(model.User user)
	{
		dao.User daoUser = new User(user);
		if(daoUser.isExists()) {
			return true;
		}else {
			return false;
		}
	}
	
	public ResultSet getUserList() {
		dao.User daoUser = new User(null);
		return daoUser.getUserList();
	}
}
