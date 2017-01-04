package cn.maiba;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;

public class DbcpConnectionPool {
    private static BasicDataSource dataSource = null;

    public DbcpConnectionPool() {

    }
    
    @Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
    	if(dataSource!=null && !dataSource.isClosed())
    		dataSource.close();
	}

	/**
     * 初始化数据库连接池
     */
    public static void init() 
    {
     	if (dataSource != null)
        {
            try
            {
                dataSource.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            dataSource = null;
        }

        //使用Properties对象定义数据库连接池信息
        try {
            Properties p = new Properties();
            p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
            p.setProperty("url", "jdbc:mysql://localhost:3306/maiba?useUnicode=true&characterEncoding=utf-8");
            p.setProperty("password", "1234");
            p.setProperty("username", "root");
            p.setProperty("maxActive", "30");
            p.setProperty("maxIdle", "10");
            p.setProperty("maxWait", "6000");
            p.setProperty("removeAbandoned", "false");
            p.setProperty("removeAbandonedTimeout", "120");
            p.setProperty("testOnBorrow", "true");
            p.setProperty("logAbandoned", "true");       
            //以指定信息创建数据源
            dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 从连接池中获取连接
     * @return
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws  SQLException {
        if (dataSource == null) {
            init();
        }
        Connection conn = null;
        if (dataSource != null) {
            conn = dataSource.getConnection();
        }
        return conn;
    }
}