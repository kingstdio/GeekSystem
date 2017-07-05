package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	 public static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	 public static final String userName = "root";   //用户名
	 public static final String userPasswd = "saadmin";  //密码
	 public static final String dbName = "db_geeksystem";  //数据库名称
	 public static final String DBURL = "jdbc:mysql://localhost:3306/"+dbName+"?user="+userName+"&password="+userPasswd;
	 public static java.sql.Connection conn =null;
 	 
	 /**
	  * 获得数据库连接
	  * @return
	  */
	 public static Connection getConnection(){		 
      try{
          	Class.forName(DBDRIVER);
          	return DriverManager.getConnection(DBURL);
      } catch (ClassNotFoundException | SQLException ex){
          System.out.println(ex.getMessage());
          return null;
      }
  }

	 /**
	  * 数据库测试
	  * @return 测试结果布尔型
	  */
	 public static boolean dbtest(){
		 try{
			 	getConnection();
			 	return true;
			 }catch(Exception e){
				 System.out.println(e.getMessage());
				 return false;
			 }
	 }
	 
	 public static ResultSet getResultSet(String sql){

		 try{
			 	conn = getConnection();
			 	PreparedStatement pstmt = conn.prepareStatement(sql) ;
			 	return (ResultSet) pstmt.executeQuery();
			 }catch(Exception e){
				 System.out.println(e.getMessage());
				 return null;
			 }
	 }
	 
	 public static ResultSet getResultSet(PreparedStatement pstmt){
		 try{			 	
			 	conn = getConnection();
			 	return (ResultSet) pstmt.executeQuery();
			 }catch(Exception e){
				 System.out.println(e.getMessage());
				 return null;
			 }
	 }
	 
	 /**
	  * 获取单一查询结果
	  * @param pstmt PreparedStatement
	  * @return 查询结果类型为字符串
	  * */
	 public static String getSingleResult(PreparedStatement pstmt){
		 String result="";
		 try{			 	
			 conn = getConnection();
			 ResultSet rs =pstmt.executeQuery();
			 if(rs.next()){
			 		result= rs.getString(1).toString();
			 	}
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }
		 return result;
	 }
	 
	 public static String getSingleResult(String sql){
		 String result="";
		 try{
			 	conn = getConnection();
			 	PreparedStatement pstmt = conn.prepareStatement(sql) ;
			 	ResultSet rs= (ResultSet) pstmt.executeQuery();
			 	if(rs.next()){
			 		result= rs.getString(1).toString();
			 	}
			 }catch(Exception e){
				 System.out.println(e.getMessage());
			 }
		 return result;
	 }
	 
	 public static int excuteNoneQuery(String sql){
		 int result=0;
		 try{
			 	conn = getConnection();
			 	PreparedStatement stmt = conn.prepareStatement(sql) ;
			 	result=  stmt.executeUpdate(sql);
			 	conn.close();
			 }catch(Exception e){
				 System.out.println(e.getMessage());
			 }
		 return result;
	 }
	 
	 public static int excuteNoneQuery(PreparedStatement stmt){
		 int result=0;
		 try{
			 	conn = getConnection();
			 	result=  stmt.executeUpdate();
			 	conn.close();
			 }catch(Exception e){
				 System.out.println(e.getMessage());
			 }
		 return result;
	 }
}
