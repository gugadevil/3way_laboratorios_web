package Data;

import java.sql.*;

public class TestaConexao {
	
	public static void main (String[] args) {
		Connection con;
		try {
			con= FabricaConexao.getConexao();
			if (con!=null)
				System.out.println("Conexao Estabelecida");
			
			con.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	
}
}