package Data;

import java.sql.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FabricaConexao {
	
	public class FabricaConexao {
		static final String url = "jdbc:postgresql://5432/threeway";
		static final String usuario = "postegres";
		static final String senha = "123456";
		public static Connection getConexao() throws SQLException {
			
			try {
				Class.forName("org.postgresql.Driver");
				return DriverManager.getConnection(url, usuario, senha);
				
			}catch(ClassNotFoundException e) {
				throw new SQLException (e.getMessage());
			}
		}
	}

	public static Connection getconexao() {
		// TODO Auto-generated method stub
		return null;
	}
}
