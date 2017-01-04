package cn.maiba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class textProdure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				
				Connection conn = DbcpConnectionPool.getConnection();
				//CallableStatement cstmt = (CallableStatement) conn.prepareCall("{call demo_out()}");
				java.sql.CallableStatement cstmt= conn.prepareCall("{call p_test()}");
				cstmt.executeUpdate();
/*				ResultSet rs = cstmt.getResultSet();
				while (rs.next()){
					System.out.println(rs.getInt("s"));
				}*/
				conn.close();
				//rs.close();
				cstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
	}

}
