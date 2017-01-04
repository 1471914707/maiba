package cn.maiba;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDataBase {

	//用id来获取某一个数据库数据条，形成对象
	public static Object load(Class item,Object id){
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
	    try {
	    	conn = DbcpConnectionPool.getConnection();
			String sql = "SELECT * FROM "+item.getField("TABLE_NAME").get(item)+" Where id=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1,id);
			rs = ps.executeQuery();
			Object obj = null;
			if (rs != null && rs.next()){
				obj = createObject(rs, item);
			}	
			conn.close();
			rs.close();
			ps.close();
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//删除某条记录
	public static boolean delete(Class item, Object id){
		try {
			String sql = "delete from "+ item.getField("TABLE_NAME").get(item) +" where id=?";
			PreparedStatement ps = null;
	    	Connection conn = null;
			conn = DbcpConnectionPool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setObject(1,id);
			ps.executeUpdate();
			conn.close();
			ps.close();
			return true;
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public static  List select(Class item, String query){
		List list = new ArrayList();
    	Connection conn = null;
    	Statement ps = null;
    	ResultSet rs = null;
		try {
			String sql = "SELECT * FROM "+item.getField("TABLE_NAME").get(item);//tableName+" WHERE "+index+"=?";
			conn = DbcpConnectionPool.getConnection();
			sql += " where "+query;
			ps = conn.createStatement();
			 rs = ps.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					list.add(createObject(rs, item));
				}
			}
			conn.close();
			rs.close();
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	
	public static List list(Class item){
		List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
		try {
			String sql = "select * from "+ item.getField("TABLE_NAME").get(item);
			conn = DbcpConnectionPool.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs!=null){
				while(rs.next()){
					list.add(createObject(rs,item));
				}
			}
			conn.close();
			rs.close();
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	
	public static boolean save(Object obj){
    	Connection conn = null;
    	PreparedStatement ps = null;	
    	try {
        	String sql = "INSERT INTO "+obj.getClass().getField("TABLE_NAME").get(obj.getClass())+"(";//account,userName,age,password,email) VALUES(?,?,?,?,?)";
			conn = DbcpConnectionPool.getConnection();
			Field[] fields = obj.getClass().getDeclaredFields();
			Method[] methods = obj.getClass().getDeclaredMethods();
			Map colMap = new HashMap();
			int nCounter = 0;
			String strCounter = "";
			for (int i=0; i<fields.length;i++){
				if ("TABLE_NAME".equals(fields[i].getName()))
					continue;
				String methodName = "get"
					+ fields[i].getName().substring(0, 1).toUpperCase()
					+ fields[i].getName().substring(1);
				Method method = null;
				for (int j = 0; j < methods.length; j++) {
					if (methods[j].getName().equals(methodName)) {
						method = methods[j];
						break;
					}
				}
				Object col = method.invoke(obj);
				if(col != null){
					nCounter ++;
					colMap.put(nCounter, col);
					if(nCounter >1){
						sql += ",";
						strCounter +=",";	
					}
					sql += fields[i].getName();
					strCounter +="?";
				}
			}
			sql += ") value("+ strCounter + ")";
			ps = conn.prepareStatement(sql);
			for(int i=1; i<=colMap.size(); i++){
				ps.setObject(i, colMap.get(i));
			}
			ps.executeUpdate();
			conn.close();
			ps.close();	
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;	
		}
	}
	
	public static boolean update(Object obj){
    	Connection conn = null;
    	PreparedStatement ps = null;
    	try {
        	String strSQL = "UPDATE "+obj.getClass().getField("TABLE_NAME").get(obj.getClass()) +" set ";//account=?,userName=?,age=?,password=?,email=? WHERE id=?";
			Field[] fields = obj.getClass().getDeclaredFields(); // 获得类的数据成员
			Method[] methods = obj.getClass().getDeclaredMethods(); // 获得类的函数成员
			Map colMap = new HashMap();
			int nCounter = 0 ;
			String strCounter="";
			Object id = null;
			for (int i = 0; i < fields.length; i++) { // 对于类的每个数据成员
				if ("TABLE_NAME".equals(fields[i].getName()))
					continue; // 特殊数据成员，忽略不处理
				
				//根据变量名，构造其getter函数
				String methodName = "get"
						+ fields[i].getName().substring(0, 1).toUpperCase()
						+ fields[i].getName().substring(1);

				Method method = null;

				//根据getter函数名，找到对应的函数对象
				for (int j = 0; j < methods.length; j++) {
					if (methods[j].getName().equals(methodName)) {
						method = methods[j];
						break;
					}
				}

				//执行函数，得到值
				Object col = method.invoke(obj);
				if ("id".equals(fields[i].getName())){//如果是id，存起来
					id = col;
					if( id==null )//修改数据库表，是根据id的值来设置的，id必须不能为空，否则出错
						throw new Exception("修改数据出错！id 不能为空！");
				}else{
					if(col != null){//构造colname=?
						nCounter ++;
						colMap.put(nCounter, col);
						if(nCounter >1){
							strSQL += ",";
						}
						strSQL += fields[i].getName()+"=?";
					}
				}
			}
			strSQL += " where id=?"; //补齐sql语句的条件部分
        	conn = DbcpConnectionPool.getConnection();
			ps = conn.prepareStatement(strSQL);
			for(int i=1; i<=colMap.size(); i++){//设置参数
				ps.setObject(i, colMap.get(i));
			}
			ps.setObject(colMap.size()+1, id);//设置id
	    	ps.executeUpdate();
	    	conn.close();
	    	ps.close();
	    	return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
	public static boolean deleteRow(Class item, String query) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from "+ item.getField("TABLE_NAME").get(item) +" where "+query;
			PreparedStatement ps = null;
	    	Connection conn = null;
			conn = DbcpConnectionPool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.close();
			ps.close();
			return true;
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	public static int Count(Class item) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			String sql = "SELECT count(*) FROM "+ item.getField("TABLE_NAME").get(item);
			PreparedStatement ps = null;
	    	Connection conn = null;
	    	ResultSet rs = null;
			conn = DbcpConnectionPool.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			conn.close();
			ps.close();
			rs.close();
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 利用反射通过数据集创建对象 (要求pojo类的set方法名称必须是set+属性名，其中属性名首字母必须大写)
	 * 
	 * @param rs : 数据库中读取到的数据集
	 * @param obj ：要创建对象的名称
	 * @return ：数据集转化成 的类对象
	 * @throws Exception
	 */
	private static Object createObject(ResultSet rs,Class objClass) throws Exception{
		Object object = objClass.newInstance();
		Field[] fs = objClass.getDeclaredFields();
		Method[] mds = objClass.getDeclaredMethods();
		
		for (int i=0; i<fs.length; i++){
			if ("TABLE_NAME".equals(fs[i].getName()))//对于TABLE_NAME不处理
					continue;
			//根据变量名构造setter函数
			String methodName = "set"+fs[i].getName().substring(0,1).toUpperCase()
					+fs[i].getName().substring(1);
					
			Method method = null;
			//setter函数名，找到相应函数对象
			for (int j=0; j<mds.length;j++){
				if(mds[j].getName().equals(methodName)){
					method = mds[j];
					break;
				}
			}
			//执行函数
			method.invoke(object, new Object[]{rs.getObject(fs[i].getName())});
		}
		
		return object;		
	}

}
