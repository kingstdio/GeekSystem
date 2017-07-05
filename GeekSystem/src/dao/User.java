package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tools.MD5;
import tools.SqlHelper;

public class User {
	
	/**
	 * 用户模型对象
	 */
	public   model.User muser;
	
	/**
	 * sql语句字符串
	 */
	private String sql;
	
	/**
	 * sql 公用 PreparedStatement
	 */
	private PreparedStatement pst;
	
	
	/**
	 * 构造函数
	 * @param user
	 */
	public User(model.User user) {
		this.muser= user;
	}
	
	/**
	 * 添加用户
	 * @return
	 * @throws SQLException 
	 */
	public boolean add()  {
		sql ="INSERT INTO `tb_user` (`username`, `password`, `email`) VALUES (?, ?, ?)";
		try {
			pst =SqlHelper.getConnection().prepareStatement(sql);
			pst.setString(1, muser.getUserName());
			pst.setString(2, MD5.getMD5(muser.getPassword()));
			pst.setString(3, muser.getEmail());
			SqlHelper.excuteNoneQuery(pst);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断一个用户是否存在
	 * @return 存在：true；不存在：false；
	 */
	public boolean isExists() {
		sql ="select count(id) from tb_user WHERE username =?";
		
		try {
			pst =SqlHelper.getConnection().prepareStatement(sql);
			pst.setString(1, muser.getUserName());
			if(Integer.parseInt(SqlHelper.getSingleResult(pst))>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/***
	 * 获得用户列表
	 * @return 用户列表
	 */
	public ResultSet getUserList() {
		sql ="select id, username,password,email FROM tb_user";
		return SqlHelper.getResultSet(sql);
	}
}
